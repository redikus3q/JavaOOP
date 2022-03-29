package Entities.PerformerPackage;

import java.util.List;

public class Band extends Performer{
    List<SoloArtist> lineup;

    public Band(String name) {
        super(name);
    }

    public Band(String name, List<SoloArtist> lineup) {
        super(name);
        this.lineup = lineup;
    }

    public List<SoloArtist> getLineup() {
        return lineup;
    }

    public void setLineup(List<SoloArtist> lineup) {
        this.lineup = lineup;
    }

    @Override
    public void show() {
        System.out.println(name);
        lineup.forEach((member) -> {
            System.out.println(member + ", ");
        });
    }
}
