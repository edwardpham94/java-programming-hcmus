package client;

import share_entity.Ticket;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8080);
            System.out.println("Connected to server: " + socket.getInetAddress() + ":" + socket.getPort());

            BufferedReader stdReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            while (true) {
                System.out.println("Commands: find ticket, buy ticket, exit");
                System.out.print("Enter command: ");
                String command = stdReader.readLine();

                if (command.equals("exit")) {
                    break;
                }

                out.println(command);

                switch (command) {
                    case "find ticket":
                        System.out.print("Enter film name: ");
                        String filmName = stdReader.readLine();
                        out.println(filmName);

                        InputStream inputStream = socket.getInputStream();
                        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

                        @SuppressWarnings("unchecked")
                        ArrayList<Ticket> tickets = (ArrayList<Ticket>) objectInputStream.readObject();

                        System.out.println("Tickets: ");
                        for (Ticket ticket : tickets) {
                            System.out.println(ticket.getInfo());
                        }
                        break;
                    case "buy ticket":
                        System.out.print("Enter ticket id: ");
                        String ticketId = stdReader.readLine();
                        out.println(ticketId);

                        System.out.print("Enter buyer name: ");
                        String buyerName = stdReader.readLine();
                        out.println(buyerName);

                        System.out.println(in.readLine());
                        break;
                }
            }

            stdReader.close();
            in.close();
            out.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
