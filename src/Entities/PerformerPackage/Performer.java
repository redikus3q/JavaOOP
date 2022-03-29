package Entities.PerformerPackage;

public abstract class Performer {
    String name;

    public Performer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void show();
}
