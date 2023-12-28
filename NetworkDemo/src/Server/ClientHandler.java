package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread {
    private Server server;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private String clientName;

    public ClientHandler(Server server, Socket clientSocket) {
        this.server = server;
        this.clientSocket = clientSocket;
    }

    public String getClientName() {
        return clientName;
    }

    public void sendMessage(String message) {
        out.println(message);
    }

    @Override
    public void run() {
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Read the client's name
            clientName = in.readLine();
            System.out.println("Client " + clientName + " connected.");

            String message;
            while ((message = in.readLine()) != null) {
                server.broadcastMessage(message, this);
            }
        } catch (IOException e) {
            System.out.println("Error handling client " + clientName + ": " + e.getMessage());
        } finally {
            try {
                in.close();
                out.close();
                clientSocket.close();
                server.removeClient(this);
                System.out.println("Client " + clientName + " disconnected.");
            } catch (IOException e) {
                System.out.println("Error closing client connection: " + e.getMessage());
            }
        }
    }
}