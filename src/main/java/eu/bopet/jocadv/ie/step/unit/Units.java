package eu.bopet.jocadv.ie.step.unit;

import eu.bopet.jocadv.ie.step.util.StepCode;
import eu.bopet.jocadv.ie.step.util.StepEntityBase;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Units extends StepEntityBase {
    private Set<Unit> units;

    public Units(int id, String name, String set) {
        super(id, name);
        units = new LinkedHashSet<>();
        List<String> unitStringList = StepEntityBase.getSets(set);
        for (String s : unitStringList) {
            for (String code : StepCode.UNITS) {
                if (s.startsWith(code)) {
                    String attributes = s.substring(s.indexOf("(") + 1, s.lastIndexOf(")"));
                    switch (code) {
                        case StepCode.CONVERSION_BASED_UNIT: {
                            continue;
                        }
                        case StepCode.LENGTH_UNIT: {
                            LengthUnit unit = new LengthUnit();
                            units.add(unit);
                            s = "";
                            continue;
                        }
                        case StepCode.NAMED_UNIT: {
                            NamedUnit unit = new NamedUnit(attributes);
                            units.add(unit);
                            s = "";
                            continue;
                        }
                        case StepCode.SI_UNIT: {
                            SIUnit unit = new SIUnit(attributes);
                            units.add(unit);
                            s = "";
                            continue;
                        }
                        case StepCode.PLANE_ANGLE_UNIT: {
                            PlaneAngleUnit unit = new PlaneAngleUnit();
                            units.add(unit);
                            s = "";
                            continue;
                        }
                        case StepCode.SOLID_ANGLE_UNIT: {
                            SolidAngleUnit unit = new SolidAngleUnit();
                            units.add(unit);
                            s = "";
                            continue;
                        }
                    }
                    System.out.println("Not Processed code: " + code);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Units{" + super.toString() +
                " units=" + units +
                '}';
    }
}
