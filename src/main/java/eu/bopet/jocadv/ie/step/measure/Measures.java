package eu.bopet.jocadv.ie.step.measure;

import eu.bopet.jocadv.ie.step.entities.MeasureRepresentationItem;
import eu.bopet.jocadv.ie.step.util.StepCode;
import eu.bopet.jocadv.ie.step.util.StepEntityBase;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Measures extends StepEntityBase {
    Set<Measure> measures;

    public Measures(int id, String name, String set) {
        super(id, name);
        measures = new LinkedHashSet<>();
        List<String> measureListString = StepEntityBase.getSets(set, StepCode.MEASURES);
        for (String s : measureListString) {
            for (String code : StepCode.MEASURES) {
                if (s.startsWith(code)) {
                    String attributes = s.substring(s.indexOf("(") + 1, s.lastIndexOf(")"));
                    System.out.println("att: " + attributes);
                    switch (code) {
                        case StepCode.MEASURE_WITH_UNIT: {
                            MeasureWithUnit measureWithUnit = new MeasureWithUnit(-1, "", attributes);
                            measures.add(measureWithUnit);
                            System.out.println(measureWithUnit);
                            s = "";
                            continue;
                        }
                        case StepCode.MEASURE_REPRESENTATION_ITEM: {
                            MeasureRepresentationItem measureRepresentationItem =
                                    new MeasureRepresentationItem(-1, "", attributes);
                            measures.add(measureRepresentationItem);
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
