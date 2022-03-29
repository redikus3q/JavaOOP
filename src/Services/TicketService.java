package Services;

import Entities.Client;
import Entities.EventPackage.Event;
import Entities.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketService {
    static int id = 1;
    Map<Integer, Ticket> tickets;

    public TicketService() {
        tickets = new HashMap<>();
    }

    public void purchaseTicket(Event event, Client client){
        Ticket ticket = new Ticket(event, client, id);
        tickets.put(id, ticket);
        id++;
    }

    public Ticket findTicketById(int id){
        if(tickets.containsKey(id)){
            return tickets.get(id);
        }
        return null;
    }

}
