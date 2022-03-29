import Entities.*;
import Entities.EventPackage.Concert;
import Entities.EventPackage.Event;
import Entities.EventPackage.Play;
import Entities.EventPackage.Standup;
import Entities.PerformerPackage.SoloArtist;
import Services.EventService;
import Services.TicketService;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Declare services
        TicketService ticketService = new TicketService();
        EventService eventService = new EventService();

        //Create some objects
        City city = new City("Bucharest");
        Address addressVenue = new Address("Blvd Ion Minulescu 34", city);
        Venue berariah = new Venue("Beraria H", 2500, addressVenue);
        Organizer organizer = new Organizer("Boss events");
        SoloArtist florin = new SoloArtist("FS", "Florin", "Sorin");

        //Create some events using the service
        Concert concert = eventService.createConcert("Concert simfonic", berariah, organizer, "Pop", florin);
        concert.show();

        Play play = eventService.createPlay("AFantoma de la opera", berariah, organizer, "Drama", florin);
        play.show();

        //Print the scheduled events using a sorted data structure
        System.out.println("Event list: ");
        ArrayList<Event> events = eventService.getAllEvents();
        events.forEach(event -> event.show());

        //Create some more objects
        Address addressClient = new Address("Calea Rahova 23", city);
        Client client = new Client("Maricica", "Popescu", addressClient);

        //Purchase a ticket for a client using the ticket service
        ticketService.purchaseTicket(concert, client);

        //Find the ticket using a map
        System.out.println("Ticket for: ");
        Ticket ticket = ticketService.findTicketById(1);
        ticket.getEvent().show();

    }
}
