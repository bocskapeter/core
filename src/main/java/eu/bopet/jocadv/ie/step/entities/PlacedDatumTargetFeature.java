package eu.bopet.jocadv.ie.step.entities;

public class PlacedDatumTargetFeature extends ShapeAspect {
    private String target;

    public PlacedDatumTargetFeature(int id, String name, String attribute) {
        super(id, name, attribute);
        target = attribute.substring(attribute.lastIndexOf(",") + 1).replace("'", "");
    }

    @Override
    public String toString() {
        return "PlacedDatumTargetFeature{" + super.toString() +
                ", target='" + target + '\'' +
                '}';
    }
}
