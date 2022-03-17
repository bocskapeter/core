package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilIntSetOfInt;

public class CCDesignSecurityClassification extends UtilIntSetOfInt {
    public CCDesignSecurityClassification(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "CCDesignSecurityClassification{" + super.toString() + "}";
    }
}
