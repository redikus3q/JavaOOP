package Entities.EventPackage;

import Entities.Organizer;
import Entities.PerformerPackage.Performer;
import Entities.Venue;

public class Play extends Event{
    String form;
    Performer band;

    public Play(String name, Venue venue, Organizer organizer, String form, Performer band) {
        super(name, venue, organizer);
        this.form = form;
        this.band = band;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public void setBand(Performer band) {
        this.band = band;
    }

    @Override
    public void show() {
        System.out.println(form + " theatre featuring " + name);
    }
}
