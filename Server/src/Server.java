package Server;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static List<ClientHandler> clients = new ArrayList<>();
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        ServerSocket server = null;

        // Default port number we are going to use
        int portNumber = 1234;
        // Create Server side socket
        try {
            server = new ServerSocket(portNumber);
        } catch (IOException e) {
            System.out.println("Cannot open socket: " + e);
            System.exit(1);
        }
        System.out.println("ServerSocket is created: " + server);

        // Wait for the data from the client and create a new thread to handle each client
        while (true) {
            try {
                System.out.println("--------------------------------------------------------------------------");
                System.out.println("Waiting for connect request...");
                Socket client = server.accept();
                System.out.println("Connect request is accepted...");
                String clientHost = client.getInetAddress().getHostAddress();
                int clientPort = client.getPort();
                System.out.println("Client [Host, Port] = [" + clientHost + ", " + clientPort + "]");

                // Create a new thread to handle the client connection
                ClientHandler clientHandler = new ClientHandler(client);
                clients.add(clientHandler); // Add the client handler to the list of clients
                executorService.execute(clientHandler);

            } catch (IOException e) {
                System.out.println("Error handling client request: " + e);
            }
        }
    }

    // Thread class to handle each client connection
    static class ClientHandler implements Runnable {
        private Socket client;
        private PrintWriter pw;
        private BufferedReader br;

        public ClientHandler(Socket socket) {
            this.client = socket;

            try {
                OutputStream clientOut = client.getOutputStream();
                pw = new PrintWriter(clientOut, true);
            } catch (IOException e) {
                System.out.println("Error creating PrintWriter: " + e);
            }
        }

        @Override
        public void run() {
            try {
                // Read data from the client
                InputStream clientIn = client.getInputStream();
                br = new BufferedReader(new InputStreamReader(clientIn));
                String msgFromClient;
                while ((msgFromClient = br.readLine()) != null) {
                    System.out.println("Message received from " + client.getInetAddress() + " is " + msgFromClient);

                    // Send response to the client
                    if (msgFromClient.equalsIgnoreCase("Goodbye")) {
                        pw.println("Goodbye");
                        break;
                    } else {
                        //broadcastMessage(ms  gFromClient); // Broadcast the received message to all clients
                    }
                }

            } catch (SocketException e) {
                System.out.println("Connection closed by the client: " + e);
            } catch (IOException e) {
                System.out.println("Error handling client request: " + e);
            } finally {
                // Close resources and remove the client handler from the list of clients
                try {
                    if (pw != null) pw.close();
                    if (br != null) br.close();
                    client.close();
                    clients.remove(this);
                } catch (IOException e) {
                    System.out.println("Error closing client connection: " + e);
                }
            }
        }

        // Broadcast the message to all connected clients
        private void broadcastMessage(String message) {
            for (ClientHandler client : clients) {
                if (client.pw != null) {
                    executorService.execute(() -> {
                        client.pw.println("Client [Host, Port] = [" + client.client.getInetAddress().getHostAddress() +
                                ", " + client.client.getPort() + "]: " + message);
                    });
                }
            }
        }

        private void multipleBoardcastMessage(String msg){
            for (ClientHandler client : clients){
                //if (client)
            }
        }
    }
}