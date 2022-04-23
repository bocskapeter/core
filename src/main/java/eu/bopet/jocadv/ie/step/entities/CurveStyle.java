package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.measure.MeasureWithUnitInSet;
import eu.bopet.jocadv.ie.step.measure.PositiveLengthMeasure;
import eu.bopet.jocadv.ie.step.measure.SelectedSize;
import eu.bopet.jocadv.ie.step.measure.SizeSelect;
import eu.bopet.jocadv.ie.step.util.UtilInt;

public class CurveStyle extends UtilInt {
    private SizeSelect width;
    private SelectedSize selectedSize;
    private int colour;

    public CurveStyle(int id, String name, String attribute) {
        super(id, name, attribute.substring(0, attribute.indexOf(",")));
        width = SizeSelect.valueOf(attribute.substring(attribute.indexOf(",") + 1, attribute.indexOf("(")));
        String substring = attribute.substring(attribute.indexOf("(") + 1, attribute.indexOf(")"));
        switch (width) {
            case POSITIVE_LENGTH_MEASURE: {
                selectedSize = new PositiveLengthMeasure(substring);
                break;
            }
            case DESCRIPTIVE_MEASURE: {
                System.out.println("Not processed measure: DESCRIPTIVE_MEASURE");
                break;
            }
            case MEASURE_WITH_UNIT: {
                selectedSize = new MeasureWithUnitInSet(substring);
                break;
            }
        }
        colour = Integer.parseInt(attribute.substring(attribute.lastIndexOf(",") + 1).replace("#", ""));
    }

    @Override
    public String toString() {
        return "CurveStyle{" + super.toString() +
                ", width=" + width +
                ", selectedSize=" + selectedSize +
                ", colour=" + colour +
                '}';
    }
}
