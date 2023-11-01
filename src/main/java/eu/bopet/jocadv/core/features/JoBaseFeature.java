package eu.bopet.jocadv.core.features;


import eu.bopet.jocadv.core.features.basic.JoPoint;
import eu.bopet.jocadv.core.features.sketch.JoSValue;

import java.util.UUID;

public abstract class JoBaseFeature {
    private UUID id;
    private int IntID;
    private String name;
    private boolean selected;
    private boolean visible;
    private double tolerance = JoSValue.DEFAULT_TOLERANCE;

    public UUID getId() {
        if (this.id == null) this.id = UUID.randomUUID();
        return id;
    }

    public int getIntID() {
        return IntID;
    }

    public void setIntID(int intID) {
        IntID = intID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public double getTolerance() {
        return tolerance;
    }

    public void setTolerance(double tolerance) {
        this.tolerance = tolerance;
    }

    public abstract boolean isOn(JoPoint point);
}