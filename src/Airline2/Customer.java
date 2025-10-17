package Airline2;

public class Customer {

    // 3 attributes 
    private String name;
    private int Passport;
    private int PhoneNumber;

    public Customer(String name, int Passport, int PhoneNumber) {
        this.name = name;
        this.Passport = Passport;
        this.PhoneNumber = PhoneNumber;
    }

    public Customer(int Passport) {
        this.Passport = Passport;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassport() {
        return Passport;
    }

    public void setPassport(int Passport) {
        this.Passport = Passport;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    @Override
    public String toString() {
        return String.format("-*Name: %s ,Passport: %d , PhoneNumber: %d *-", name, Passport, PhoneNumber);
    }

}
