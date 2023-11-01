package eu.bopet.jocadv.ie.step.unit;

import eu.bopet.jocadv.ie.step.StepEntity;
import eu.bopet.jocadv.ie.step.util.StepCode;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Units extends StepEntity {
    private Set<Unit> units;

    public Units(int id, String name, String set) {
        super(id, name);
        units = new LinkedHashSet<>();
        List<String> unitStringList = StepEntity.getSets(set);
        for (String s : unitStringList) {
            String attributes = s.substring(s.indexOf("(") + 1, s.lastIndexOf(")"));
            if (s.startsWith(StepCode.CONVERSION_BASED_UNIT)) {
                continue;
            }
            if (s.startsWith(StepCode.LENGTH_UNIT)) {
                LengthUnit unit = new LengthUnit();
                units.add(unit);
                continue;
            }
            if (s.startsWith(StepCode.NAMED_UNIT)) {
                NamedUnit unit = new NamedUnit(attributes);
                units.add(unit);
                continue;
            }
            if (s.startsWith(StepCode.SI_UNIT)) {
                SIUnit unit = new SIUnit(attributes);
                units.add(unit);
                continue;
            }
            if (s.startsWith(StepCode.PLANE_ANGLE_UNIT)) {
                PlaneAngleUnit unit = new PlaneAngleUnit();
                units.add(unit);
                continue;
            }
            if (s.startsWith(StepCode.SOLID_ANGLE_UNIT)) {
                SolidAngleUnit unit = new SolidAngleUnit();
                units.add(unit);
                continue;
            }
            if (s.startsWith(StepCode.MASS_UNIT)) {
                MassUnit massUnit = new MassUnit();
                units.add(massUnit);
                continue;
            }
            System.out.println("Not processed unit: " + s);
        }
    }

    @Override
    public String toString() {
        return "Units{" + super.toString() +
                " units=" + units +
                '}';
    }
}
