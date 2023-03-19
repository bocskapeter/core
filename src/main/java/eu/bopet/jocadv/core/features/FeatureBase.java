package eu.bopet.jocadv.core.features;


import java.util.UUID;

public abstract class FeatureBase {
    private UUID id;
    private String name;
    private boolean selected;
    private double tolerance = JoValue.DEFAULT_TOLERANCE;

    public UUID getId() {
        if (this.id == null) this.id = UUID.randomUUID();
        return id;
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

    public double getTolerance() {
        return tolerance;
    }

    public void setTolerance(double tolerance) {
        this.tolerance = tolerance;
    }
}