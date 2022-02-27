package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilIntListOfIntPreferredSurfaceCurveRepresentation;

public class SurfaceCurve extends UtilIntListOfIntPreferredSurfaceCurveRepresentation {

    public SurfaceCurve(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "SurfaceCurve{" + super.toString() + '}';
    }
}
