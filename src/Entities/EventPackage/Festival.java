package Entities.EventPackage;

import Entities.Organizer;
import Entities.PerformerPackage.Performer;
import Entities.Venue;

import java.util.List;

public class Festival extends Event{
    List<Performer> lineup;

    public Festival(String name, Venue venue, Organizer organizer, List<Performer> lineup) {
        super(name, venue, organizer);
        this.lineup = lineup;
    }

    public List<Performer> getLineup() {
        return lineup;
    }

    public void setLineup(List<Performer> lineup) {
        this.lineup = lineup;
    }

    @Override
    public void show() {
        System.out.println("Festival featuring: ");
        lineup.forEach(performer -> {
            System.out.println(performer.getName() + ", ");
        });
    }
}
