class Ticket {
    int ticketID;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    private Ticket last;
    private int totalTickets;

    public TicketReservationSystem() {
        this.last = null;
        this.totalTickets = 0;
    }

    public void addTicket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketID, customerName, movieName, seatNumber, bookingTime);
        if (last == null) {
            last = newTicket;
            last.next = last;
        } else {
            newTicket.next = last.next;
            last.next = newTicket;
            last = newTicket;
        }
        totalTickets++;
    }

    public void removeTicket(int ticketID) {
        if (last == null) {
            System.out.println("No tickets to remove.");
            return;
        }
        Ticket current = last, prev = null;
        do {
            if (current.ticketID == ticketID) {
                if (current == last && current.next == last) {
                    last = null;
                } else {
                    if (current == last) {
                        last = prev;
                    }
                    prev.next = current.next;
                }
                totalTickets--;
                System.out.println("Ticket removed: " + ticketID);
                return;
            }
            prev = current;
            current = current.next;
        } while (current != last.next);
        System.out.println("Ticket not found.");
    }

    public void displayTickets() {
        if (last == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket temp = last.next;
        do {
            System.out.println("Ticket ID: " + temp.ticketID + ", Customer: " + temp.customerName + ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Booking Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != last.next);
    }

    public void searchTicketByCustomer(String customerName) {
        if (last == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket temp = last.next;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(customerName)) {
                System.out.println("Ticket ID: " + temp.ticketID + ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber);
                found = true;
            }
            temp = temp.next;
        } while (temp != last.next);
        if (!found) {
            System.out.println("No tickets found for customer: " + customerName);
        }
    }

    public void searchTicketByMovie(String movieName) {
        if (last == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket temp = last.next;
        boolean found = false;
        do {
            if (temp.movieName.equalsIgnoreCase(movieName)) {
                System.out.println("Ticket ID: " + temp.ticketID + ", Customer: " + temp.customerName + ", Seat: " + temp.seatNumber);
                found = true;
            }
            temp = temp.next;
        } while (temp != last.next);
        if (!found) {
            System.out.println("No tickets found for movie: " + movieName);
        }
    }

    public int getTotalTickets() {
        return totalTickets;
    }
}

public class TicketReservationApp {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();
        system.addTicket(101, "John Doe", "Inception", "A1", "10:00 AM");
        system.addTicket(102, "Jane Doe", "Inception", "A2", "10:00 AM");
        system.addTicket(103, "Alice Smith", "Avatar", "B1", "1:00 PM");
        
        system.displayTickets();
        
        system.searchTicketByCustomer("John Doe");
        system.searchTicketByMovie("Avatar");
        
        system.removeTicket(102);
        system.displayTickets();
        
        System.out.println("Total tickets booked: " + system.getTotalTickets());
    }
}

