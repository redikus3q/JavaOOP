package Services;

import Entities.EventPackage.Concert;
import Entities.EventPackage.Event;
import Entities.EventPackage.Play;
import Entities.EventPackage.Standup;
import Entities.Organizer;
import Entities.PerformerPackage.Performer;
import Entities.Venue;

import java.util.*;

public class EventService {
    SortedSet<Event> events;

    public EventService() {
        events = new TreeSet<Event>(Comparator.comparing(Event::getName));
    }

    public Concert createConcert(String name, Venue venue, Organizer organizer, String genre, Performer performer){
        Concert concert = new Concert(name, venue, organizer, genre, performer);
        events.add(concert);
        return concert;
    }

    public Play createPlay(String name, Venue venue, Organizer organizer, String form, Performer band){
        Play play = new Play(name, venue, organizer, form, band);
        events.add(play);
        return play;
    }

    public Standup createStandup(String name, Venue venue, Organizer organizer, Performer comedian){
        Standup standup = new Standup(name, venue, organizer, comedian);
        events.add(standup);
        return standup;
    }


    public ArrayList<Event> getAllEvents(){
        return new ArrayList<Event>(events);
    }
}
