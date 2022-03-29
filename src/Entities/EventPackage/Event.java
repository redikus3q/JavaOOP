package Entities.EventPackage;

import Entities.Organizer;
import Entities.PerformerPackage.Performer;
import Entities.Venue;

public abstract class Event {
    protected String name;
    protected Venue venue;
    protected Organizer organizer;

    public Event(String name, Venue venue, Organizer organizer) {
        this.name = name;
        this.venue = venue;
        this.organizer = organizer;
    }

    public String getName() {
        return name;
    }

    public Venue getVenue() {
        return venue;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    abstract public void show();

}
