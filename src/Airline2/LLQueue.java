package Airline2;
// customer

import java.util.Scanner;

public class LLQueue<E> {

    static class Node<E> {

        private E element; // reference to the element stored at this node
        private Node<E> next; // reference to the subsequent node in the list

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }

        public void setelement(E element) {
            this.element = element;
        }
    }
    protected Node<E> front;
    protected Node<E> rear;
    protected long size;

    public LLQueue() { // constructor
        front = null;
        rear = null;
        size = 0;
    }

    public long getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() { // returns (but does not remove) the first element
        if (isEmpty()) {
            return null;
        }
        return front.getElement();
    }

    public E last() { // returns (but does not remove) the last element
        if (isEmpty()) {
            return null;
        }
        return rear.getElement();
    }

    public void Enqueue(E elem) {
        Node<E> newest = new Node<E>(elem, null);
        if (isEmpty()) {
            front = newest; // special case of a previously empty queue 
        } else {
            rear.setNext(newest); // add node at the tail of the list 
        }
        rear = newest; // update the reference to the tail node 
        size++;
    }

    public E Dequeue() {
        if (isEmpty()) {
            return null;
        }
        E answer = front.getElement();
        front = front.getNext();
        size--;
        if (size == 0) {
            rear = null; // the queue is now empty
        }
        return answer;
    }

    public void display() {

        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        long s = getSize();
        for (int i = 0; i < s; i++) {
            E ele = Dequeue();
            System.out.println(ele);
            Enqueue(ele);
        }
    }

    public void scheduleFlight() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter flight number: ");
        int flightNumber = input.nextInt();
        input.nextLine();
        System.out.print("Enter flight name: ");
        String n = input.nextLine();
        System.out.print("Enter flight Dirction: ");
        String Dirction = input.nextLine();

        Flight flight = new Flight(n, flightNumber, Dirction);

        Enqueue((E) flight);
        System.out.println("The flight has been scheduled and added to the queue!");

    }

    public void cancelFlight() {

        if (isEmpty()) {
            System.out.println("There is no flights to cancel!");
        }

        Scanner input = new Scanner(System.in);
        System.out.print("Enter flight number: ");
        int flightNumber = input.nextInt();

        boolean found = false;
        long size = getSize();
        for (int i = 0; i < size; i++) {
            Flight f = (Flight) Dequeue();
            if (f.getNumber() == (flightNumber)) {
                found = true;
                System.out.println("Flight has been canceled!");
            } else if (f.getNumber() != (flightNumber)) {
                Enqueue((E) f);

            }
        }//end forthis number!");

    }

    public void displayFlights() {
        if (isEmpty()) {
            System.out.println("No scheduled flights yet!");
        } else {
            System.out.println("<<< Flights in Queue >>>");
            long size = getSize();
            for (int i = 0; i < size; i++) {
                Flight f = (Flight) Dequeue();
                System.out.println("The flight " + f.getNumber() + " is flying to " + f.getDirction());
                System.out.println("-----------------------------------");
                Enqueue((E) f);
            }

        }
    }

    public void searchFlight() {

        boolean found = false;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of the flight: ");
        int flightNumber = input.nextInt();

        System.out.println("* Flights *");
        long size = getSize();
        for (int i = 0; i < size; i++) {
            Flight f = (Flight) Dequeue();
            if (f.getNumber() == (flightNumber)) {
                if (f.isAvailable()) {
                    System.out.println("The flight " + f.getNumber() + " is flying to " + f.getDirction());
                    System.out.println("-----------------------------------");
                    found = true;
                }
            }
            Enqueue((E) f);
        }//end for

        if (!found) {
            System.out.println("Sorry, there are no flights with this number!");
        }

    }

    public void displayFlightInfo() {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter flight number: ");
        int flightNumber = input.nextInt();

        Flight flight = getFlight(flightNumber);
        if (flight != null) {
            flight.display();
        } else {
            System.out.println("Sorry, there are no flights with this number!");
        }
    }

    public Flight getFlight(int flightNumber) {
        Flight flight = null;
        long size = getSize();
        for (int i = 0; i < size; i++) {
            Flight f = (Flight) Dequeue();
            if (f.getNumber() == (flightNumber)) {
                flight = f;
            }
            Enqueue((E) f);
        }//end for
        return flight;
    }

    //landing
    //booking
    public void bookFlight() {// for customer
        Scanner input = new Scanner(System.in);
        System.out.print("Enter flight number: ");
        int flightNumber = input.nextInt();
        //check flight
        Flight flight = getFlight(flightNumber);
        if (flight == null) {
            System.out.println("Sorry, there are no flights with this number!");
            return;//exit
        }

        //enter passenger info
        input.nextLine();
        System.out.print("Enter your full name: ");
        String fullName = input.nextLine();
        System.out.print("Enter your phone number: ");
        int phoneNum = input.nextInt();
        System.out.print("Enter your passport number: ");
        int passportNum = input.nextInt();
        Customer passenger = new Customer(fullName, phoneNum, passportNum);

        if (flight.isAvailable()) {
            Booking booking = new Booking(passenger, flight);
            flight.addCustomer(passenger);
            booking.setStatus("Confirmed.");
            booking.display();
            System.out.println("Your booking was successful!");
        }

    }

    public void remove(Customer c) {
        Scanner input = new Scanner(System.in);
        LLQueue<Customer> Customer = new LLQueue<>();;

        long size = getSize();
        System.out.print("Enter the flight number : ");
        int num = input.nextInt();
        for (int i = 0; i < size; i++) {
            Flight f = (Flight) Dequeue();
            if (f.getNumber() == num) {

                if (c.getPassport() == f.getCustomers().first().getPassport()) {
                    System.out.println("Customer removed successfully.");
                    f.removeCustomer();

                } else {
                    System.out.println("Customer with this passaport is not found!");
                }

            }
            Enqueue((E) f);

        }

    }

    public void add() {
        Scanner input = new Scanner(System.in);
        LLQueue<Customer> Customer = new LLQueue<>();;

        long size = getSize();
        System.out.print("Enter the flight number : ");
        int num = input.nextInt();

        Flight flight = getFlight(num);
        if (flight == null) {
            System.out.println("Flight with this number is not found!");
            return;
        }

        System.out.print("Enter name: ");
        String name = input.next();

        System.out.print("Enter passport: ");
        int pass = input.nextInt();

        System.out.print("Enter phone number:");
        int ph = input.nextInt();

        Customer passenger = new Customer(name, pass, ph);
        flight.addCustomer(passenger);
    }

    public void sum() {
        Scanner input = new Scanner(System.in);
        LLQueue<Customer> Customer = new LLQueue<>();

        long size = getSize();
        System.out.print("Enter the flight number : ");
        boolean flag = false;

        int num = input.nextInt();

        Flight flight = getFlight(num);

        int sumAll = flight.customersSum();
        if (Customer.isEmpty()) {
            System.out.println("There is no customer in flight >> " + flight.getNumber());
        }
        System.out.println("Customer in flight " + flight.getNumber() + " : " + sumAll);

    }

}
