package share_entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;

public class Ticket implements Serializable {
    private final String filmName;
    private final String id;

    private final String seat;

    private final String date;

    private final int hour;
    private final int minute;

    private final int price;

    private String buyerName;

    public Ticket(String id, String filmName, String seat, String date, int hour, int minute, int price, String buyerName) {
        this.id = id;
        this.filmName = filmName;
        this.seat = seat;
        this.date = date;
        this.hour = hour;
        this.minute = minute;
        this.price = price;
        this.buyerName = buyerName;
    }

    public static ArrayList<Ticket> loadTicketsFromFile(String filePath) {
        ArrayList<Ticket> tickets = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] ticketData = line.split(",");
                tickets.add(new Ticket(ticketData[0], ticketData[1], ticketData[2], ticketData[3],
                        Integer.parseInt(ticketData[4]), Integer.parseInt(ticketData[5]), Integer.parseInt(ticketData[6]), ticketData[7]));
            }
            return tickets;
        } catch (Exception e) {
            System.out.println("Error loading tickets from file: " + e.getMessage());
            return null;
        }
    }

    public static void saveTicketsToFile(String filePath, ArrayList<Ticket> tickets) {
        try (java.io.FileWriter fw = new java.io.FileWriter(filePath)) {
            for (Ticket ticket : tickets) {
                fw.write(ticket.getId() + "," + ticket.getFilmName() + "," + ticket.getSeat() + "," + ticket.getDate() + "," +
                        ticket.getHour() + "," + ticket.getMinute() + "," + ticket.getPrice() + "," + ticket.getBuyerName() + "\n");
            }
        } catch (Exception e) {
            System.out.println("Error saving tickets to file: " + e.getMessage());
        }
    }

    public static ArrayList<Ticket> findTicketsByFilmName(String filmName) {
        ArrayList<Ticket> tickets = loadTicketsFromFile("data.txt");
        ArrayList<Ticket> foundTickets = new ArrayList<>();

        if (tickets == null) {
            return null;
        }

        for (Ticket ticket : tickets) {
            if (ticket.getFilmName().contains(filmName)) {
                foundTickets.add(ticket);
            }
        }

        return foundTickets;
    }

    public static String buyTicket(String id, String buyerName) {
        ArrayList<Ticket> tickets = loadTicketsFromFile("data.txt");

        if (tickets == null) {
            return "Error loading tickets from file";
        }

        for (Ticket ticket : tickets) {
            if (ticket.getId().equals(id)) {
                if (ticket.getBuyerName().equals("null")) {
                    ticket.buyerName = buyerName;
                    saveTicketsToFile("data.txt", tickets);
                    return "Ticket bought successfully";
                } else {
                    return "Ticket already bought";
                }
            }
        }

        return "Ticket not found";
    }

    public String getInfo() {
        return "ID: " + this.id + "\t|" +
                "Film name: " + this.filmName + "\t|" +
                "Seat: " + this.seat + "\t|" +
                "Date: " + this.date + "\t|" +
                "Time: " + this.hour + ":" + this.minute + "|" +
                "Price: " + this.price + "\t|" +
                "Buyer name: " + this.buyerName + "\n";
    }

    public String getFilmName() {
        return filmName;
    }

    public String getId() {
        return id;
    }

    public String getSeat() {
        return seat;
    }

    public String getDate() {
        return date;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getPrice() {
        return price;
    }

    public String getBuyerName() {
        return buyerName;
    }

}
