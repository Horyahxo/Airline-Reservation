package Airline2;
// customer

import java.util.InputMismatchException;
import java.util.Scanner;

public class DS_Project {

    public static void main(String[] args) {
        LLQueue<Flight> FlightQu = new LLQueue<>();
//        Flight Flight1 = new Flight();
        Flight Flight1 = new Flight("Emirates ", 10, "Dubai");
        Flight Flight2 = new Flight("QATAR ", 20, "Doha");
        Flight Flight3 = new Flight("British ", 30, "London");
        Flight Flight4 = new Flight("United", 40, "Washington DC");
        Flight Flight5 = new Flight("KSA", 50, "Riyadh");
        // --- service
        CarService cars1 = new CarService("Hunda", 100000);
        HotelService hotel1 = new HotelService(5, "Riyadh");
        //-- linked list 
        LinkedList<CarService> CarList = new LinkedList<>();
        LinkedList<HotelService> HotelList = new LinkedList<>();

        // -- queue
        FlightQu.Enqueue(Flight1);
        FlightQu.Enqueue(Flight2);
        FlightQu.Enqueue(Flight3);
        FlightQu.Enqueue(Flight4);
        FlightQu.Enqueue(Flight5);

        Scanner input = new Scanner(System.in);
        System.out.println("<<<<<WELCOME TO OUR SYSTEM>>>>>");
        System.out.println("---Please Choose From The Menu---");
        char e = 0;

        System.out.println("Are you a Manger or a Customer? (C or M)");
        try {
            String role = input.nextLine();
            //Cuctomer

            if (role.equalsIgnoreCase("C")) {
                int option = 0;
                do {
                    try {
                        System.out.println("Please choose from the menu: ");
                        System.out.println("\n*Customer Menu*");
                        System.out.println("1. Book a Flight");
                        System.out.println("2. Cancel a Flight");
                        System.out.println("3. Show All Flights");
                        System.out.println("4. Show Flight info");
                        System.out.println("5. book Car Service");
                        System.out.println("6. Cancel Car Service");
                        System.out.println("7. display Car Service");
                        System.out.println("8. book Hotel Service");
                        System.out.println("9. Cancel Hotel Service");
                        System.out.println("10. display Hotel Service");
                        System.out.println("11. Exit");

                        option = input.nextInt();
                        switch (option) {

                            case 1:
                                FlightQu.displayFlights();
                                FlightQu.bookFlight();
                                break;

                            case 2:
                                FlightQu.cancelFlight();
                                break;

                            case 3:
                                FlightQu.displayFlights();
                                break;

                            case 4:
                                FlightQu.displayFlightInfo();
                                break;
                            case 5:
                                System.out.println(" --book Car Service--");
                                CarList.bookCarService(cars1);
                                System.out.println("Your car service has been booked!");
                                break;
                            case 6:
                                System.out.println(" --Cancel Car Service--");
                                CarList.cancelCarService();
                                System.out.println("Your car service has been canceld!");
                                break;
                            case 7:
                                System.out.println("--Car Service--");
                                CarList.DisplayCarService();
                                break;
                            case 8:
                                System.out.println(" book Hotel Service");
                                HotelList.bookHotelervice(hotel1);
                                System.out.println("Your Hotel service has been booked!");
                                break;
                            case 9:
                                System.out.println(" Cancel Hotel Service");
                                HotelList.cancelHotelService();
                                System.out.println("Your Hotel service has been canceld!");
                                break;
                            case 10:
                                System.out.println("--Hotel Service--");
                                HotelList.DisplayHotelService();
                                break;

                            case 11:
                                System.out.println("Thank you!");
                                break;
                            default:
                                System.out.println("Invalid option!");
                        }
                    } catch (InputMismatchException ex) {
                        System.err.println("invalid input!");
                        input.next();
                    }

                } while (option != 11);
            } // end first if
            // Manger
            else if (role.equalsIgnoreCase("M")) {
                int option = 0;
                do {
                    try {
                        System.out.println("Please choose from the menu: ");
                        System.out.println("\n*Manager Menu*");
                        System.out.println("1. Add new flight");
                        System.out.println("2. Cancel a flight");
                        System.out.println("3. Info About Flight");
                        System.out.println("4. Display all flights");
                        System.out.println("5. Add customer");
                        System.out.println("6. Remove Customer");
                        System.out.println("7. Show Total Customer");
                        System.out.println("8. Search Flight");
                        System.out.println("9. Exit");
                        option = input.nextInt();
                        switch (option) {

                            case 1:
                                FlightQu.scheduleFlight();
                                break;
                            case 2:
                                FlightQu.cancelFlight();
                                break;
                            case 3:
                                FlightQu.displayFlightInfo();
                                break;
                            case 4:
                                FlightQu.displayFlights();
                                break;
                            case 5:
                                FlightQu.add();
                                break;
                            case 6:
                                System.out.print("Enter passport: ");
                                int pass = input.nextInt();
                                Customer c1 = new Customer(pass);
                                FlightQu.remove(c1);
                                break;
                            case 7:
                                FlightQu.sum();
                                break;
                            case 8:

                                FlightQu.searchFlight();
                                break;
                            case 9:
                                System.out.println("Thank you!");
                                break;
                            default:
                                System.out.println("Invalid option!");
                        }
                    } catch (InputMismatchException ex) {
                        System.err.println("invalid input!");
                        input.next();
                    }

                } while (option != 9);
            } //end second if
            else {
                System.err.println("Invalid input");
            }
        } catch (InputMismatchException ex) {
            System.err.println("invalid input!");
            input.next();
        }

    }
}
