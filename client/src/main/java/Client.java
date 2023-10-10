import java.net.Inet4Address;

public class Client {
    public static void main(String[] args) {
        int numRequests = 1000; // Número de solicitudes por cliente
        int sentRequests = 0;

        try (com.zeroc.Ice.Communicator communicator = com.zeroc.Ice.Util.initialize(args, "client.cfg")) {
            Demo.PrinterPrx chatManagerPrx = Demo.PrinterPrx
                    .checkedCast(communicator.propertyToProxy("Printer.Proxy")).ice_twoway();

            String hostname = Inet4Address.getLocalHost().getHostName();
            String username = System.getProperty("user.name");
            for (int i = 1; i <= numRequests; i++) {
                String userMessage = "" + Long.MAX_VALUE;
                Long start = System.currentTimeMillis();
                sentRequests++;

                String msg = chatManagerPrx.printString(username + ":" + hostname + " " + userMessage);
//                chatManagerPrx.printStringAsync(username + ":" + hostname + " " + userMessage);
                String latencyResponse = "\nLatency (response | less than 1000ms of testing throughput): " +
                        (System.currentTimeMillis() - start - 1000) + "ms";
                String requests = "\nSent requests (by this client): " + sentRequests;
                System.out.println(username + ":" + hostname + "\n" + msg + latencyResponse + requests + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}