package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.StepEntity;

public class ViewVolume extends StepEntity {
    private final CentralOrParallel centralOrParallel;
    private final int point;
    private final double viewDistance;
    private final double frontDistance;
    private final boolean frontClipping;
    private final double backDistance;
    private final boolean backClipping;
    private final boolean sideClipping;
    private final int viewBox;

    public ViewVolume(int id, String name, String attributes) {
        super(id, name);
        String[] parts = attributes.split(",");
        centralOrParallel = CentralOrParallel.valueOf(parts[0].replace(".", ""));
        point = Integer.parseInt(parts[1].replace("#", ""));
        viewDistance = Double.parseDouble(parts[2]);
        frontDistance = Double.parseDouble(parts[3]);
        frontClipping = parts[4].contains("T");
        backDistance = Double.parseDouble(parts[5]);
        backClipping = parts[6].contains("T");
        sideClipping = parts[7].contains("T");
        viewBox = Integer.parseInt(parts[8].replace("#", ""));
    }

    @Override
    public String toString() {
        return "ViewVolume{" + super.toString() +
                ", centralOrParallel=" + centralOrParallel +
                ", point=" + point +
                ", viewDistance=" + viewDistance +
                ", frontDistance=" + frontDistance +
                ", frontClipping=" + frontClipping +
                ", backDistance=" + backDistance +
                ", backClipping=" + backClipping +
                ", sideClipping=" + sideClipping +
                ", viewBox=" + viewBox +
                '}';
    }
}
