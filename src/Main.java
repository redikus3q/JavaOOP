import Services.*;

public class Main {
    public static void main(String[] args) {
        //Declare services
        TicketService ticketService = new TicketService();
        EventService eventService = new EventService();
        CityService cityService = new CityService();
        AddressService addressService = new AddressService();
        ClientService clientService = new ClientService();
        OrganizerService organizerService = new OrganizerService();

        //Cities
        cityService.createCity("London");
        System.out.println("Id London: " + cityService.getCityId("London"));
        //cityService.deleteCity("Sofia");
        cityService.updateCity(24, "Gradistea");

        //Addresses
        addressService.createAddress("Bulevardul Ion Minulescu 39", "Bucharest");
        System.out.println("Id Ion Minulescu: " + addressService.getAddressId("Bulevardul Ion Minulescu 39"));
        //addressService.deleteAddress("Bulevardul Ion Minulescu 39");
        addressService.updateAddress(19, "Calea Rahova 2");

        //Addresses
        clientService.createClient("George", "Mincu", "Bulevardul Ion Minulescu 39");
        System.out.println("Id George Mincu: " + clientService.getClientId("George", "Mincu"));
        //clientService.deleteClient("George", "Mincu");
        clientService.updateClient(4, "Ion", "Dolanecu");


        //Cities
        organizerService.createOrganizer("Crewetzel events");
        System.out.println("Crewetzel events id: " + organizerService.getOrganizerId("London"));
        //organizerService.deleteOrganizer("Crewetzel events");
        organizerService.updateOrganizer(4, "Boss events");

    }
}
