package eu.bopet.jocadv.ie.step.measure;

import eu.bopet.jocadv.ie.step.entities.MeasureRepresentationItem;
import eu.bopet.jocadv.ie.step.representation.RepresentationItem;
import eu.bopet.jocadv.ie.step.util.StepCode;
import eu.bopet.jocadv.ie.step.StepEntityBase;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Measures extends StepEntityBase {
    Set<Measure> measures;

    public Measures(int id, String name, String set) {
        super(id, name);
        measures = new LinkedHashSet<>();
        List<String> measureListString = StepEntityBase.getSets(set);
        for (String s : measureListString) {
            for (String code : StepCode.MEASURES) {
                if (s.startsWith(code)) {
                    String attributes = s.substring(s.indexOf("(") + 1, s.lastIndexOf(")"));
                    switch (code) {
                        case StepCode.MEASURE_REPRESENTATION_ITEM: {
                            MeasureRepresentationItem measureRepresentationItem =
                                    new MeasureRepresentationItem(-1, "", attributes);
                            measures.add(measureRepresentationItem);
                            s = "";
                            continue;
                        }
                        case StepCode.PLANE_ANGLE_MEASURE_WITH_UNIT: {
                            PlaneAngleMeasureWithUnit planeAngleMeasureWithUnit =
                                    new PlaneAngleMeasureWithUnit(-1, "", attributes);
                            measures.add(planeAngleMeasureWithUnit);
                            s = "";
                            continue;
                        }
                        case StepCode.REPRESENTATION_ITEM: {
                            RepresentationItem representationItem =
                                    new RepresentationItem(attributes);
                            measures.add(representationItem);
                            s = "";
                            continue;
                        }
                        case StepCode.MEASURE_WITH_UNIT: {
                            MeasureWithUnitInSet measureWithUnit = new MeasureWithUnitInSet(attributes);
                            measures.add(measureWithUnit);
                            s = "";
                            continue;
                        }
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Measures{" + super.toString() +
                ", measures=" + measures +
                '}';
    }
}
