package Airline2;

import java.util.Scanner;

public class Flight implements BookAble {

    // 3 attributes
    private String name; // 
    private int Number;
    private String Dirction;
    public static final int MAXFLIGHTS = 100;
    private LLQueue<Customer> Customers;
    private LLQueue<Flight> f;

    public Flight(String name, int Number, String Dirction) {
        this.name = name;
        this.Number = Number;
        this.Dirction = Dirction;
        Customers = new LLQueue<>();

    }

    public Flight() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LLQueue<Customer> getCustomers() {
        return Customers;
    }

    public void setCustomers(LLQueue<Customer> Customers) {
        this.Customers = Customers;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }

    public String getDirction() {
        return Dirction;
    }

    public void setDirction(String Dirction) {
        this.Dirction = Dirction;
    }

    @Override
    public boolean isAvailable() {
        return MAXFLIGHTS > customersSum();

    }

    @Override
    public void addCustomer(Customer customer) {

        if (!isAvailable()) {
            System.out.println("The flight is fully booked!");
        } else {
            Customers.Enqueue(customer);
            System.out.println("Customer added successfully!");
        }
    }

    public int customersSum() {

        long size = Customers.getSize();
        int sum = 0;
        for (int i = 0; i < size; i++) {
            Customer ele = Customers.Dequeue();
            sum++;
            Customers.Enqueue(ele);
        }
        return sum;
    }

    public void display() {

        System.out.println("-----Flight Info------");
        System.out.println("Flight Name: " + getName());
        System.out.println("Flight Number: " + getNumber());
        System.out.println("Flight Dirction: " + getDirction());
        System.out.println("--- Customers List ---");
        Customers.display();

    }

    @Override
    public void removeCustomer() {
        Customers.Dequeue();
    }

}
