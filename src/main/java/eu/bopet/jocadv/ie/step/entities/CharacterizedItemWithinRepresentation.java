package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilStringIntInt;

public class CharacterizedItemWithinRepresentation extends UtilStringIntInt {
    public CharacterizedItemWithinRepresentation(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "CharacterizedItemWithinRepresentation{" + super.toString() + "}";
    }
}
