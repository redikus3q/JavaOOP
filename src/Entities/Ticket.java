package Entities;

import Entities.EventPackage.Event;

final public class Ticket {
    Event event;
    Client client;
    int id;

    public Ticket(Event event, Client client, int id) {
        this.event = event;
        this.client = client;
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public Client getClient() {
        return client;
    }

    public int getId() {
        return id;
    }
}
