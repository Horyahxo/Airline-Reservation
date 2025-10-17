package Airline2;

import java.util.Scanner;

import java.util.Scanner;

public class CarService {

    private String CarType;
    private int CarPrice;

    public CarService(String CarType, int CarPrice) {

        this.CarType = CarType;
        this.CarPrice = CarPrice;

    }

    public String getCarType() {
        return CarType;
    }

    public void setCarType(String CarType) {
        this.CarType = CarType;
    }

    public int getCarPrice() {
        return CarPrice;
    }

    public void setCarPrice(int CarPrice) {
        this.CarPrice = CarPrice;
    }

    @Override
    public String toString() {
        return String.format("-*Car Type: %s , Car Price: %d *-", CarType, CarPrice);
    }

    public boolean isAvalible() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the perferd car type: ");
        String i = input.nextLine();
        return i.equals(CarType);
    }
}
