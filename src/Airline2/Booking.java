package Airline2;

public class Booking {

    private final int bookingId;
    private Customer customer;
    private Flight flight;
    private String status;
    private int counter = 0;

    public Booking() {
        this(null, null);
    }

    public Booking(Customer customer, Flight flight) {
        bookingId = generateId();
        setCustomer(customer);
        setFlight(flight);
        setStatus("Not confirmed");
    }

    private int generateId() {
        int num = (int) (1000 * Math.random() + 1);
        return num;
    }

    public void display() {
        System.out.println("*** Booking Info ***");
        System.out.println("Booking id: " + getBookingId());
        System.out.println("Passenger: " + getCustomer());
        System.out.println("Flight #: " + getFlight().getNumber());
        System.out.println("Flying To: " + getFlight().getDirction());
        System.out.println("Status: " + getStatus());

    }

    //setters & getters
    public int getBookingId() {
        return bookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
