import Entities.*;
import Entities.EventPackage.Concert;
import Entities.EventPackage.Event;
import Entities.EventPackage.Play;
import Entities.EventPackage.Standup;
import Entities.PerformerPackage.SoloArtist;
import Services.*;
import Services.FileManipulation.WriteFileService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Declare services
        TicketService ticketService = new TicketService();
        EventService eventService = new EventService();
        CityService cityService = new CityService();
        AddressService addressService = new AddressService();
        ClientService clientService = new ClientService();
        OrganizerService organizerService = new OrganizerService();
        WriteFileService writeFileService = WriteFileService.initiateWrite();
//
//        //Create some objects
//        City city = new City("Bucharest");
//        Address addressVenue = new Address("Blvd Ion Minulescu 34", city);
//        Venue berariah = new Venue("Beraria H", 2500, addressVenue);
//        Organizer organizer = new Organizer("Boss events");
//        SoloArtist florin = new SoloArtist("FS", "Florin", "Sorin");
//
//        //Create some events using the service
//        Concert concert = eventService.createConcert("Concert simfonic", berariah, organizer, "Pop", florin);
//        concert.show();
//
//        Play play = eventService.createPlay("AFantoma de la opera", berariah, organizer, "Drama", florin);
//        play.show();
//
//        //Print the scheduled events using a sorted data structure
//        System.out.println("Event list: ");
//        ArrayList<Event> events = eventService.getAllEvents();
//        events.forEach(event -> event.show());
//
//        //Create some more objects
//        Address addressClient = new Address("Calea Rahova 23", city);
//        Client client = new Client("Maricica", "Popescu", addressClient);
//
//        //Purchase a ticket for a client using the ticket service
//        ticketService.purchaseTicket(concert, client);
//
//        //Find the ticket using a map
//        System.out.println("Ticket for: ");
//        Ticket ticket = ticketService.findTicketById(1);
//        ticket.getEvent().show();
//
        //Cities
        cityService.createCity("Sofia");
        ArrayList<City> cities = cityService.getAllCities();
        cities.forEach(city1 -> city1.show());

        //Addresses
        addressService.createAddress("Bulevardul Ion Minulescu 39", "Bucharest");
        ArrayList<Address> addresses = addressService.getAllAddresses();
        addresses.forEach(address -> address.show());

        //Clients
        ArrayList<Client> clients = clientService.getAllClients();
        clients.forEach(client -> client.show());
        
        //Organizers
        ArrayList<Organizer> organizers = organizerService.getAllOrganizers();
        organizers.forEach(organizer -> organizer.show());

    }
}
