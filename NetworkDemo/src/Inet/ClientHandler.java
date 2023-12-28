//package Inet;
//
//import java.io.*;
//import java.net.Socket;
//
//// Thread class to handle each client connection
//class ClientHandler implements Runnable {
//    private Socket client;
//    private PrintWriter pw;
//    private BufferedReader br;
//
//    public ClientHandler(Socket socket) {
//        this.client = socket;
//    }
//
//    @Override
//    public void run() {
//        try {
//            // Read data from the client
//            InputStream clientIn = client.getInputStream();
//            br = new BufferedReader(new InputStreamReader(clientIn));
//            String msgFromClient;
//            while ((msgFromClient = br.readLine()) != null) {
//                System.out.println("Message received from " + client.getInetAddress() + " is " + msgFromClient);
//
//                // Send response to the client
//                OutputStream clientOut = client.getOutputStream();
//                pw = new PrintWriter(clientOut, true);
//
//                if (msgFromClient.equalsIgnoreCase("Goodbye")) {
//                    pw.println("Goodbye");
//                    break;
//                } else {
//                    broadcastMessage(msgFromClient); // Broadcast the received message to all clients
//                }
//            }
//
//        } catch (IOException e) {
//            System.out.println("Error handling client request: " + e);
//        } finally {
//            try {
//                // Close resources
//                if (pw != null) pw.close();
//                if (br != null) br.close();
//                client.close();
//
//                // Remove the client handler from the list of clients
//                int index = clients.indexOf(this);
//                if (index != -1) {
//                    clients.remove(index);
//                }
//            } catch (IOException e) {
//                System.out.println("Error closing client connection: " + e);
//            }
//        }
//    }
//
//    // Broadcast the message to all connected clients
//    private void broadcastMessage(String message) {
//        for (ClientHandler client : clients) {
//            client.pw.println("Client [Host, Port] = [" + client.client.getInetAddress().getHostAddress() +
//                    ", " + client.client.getPort() + "]: " + message);
//        }
//    }
//}