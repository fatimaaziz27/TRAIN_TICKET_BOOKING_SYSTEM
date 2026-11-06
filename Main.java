import java.util.*;

// Main class
public class Main {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Train> trains = new ArrayList<>();
    static HashMap<String, Booking> bookings = new HashMap<>();

    static int bookingCounter = 1;

    public static void main(String[] args) {

        // Adding trains
        trains.add(new Train(1, "Karachi - Lahore", "09:00 AM", 3000, 50));
        trains.add(new Train(2, "Karachi - Islamabad", "12:00 PM", 4000, 50));
        trains.add(new Train(3, "Lahore - Multan", "05:00 PM", 1500, 50));

        while (true) {

            System.out.println("\n0. Exit");
            System.out.println("1. View Train Schedules");
            System.out.println("2. Book Ticket");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View My Bookings");

            System.out.print("Enter your choice: ");
            int choice = readInt();

            switch (choice) {

                case 0:
                    System.out.println("Exiting Train Ticket Booking System...");
                    return;

                case 1:
                    viewTrains();
                    break;

                case 2:
                    bookTicket();
                    break;

                case 3:
                    cancelBooking();
                    break;

                case 4:
                    viewBookings();
                    break;

                default:
                    System.out.println("Invalid choice, try again!");
            }
        }
    }

    // Function to read integer input
    static int readInt() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // 1. View train schedules
    static void viewTrains() {

        System.out.println("\n--- Available Train Schedules ---");

        for (Train t : trains) {
            t.displayTrain();
        }
    }

    // 2. Book train ticket
    static void bookTicket() {

        viewTrains();

        System.out.print("\nEnter Train ID: ");
        int trainId = readInt();

        Train selectedTrain = null;

        for (Train t : trains) {
            if (t.getId() == trainId) {
                selectedTrain = t;
                break;
            }
        }

        if (selectedTrain == null) {
            System.out.println("Invalid Train ID!");
            return;
        }

        System.out.print("Enter passenger name: ");
        String name = sc.nextLine();

        System.out.print("Enter number of seats: ");
        int seats = readInt();

        if (seats <= 0) {
            System.out.println("Invalid number of seats!");
            return;
        }

        if (seats > selectedTrain.getAvailableSeats()) {
            System.out.println("Only "
                    + selectedTrain.getAvailableSeats()
                    + " seats available!");
            return;
        }

        selectedTrain.bookSeats(seats);

        String bookingId = "T" + bookingCounter++;

        Booking booking = new TrainBooking(
                bookingId, name, selectedTrain, seats
        );

        bookings.put(bookingId, booking);

        System.out.println("\nBooking successful!");
        booking.displayBooking();
    }

    // 3. Cancel booking
    static void cancelBooking() {

        System.out.print("Enter Booking ID to cancel: ");
        String bookingId = sc.nextLine();

        Booking booking = bookings.get(bookingId);

        if (booking != null) {

            booking.getTrain().releaseSeats(booking.getSeats());

            bookings.remove(bookingId);

            System.out.println("Booking cancelled successfully!");

        } else {
            System.out.println("Booking not found!");
        }
    }

    // 4. View bookings
    static void viewBookings() {

        if (bookings.isEmpty()) {
            System.out.println("No bookings available!");
            return;
        }

        System.out.println("\n--- Passenger Bookings ---");

        for (Booking b : bookings.values()) {
            b.displayBooking();
        }
    }
}


// Train class
class Train {

    // Encapsulation: Private attributes
    private int id;
    private String route;
    private String departureTime;
    private double ticketPrice;
    private int availableSeats;

    // Constructor
    Train(int id, String route, String departureTime,
          double ticketPrice, int availableSeats) {

        this.id = id;
        this.route = route;
        this.departureTime = departureTime;
        this.ticketPrice = ticketPrice;
        this.availableSeats = availableSeats;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getRoute() {
        return route;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    // Method to book seats
    public void bookSeats(int seats) {
        availableSeats -= seats;
    }

    // Method to release seats
    public void releaseSeats(int seats) {
        availableSeats += seats;
    }

    // Display train details
    public void displayTrain() {

        System.out.println(
                "ID: " + id
                + " | Route: " + route
                + " | Time: " + departureTime
                + " | Fare: Rs." + ticketPrice
                + " | Seats Left: " + availableSeats
        );
    }
}


// Abstract parent class
abstract class Booking {

    // Private attributes
    private String bookingId;
    private String passengerName;
    private Train train;
    private int seats;

    // Constructor
    Booking(String bookingId, String passengerName,
            Train train, int seats) {

        this.bookingId = bookingId;
        this.passengerName = passengerName;
        this.train = train;
        this.seats = seats;
    }

    // Getters
    public String getBookingId() {
        return bookingId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public Train getTrain() {
        return train;
    }

    public int getSeats() {
        return seats;
    }

    // Abstract methods
    abstract double calculateTotalFare();

    abstract void displayBooking();
}


// Child class
class TrainBooking extends Booking {

    // Constructor
    TrainBooking(String bookingId, String passengerName,
                 Train train, int seats) {

        super(bookingId, passengerName, train, seats);
    }

    // Method overriding (Polymorphism)
    @Override
    double calculateTotalFare() {

        return getTrain().getTicketPrice() * getSeats();
    }

    // Method overriding (Polymorphism)
    @Override
    void displayBooking() {

        System.out.println(
                "\nBooking ID: " + getBookingId()
                + " | Passenger: " + getPassengerName()
                + " | Route: " + getTrain().getRoute()
                + " | Time: " + getTrain().getDepartureTime()
                + " | Seats: " + getSeats()
                + " | Total Fare: Rs." + calculateTotalFare()
        );
    }
}
