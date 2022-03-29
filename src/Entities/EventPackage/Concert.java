package Entities.EventPackage;

import Entities.Organizer;
import Entities.PerformerPackage.Performer;
import Entities.Venue;

public class Concert extends Event{
    String genre;
    Performer performer;

    public Concert(String name, Venue venue, Organizer organizer, String genre, Performer performer) {
        super(name, venue, organizer);
        this.genre = genre;
        this.performer = performer;
    }

    public String getGenre() {
        return genre;
    }

    public Performer getPerformer() {
        return performer;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPerformer(Performer performer) {
        this.performer = performer;
    }

    @Override
    public void show() {
        System.out.println(genre + " musical concert featuring " + performer.getName());
    }
}
