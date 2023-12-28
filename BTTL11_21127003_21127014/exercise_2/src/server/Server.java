package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public static ArrayList<ConnectionEntity> connections = new ArrayList<>();
    private ServerSocket serverSocket;

    public static void main(String[] args) {
        Server socketServer = new Server();

        try {
            socketServer.openServerSocket(8080);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            socketServer.closeServerSocket();
        }
    }

    public void openServerSocket(int portNumber) {
        try {
            this.serverSocket = new ServerSocket(portNumber);
            System.out.println("Server started on port " + portNumber);
            new Thread(() -> {
                try {
                    do {
                        Socket clientSocket = serverSocket.accept();
                        System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress()
                                + "on port " + clientSocket.getPort());

                        SocketThread clientCommunicator = new SocketThread(clientSocket);
                        clientCommunicator.start();
                    } while (this.serverSocket != null && !this.serverSocket.isClosed());
                } catch (IOException e) {
                    System.out.println("Error accepting client socket: " + e.getMessage());
                    throw new RuntimeException(e);
                }
            }).start();

        } catch (Exception e) {
            System.out.println("Error opening server socket: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void closeServerSocket() {
        try {
            if (this.serverSocket != null && !this.serverSocket.isClosed()) {
                this.serverSocket.close();
            }
        } catch (Exception e) {
            System.out.println("Error closing server socket: " + e.getMessage());
        }
    }
}
