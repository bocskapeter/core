package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilInt;

public class CartesianTrim extends UtilInt implements SelectedTrim {
    public CartesianTrim(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "CartesianTrim{" + super.toString() + "}";
    }
}
