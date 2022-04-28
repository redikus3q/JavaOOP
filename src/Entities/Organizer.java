package Entities;

public class Organizer {
    String name;

    public Organizer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show(){
        System.out.println(this.getName());
    }
}
