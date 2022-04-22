package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.StepEntityBase;

public class SurfaceStyleParameterLine extends StepEntityBase {
    private int style;
    private int UDirectionCount;
    private int VDirectionCount;

    public SurfaceStyleParameterLine(int id, String name, String attribute) {
        super(id, name);
        String[] parts = attribute.split(",");
        style = Integer.parseInt(parts[0].replace("#", ""));
        UDirectionCount = Integer.parseInt(parts[1]
                .substring(parts[1].lastIndexOf("(") + 1, parts[1].indexOf(")")));
        VDirectionCount = Integer.parseInt(parts[2]
                .substring(parts[2].lastIndexOf("(") + 1, parts[2].indexOf(")")));
    }

    @Override
    public String toString() {
        return "SurfaceStyleParameterLine{" + super.toString() +
                ", style=" + style +
                ", UDirectionCount=" + UDirectionCount +
                ", VDirectionCount=" + VDirectionCount +
                '}';
    }
}
