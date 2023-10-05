public class Server {
    public static void main(String[] args) {
        System.out.println("SERVIDOR ABIERTO");
        try (com.zeroc.Ice.Communicator communicator = com.zeroc.Ice.Util.initialize(args, "server.cfg")) {
            com.zeroc.Ice.ObjectAdapter adapter = communicator.createObjectAdapter("Service");
            com.zeroc.Ice.Object object = new PrinterI(communicator);
            adapter.add(object, com.zeroc.Ice.Util.stringToIdentity("SimplePrinter"));
            adapter.activate();
            communicator.waitForShutdown();
        }
    }
}