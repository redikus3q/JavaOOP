import Services.*;

import java.util.Scanner;

public class Main {
    public static void showMenu(){
        System.out.println("/------------------------------------------------------------------------\\");
        System.out.println("|  Number 0 - Exit application                                           |");
        System.out.println("|  Number 1 - Show menu                                                  |");
        System.out.println("|  Number 2 - Add a city                                                 |");
        System.out.println("|  Number 3 - Show a city's id                                           |");
        System.out.println("|  Number 4 - Delete a city                                              |");
        System.out.println("|  Number 5 - Update a city                                              |");
        System.out.println("|  Number 6 - Create an address                                          |");
        System.out.println("*------------------------------------------------------------------------*");

    }

    public static void main(String[] args) {
        //Declare services
        TicketService ticketService = new TicketService();
        EventService eventService = new EventService();
        CityService cityService = new CityService();
        AddressService addressService = new AddressService();
        ClientService clientService = new ClientService();
        OrganizerService organizerService = new OrganizerService();

//        //Cities
//        cityService.createCity("Berlin");
//        System.out.println("Id London: " + cityService.getCityId("London"));
//        //cityService.deleteCity("Sofia");
//        cityService.updateCity(296, "Gradistea");

//        //Addresses
//        addressService.createAddress("Bulevardul Ion Minulescu 39", "Bucharest");
//        System.out.println("Id Ion Minulescu: " + addressService.getAddressId("Bulevardul Ion Minulescu 39"));
//        //addressService.deleteAddress("Bulevardul Ion Minulescu 39");
//        addressService.updateAddress(19, "Calea Rahova 2");
//
//        //Addresses
//        clientService.createClient("George", "Mincu", "Bulevardul Ion Minulescu 39");
//        System.out.println("Id George Mincu: " + clientService.getClientId("George", "Mincu"));
//        //clientService.deleteClient("George", "Mincu");
//        clientService.updateClient(4, "Ion", "Dolanecu");
//
//
//        //Cities
//        organizerService.createOrganizer("Crewetzel events");
//        System.out.println("Crewetzel events id: " + organizerService.getOrganizerId("London"));
//        //organizerService.deleteOrganizer("Crewetzel events");
//        organizerService.updateOrganizer(4, "Boss events");

        int choice = 1;
        showMenu();

        while(choice != 0){
            Scanner keyboard = new Scanner(System.in);
            System.out.print("\nIntroduce an option: ");
            choice = keyboard.nextInt();

            String name;
            int id;

            switch(choice){
                case 0:
                    break;
                case 1:
                    showMenu();
                    break;
                case 2:
                    System.out.println("City name: ");
                    keyboard.nextLine();
                    name = keyboard.nextLine();
                    cityService.createCity(name);
                    break;
                case 3:
                    System.out.println("City name: ");
                    keyboard.nextLine();
                    name = keyboard.nextLine();
                    id = cityService.getCityId(name);
                    if(id == 0) {
                        System.out.println("City doesn't exist!");
                    }
                    else{
                        System.out.println("ID: " + cityService.getCityId(name));
                    }
                    break;
                case 4:
                    System.out.println("City name: ");
                    keyboard.nextLine();
                    name = keyboard.nextLine();
                    cityService.deleteCity(name);
                    break;
                case 5:
                    System.out.println("City id: ");
                    id = keyboard.nextInt();
                    keyboard.nextLine();
                    System.out.println("New name: ");
                    name = keyboard.nextLine();
                    cityService.updateCity(id, name);
                    break;
                case 6:
                    System.out.println("Addressline: ");
                    keyboard.nextLine();
                    name = keyboard.nextLine();
                    System.out.println("City: ");
                    String city = keyboard.nextLine();
                    addressService.createAddress(name, city);
                    break;
            }
        }
    }
}
