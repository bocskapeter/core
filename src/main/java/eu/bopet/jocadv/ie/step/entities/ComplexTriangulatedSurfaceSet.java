package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.StepEntityBase;

public class ComplexTriangulatedSurfaceSet extends StepEntityBase {
    public ComplexTriangulatedSurfaceSet(int id, String name, String attribute) {
        super(id, name);
        System.out.println("at: " + attribute);
    }
}
