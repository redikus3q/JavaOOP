package Entities.EventPackage;

import Entities.Organizer;
import Entities.PerformerPackage.Performer;
import Entities.Venue;

public class Standup extends Event{
    Performer comedian;

    public Standup(String name, Venue venue, Organizer organizer, Performer comedian) {
        super(name, venue, organizer);
        this.comedian = comedian;
    }

    public Performer getComedian() {
        return comedian;
    }

    public void setComedian(Performer comedian) {
        this.comedian = comedian;
    }

    @Override
    public void show() {
        System.out.println("standup show featuring " + comedian);
    }
}
