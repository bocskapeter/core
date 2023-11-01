package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.StepEntity;

public class PreDefinedPointMarkerSymbol extends StepEntity {
    private MarkerType markerType;

    public PreDefinedPointMarkerSymbol(int id, String name, String attribute) {
        super(id, name);
        markerType = MarkerType.valueOf(attribute.replace("'", "").toUpperCase());
    }

    @Override
    public String toString() {
        return "PreDefinedPointMarkerSymbol{" + super.toString() +
                ", markerType=" + markerType +
                '}';
    }
}
