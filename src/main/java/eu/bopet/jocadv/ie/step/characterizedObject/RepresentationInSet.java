package eu.bopet.jocadv.ie.step.characterizedObject;

import eu.bopet.jocadv.ie.step.representation.Representation;

public class RepresentationInSet implements CharacterObject {
    private Representation representation;

    public RepresentationInSet(String attribute) {
        String name = attribute.substring(0, attribute.indexOf(",")).replace("'", "");
        String rest = attribute.substring(attribute.indexOf(",") + 1);
        representation = new Representation(-1, name, rest);
    }

    @Override
    public String toString() {
        return "RepresentationInSet{" + representation + '}';
    }
}
