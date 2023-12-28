//package Inet;
//
//import java.net.*;
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//public class Server {
//    private static List<ClientHandler> clients = new ArrayList<>();
//    private static ExecutorService executorService = Executors.newFixedThreadPool(10);
//
//    public static void main(String[] args) {
//        ServerSocket server = null;
//
//        // Default port number we are going to use
//        int portNumber = 1234;
//        if (args.length >= 1) {
//            portNumber = Integer.parseInt(args[0]);
//        }
//
//        // Create Server side socket
//        try {
//            server = new ServerSocket(portNumber);
//        } catch (IOException e) {
//            System.out.println("Cannot open socket: " + e);
//            System.exit(1);
//        }
//        System.out.println("ServerSocket is created: " + server);
//
//        // Wait for the data from the client and create a new thread to handle each client
//        while (true) {
//            try {
//                System.out.println("--------------------------------------------------------------------------");
//                System.out.println("Waiting for connect request...");
//                Socket client = server.accept();
//                System.out.println("Connect request is accepted...");
//                String clientHost = client.getInetAddress().getHostAddress();
//                int clientPort = client.getPort();
//                System.out.println("Client [Host, Port] = [" + clientHost + ", " + clientPort + "]");
//
//                // Create a new thread to handle the client connection
//                ClientHandler clientHandler = new ClientHandler(client);
//                clients.add(clientHandler); // Add the client handler to the list of clients
//                executorService.execute(clientHandler);
//
//            } catch (IOException e) {
//                System.out.println("Error handling client request: " + e);
//            }
//        }
//    }
//}