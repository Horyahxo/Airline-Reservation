package Airline2;

import java.util.Scanner;

public class HotelService {

    private int Stars;
    private String location;

    public HotelService(int Stars, String location) {
        this.Stars = Stars;
        this.location = location;

    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getStars() {
        return Stars;
    }

    public void setStars(int Stars) {
        this.Stars = Stars;
    }

    @Override
    public String toString() {
        return String.format("-*Hotel's Rating based on stars: %d ,The hotel's location: %s *-", Stars, location);
    }

    public boolean isAvalible() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your perferd location:");
        String i = input.nextLine();
        return i.equals(location);
    }
//    
}
