package server;

import share_entity.Ticket;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class SocketThread extends Thread {
    ConnectionEntity client;

    public SocketThread(Socket client) throws IOException {
        this.client = new ConnectionEntity(client);
    }

    @Override
    public void run() {
        do {
            try {
                String header = this.client.readMessage();

                switch (header) {
                    case "find ticket":
                        ArrayList<Ticket> tickets = Ticket.findTicketsByFilmName(this.client.readMessage());
                        this.client.sendObject(tickets);
                        break;
                    case "buy ticket":
                        String ticketId = this.client.readMessage();
                        String buyerName = this.client.readMessage();
                        this.client.sendMessage(Ticket.buyTicket(ticketId, buyerName));
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error reading message: " + e.getMessage());
                this.client.close();
            }
        } while (!this.client.isClosed());
    }
}
