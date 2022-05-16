package eu.bopet.jocadv.ie.step.shapeAspect;

import eu.bopet.jocadv.ie.step.StepEntityBase;
import eu.bopet.jocadv.ie.step.entities.DatumFeature;
import eu.bopet.jocadv.ie.step.util.StepCode;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ShapeAspects extends StepEntityBase {
    private Set<ShapeAspect> shapeAspects;

    public ShapeAspects(int id, String name, String set) {
        super(id, name);
        shapeAspects = new LinkedHashSet<>();
        List<String> shapeAspectListString = StepEntityBase.getSets(set);
        for (String s : shapeAspectListString) {
            String attributes = s.substring(s.indexOf("(") + 1, s.lastIndexOf(")"));
            if (s.startsWith(StepCode.COMPOSITE_SHAPE_ASPECT)) {
                CompositeShapeAspect compositeShapeAspect = new CompositeShapeAspect();
                shapeAspects.add(compositeShapeAspect);
                continue;
            }
            if (s.startsWith(StepCode.DATUM_FEATURE)) {
                DatumFeature datumFeature = new DatumFeature(-1, "", "");
                shapeAspects.add(datumFeature);
                continue;
            }
            if (s.startsWith(StepCode.SHAPE_ASPECT)) {
                String newName = attributes.substring(0, attributes.indexOf(","));
                String rest = attributes.substring(attributes.indexOf(",") + 1);
                eu.bopet.jocadv.ie.step.entities.ShapeAspect shapeAspect =
                        new eu.bopet.jocadv.ie.step.entities.ShapeAspect(-1, newName, rest);
                shapeAspects.add(shapeAspect);
                continue;
            }
            System.out.println("Not processed shape aspect: " + s + " id: " + id);
        }
    }

    @Override
    public String toString() {
        return "ShapeAspects{" + super.toString() +
                ", shapeAspects=" + shapeAspects +
                '}';
    }
}
