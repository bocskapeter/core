package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.measure.PositiveLengthMeasure;
import eu.bopet.jocadv.ie.step.measure.SelectedSize;
import eu.bopet.jocadv.ie.step.measure.SizeSelect;
import eu.bopet.jocadv.ie.step.util.StepEntityBase;

import static org.apache.commons.lang3.StringUtils.isNumeric;

public class PointStyle extends StepEntityBase {
    private int markerId;
    private MarkerType markerType;
    private SizeSelect sizeSelect;
    private SelectedSize selectedSize;
    private int colour;

    public PointStyle(int id, String name, String attribute) {
        super(id, name);
        markerId = -1;
        String[] parts = attribute.split(",");
        String marker = parts[0].replace("#", "");
        if (isNumeric(marker)) {
            markerId = Integer.parseInt(marker);
        } else {
            markerType = MarkerType.valueOf(parts[0].substring(parts[0].indexOf("(") + 1, parts[0].indexOf(")"))
                    .replace(".", ""));
        }

        sizeSelect = SizeSelect.valueOf(parts[1].substring(0, parts[1].indexOf("(")));
        switch (sizeSelect) {
            case POSITIVE_LENGTH_MEASURE: {
                selectedSize = new PositiveLengthMeasure(parts[1].substring(parts[1].indexOf("(") + 1, parts[1].indexOf(")")));
                break;
            }
            case DESCRIPTIVE_MEASURE: {
                System.out.println("Not processed point style: DESCRIPTIVE_MEASURE");
                break;
            }
            case MEASURE_WITH_UNIT: {
                System.out.println("Not processed point style: MEASURE_WITH_UNIT");
                break;
            }
        }
        colour = Integer.parseInt(attribute.substring(attribute.lastIndexOf(",#") + 2));
    }

    @Override
    public String toString() {
        return "PointStyle{" + super.toString() +
                ", marker id=" + markerId +
                ", MARKER_TYPE=" + markerType +
                ", " + selectedSize +
                ", colour=" + colour +
                '}';
    }
}
