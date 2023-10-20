// Copyright (c) ZeroC, Inc. All rights reserved.
//

import Demo.CallbackReceiverPrx;
import Demo.CallbackSender;
import com.zeroc.Ice.Current;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CallbackSenderI implements CallbackSender
{
    // performance
    long start_time;
    long latency_process;
    int requests_received;
    int requests_answered;
    String message;
    HashMap<String, CallbackReceiverPrx> clients = new HashMap<>();
    HashMap<String, Boolean> discClients = new HashMap<>();
    List< String[] > messagesPending = new ArrayList<>();
    List<String> clients_registered = new ArrayList<>();
    boolean flag;

    @Override
    public void message(CallbackReceiverPrx proxy, String msg, Current current) {
        requests_received += 1;
        message = msg;
        start_time = System.currentTimeMillis();

        System.out.println("\nExecuting -> " + msg);
        String[] msg_parts = msg.split("->");

        if(msg_parts.length == 1){
            latency_process = System.currentTimeMillis() - start_time;
            requests_answered += 1;
            flag = true;
            proxy.callback("Ups! Type a valid message" + getPerformance(current));
        }

        if(msg_parts[1].equalsIgnoreCase("shutdown")){
            shutdown(current);
        }

        String real_msg = msg_parts[1];

        try {
            Long num = Long.parseLong(real_msg);

            if(num <= 0 || msg_parts.length >= 3){
                latency_process = System.currentTimeMillis() - start_time;
                requests_answered += 1;
                flag = true;
                proxy.callback("Ups! Type a valid number" + getPerformance(current));
            }

            String prime = prime_factors(num);
            latency_process = System.currentTimeMillis() - start_time;
            requests_answered += 1;
            flag = true;
            proxy.callback(prime+ getPerformance(current));
        } catch (NumberFormatException e) {
            String[] real_msg_parts = null;
            String msg_type = "";

            if(real_msg.startsWith("listifs")){
                real_msg_parts = real_msg.split("listifs");
                msg_type = "listifs";
            } else if(real_msg.startsWith("listports")){
                real_msg_parts = (real_msg).split("listports ");
                msg_type = "listports";
            } else if(real_msg.startsWith("!")){
                if(msg_parts.length >= 3) {
                    String acc = "";

                    for (int i = 2; i < msg_parts.length; i++){
                        acc = (real_msg + " " + msg_parts[i]);
                    }

                    real_msg_parts = acc.split("!");
                } else {
                    real_msg_parts = (real_msg).split("!");
                }
                msg_type = "!";
            } else if(real_msg.equalsIgnoreCase("exit")){
                msg_type = "exit";

            } else if (real_msg.equalsIgnoreCase("list clients")){
                latency_process = System.currentTimeMillis() - start_time;
                requests_answered += 1;
                flag = true;
                proxy.callback(listRegisteredClients(current)+getPerformance(current));

            } else if (real_msg.startsWith("to ") && real_msg.contains(":")) {
                String[] parts0 = real_msg.split(":");
                String[] parts1 = new String[5];

                try {
                    parts1 = parts0[0].split(" ");
                } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                    flag = true;
                    proxy.callback("Ups! Type a valid message"+getPerformance(current));
                }

                messageToHostname(proxy, parts1[1], parts0[1], current);
            } else if (real_msg.startsWith("BC ")) {
                String[] parts = real_msg.split("BC");

                try {
                    for (String s : clients_registered) {
                        try {
                            if (!s.equals(Inet4Address.getLocalHost().getHostName())){
                                messageToHostname(proxy, s, parts[1], current);
                            }
                        } catch (UnknownHostException unknownHostException){
                            proxy.callback(unknownHostException.getMessage()+getPerformance(current));
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                    flag = true;
                    proxy.callback("Ups! Type a valid message"+getPerformance(current));
                }
            } else {
                flag = true;
                proxy.callback("Ups! Type a valid message"+getPerformance(current));
            }

            if(!msg_type.equalsIgnoreCase("exit")){
                if(verify_msg(real_msg_parts, msg_type, current)){
                    requests_answered += 1;
                    proxy.callback(execute_command(real_msg_parts, msg_type, current));
                } else if(!flag) {
                    requests_answered += 1;
                    latency_process = System.currentTimeMillis() - start_time;
                    proxy.callback ("Ups! Type a valid message" + getPerformance(current));
                }
            }

            flag = false;
        }
    }

    public boolean verify_msg(String[] real_msg_parts, String msg_type, Current current){
        switch (msg_type){
            case "listifs":
                return (real_msg_parts.length == 0);
            case "listports":
                if(real_msg_parts.length == 2){
                    return (real_msg_parts[1].split(" ").length == 1);
                } else {
                    return false;
                }
            case "!":
                return (real_msg_parts.length == 2);
            default:
                return false;
        }
    }

    private String execute_command(String[] real_msg_parts, String msg_type, Current current){
        try {
            if(msg_type.equalsIgnoreCase("listifs")){
                return command("ifconfig", current);
            } else if(msg_type.equalsIgnoreCase("listports")){
                String ip = real_msg_parts[1].split(" ")[0];
                return command("nmap " + ip, current);
            } else {
                return command(real_msg_parts[1], current);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private String command(String command, Current current) throws IOException {
        String result = "";
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String resultExecution;
        try {
            while ((resultExecution = br.readLine()) != null) {
                result += resultExecution + "\n";
            }
        } catch (IOException ioException){
            return "Command didn't execute correctly";
        }

        latency_process = System.currentTimeMillis() - start_time;
        return (result + getPerformance(current));
    }

    @Override
    public void notifyClient(String hostname, Current current) {
        discClients.put(hostname, false);
    }

    @Override
    public void messageToHostname(CallbackReceiverPrx proxy, String hostname, String msg, Current current) {
        try {
            latency_process = System.currentTimeMillis() - start_time;
            requests_answered += 1;
            flag = true;
            // añadir si no está el usuario, guarda msje pendiente
            //try {
            if (discClients.get(hostname) == null){
                clients.get(hostname).callback(msg+getPerformance(current));
                proxy.callback("Message sent"+getPerformance(current));
            } else {
                String[] msgsTo = new String[2];
                msgsTo[0] = hostname;
                msgsTo[1] = msg+getPerformance(current);
                messagesPending.add(msgsTo);
                proxy.callback("User disconnected. Message sent"+getPerformance(current));
            }
        } catch (NullPointerException nullPointerException){
            latency_process = System.currentTimeMillis() - start_time;
            requests_answered += 1;
            flag = true;
            proxy.callback("Cliente no registrado"+getPerformance(current));
        }
    }

    @Override
    public void initiateCallback(String hostname, CallbackReceiverPrx proxy, com.zeroc.Ice.Current current)
    {
        // cuando se conecte otra vez un usuario, si ya estba registrado y tiene msjes pendientes, se le muestran
        clients.put(hostname, proxy);
        clients_registered.add(hostname);
        boolean flag = false;

        for (int i = 0; i < messagesPending.size(); i++) {
            if (messagesPending.get(i)[0].equals(hostname)){
                flag = true;
                clients.get(hostname).callback(messagesPending.get(i)[1]);
            }
        }

        if (flag){
            discClients.remove(hostname);
        }
    }

    @Override
    public void shutdown(com.zeroc.Ice.Current current)
    {
        System.out.println("Shutting down...");
        try
        {
            latency_process = System.currentTimeMillis() - start_time;
            requests_answered += 1;
            current.adapter.getCommunicator().shutdown();
        }
        catch(com.zeroc.Ice.LocalException ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    public String listRegisteredClients(Current current) {
        StringBuilder clients_msg = new StringBuilder();

        for (int i = 0; i < clients.size(); i++) {
            clients_msg.append(i+1).append(") ").append(clients_registered.get(i)).append("\n");
        }

        return "List of clients:\n" + clients_msg;
    }

    public String prime_factors(Long num){
        StringBuilder primeFactors = new StringBuilder();

        for (long i = 2; i <= num; i++) {
            while (num % i == 0) {
                primeFactors.append(i);
                if (i != num) {
                    primeFactors.append(", ");
                }
                num /= i;
            }
        }

        return primeFactors.toString();
    }

    public String getPerformance(Current current) {
        return getRequestsReceived(current) + getRequestsAnswered(current) + getLatencyProcess(current) + getThroughput(current);
    }

    public String getRequestsAnswered(Current current) {
        return ("\nUnprocessed rate: " + (requests_received - requests_answered));
    }

    public String getRequestsReceived(Current current) {
        return ("\nRequests received (server): " + requests_received);
    }

    public String getLatencyProcess(Current current) {
        return ("\nLatency (process): " + latency_process +  "ms");
    }

    public String getThroughput(Current current) {
        long start_time = System.currentTimeMillis();
        int executed_commands = 0;

        while (true) {
            // Simular el procesamiento del comando por parte del servidor
            messageToSimulate(message, current);
            if (System.currentTimeMillis() - start_time >= 1000) {
                break;
            }
            executed_commands++;
        }

        return ("\nThroughput (of this command): " + executed_commands);
    }

    public void messageToSimulate(String message, Current current){
        if (message.contains("list clients")){
            String result = listRegisteredClients(current);
        } else if (message.contains("to") && message.contains(":")) {
            String[] parts0 = message.split(":");
            String[] parts1 = new String[5];

            try {
                parts1 = parts0[0].split(" ");
            } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                String result = "Type a valid msg";
            }

            // message to hostname
            try {
                clients.get("");
            } catch (NullPointerException nullPointerException){
                String result = "Cliente no registrado";
            }
        } else if (message.contains("BC")) {
            String[] parts = message.split("BC");

            try {
                for (String s : clients_registered) {
                    String result = s.toString();
                }
            } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                String result = "Type a valid msg";
            }
        }
    }
}
