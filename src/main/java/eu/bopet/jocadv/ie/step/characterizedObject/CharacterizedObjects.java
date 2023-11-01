package eu.bopet.jocadv.ie.step.characterizedObject;

import eu.bopet.jocadv.ie.step.StepEntity;
import eu.bopet.jocadv.ie.step.util.StepCode;

import java.util.ArrayList;
import java.util.List;

public class CharacterizedObjects extends StepEntity {
    private List<CharacterObject> objects;

    public CharacterizedObjects(int id, String name, String set) {
        super(id, name);
        objects = new ArrayList<>();
        List<String> objectStringList = StepEntity.getSets(set);
        for (String s : objectStringList) {
            String attribute = s.substring(s.indexOf("(") + 1, s.lastIndexOf(")"));
            if (s.startsWith(StepCode.CHARACTERIZED_OBJECT)) {
                CharacterizedObject characterizedObject =
                        new CharacterizedObject(attribute);
                objects.add(characterizedObject);
                continue;
            }
            if (s.startsWith(StepCode.CHARACTERIZED_REPRESENTATION)) {
                CharacterizedRepresentation characterizedRepresentation =
                        new CharacterizedRepresentation();
                objects.add(characterizedRepresentation);
                continue;
            }
            if (s.startsWith(StepCode.DRAUGHTING_MODEL)) {
                DraughtingModel draughtingModel = new DraughtingModel();
                objects.add(draughtingModel);
                continue;
            }
            if (s.startsWith(StepCode.REPRESENTATION)) {
                RepresentationInSet representationInSet = new RepresentationInSet(attribute);
                objects.add(representationInSet);
                continue;
            }
            if (s.startsWith(StepCode.SHAPE_REPRESENTATION)) {
                ShapeRepresentation shapeRepresentation = new ShapeRepresentation();
                objects.add(shapeRepresentation);
                continue;
            }
            if (s.startsWith(StepCode.TESSELLATED_SHAPE_REPRESENTATION)) {
                TessellatedShapeRepresentation tessellatedShapeRepresentation = new TessellatedShapeRepresentation();
                objects.add(tessellatedShapeRepresentation);
                continue;
            }
            System.out.println("Not processed characterized object: " + s);
        }
    }

    @Override
    public String toString() {
        return "CharacterizedObjects{" + objects + '}';
    }
}
