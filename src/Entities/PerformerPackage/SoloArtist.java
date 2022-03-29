package Entities.PerformerPackage;

public class SoloArtist extends Performer{
    String firstName, lastName;

    public SoloArtist(String name, String firstName, String lastName) {
        super(name);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public void show() {
        System.out.println(firstName + " " + lastName);
    }
}
