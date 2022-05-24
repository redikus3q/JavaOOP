package Services;

import Entities.Client;
import Entities.EventPackage.Event;
import Entities.Ticket;
import Services.DBManipulation.WriteDatabase;

import java.util.HashMap;
import java.util.Map;

public class TicketService {
    static int id = 1;
    Map<Integer, Ticket> tickets;
    WriteDatabase writeFile;

    public TicketService() {
        this.writeFile = WriteDatabase.initiateWrite();
        tickets = new HashMap<>();
    }

    public void purchaseTicket(Event event, Client client){
        writeFile.writeAudit("Purchase_ticket " + event.getName() + " " + client.getLastName());
        Ticket ticket = new Ticket(event, client, id);
        tickets.put(id, ticket);
        id++;
    }

    public Ticket findTicketById(int id){
        writeFile.writeAudit("Find_ticket " + id);
        if(tickets.containsKey(id)){
            return tickets.get(id);
        }
        return null;
    }

}
