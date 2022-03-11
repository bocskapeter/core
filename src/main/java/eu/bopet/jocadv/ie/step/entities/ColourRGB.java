package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilDoubleArray;

public class ColourRGB extends UtilDoubleArray {
    public ColourRGB(int id, String name, String attributes) {
        super(id, name, attributes);
    }

    @Override
    public String toString() {
        return "ColourRGB{" + super.toString() + "}";
    }
}
