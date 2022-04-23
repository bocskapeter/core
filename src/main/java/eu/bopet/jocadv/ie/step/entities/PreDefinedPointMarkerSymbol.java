package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.StepEntityBase;

public class PreDefinedPointMarkerSymbol extends StepEntityBase {
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
