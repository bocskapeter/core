package eu.bopet.jocadv.ie.step;

import eu.bopet.jocadv.ie.step.util.UtilIntListOfIntPreferredSurfaceCurveRepresentation;

public class SeamCurve extends UtilIntListOfIntPreferredSurfaceCurveRepresentation {

    public SeamCurve(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "SeamCurve{" + super.toString() + '}';
    }
}
