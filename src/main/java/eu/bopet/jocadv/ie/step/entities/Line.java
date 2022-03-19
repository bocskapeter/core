package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.sketch.JoLine;
import eu.bopet.jocadv.ie.step.StepLink;
import eu.bopet.jocadv.ie.step.util.StepEntityBase;
import eu.bopet.jocadv.ie.step.util.UtilIntInt;

import java.util.List;

public class Line extends UtilIntInt implements StepLink {
    CartesianPoint point;
    Vector vector;
    Direction direction;

    public Line(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "Line{" + super.toString() + '}';
    }

    @Override
    public JoFeature getResult(List<StepEntityBase> entityList) {
        for (StepEntityBase entity : entityList) {
            if (entity.getId() == this.get1st() && entity instanceof CartesianPoint) {
                point = (CartesianPoint) entity;
                System.out.println("point: " + point.toString());
                continue;
            }
            if (entity.getId() == this.get2nd() && entity instanceof Vector) {
                vector = (Vector) entity;
                System.out.println("vector: " + vector.toString());
                continue;
            }
        }
        if (vector != null) {
            for (StepEntityBase entity : entityList) {
                if (entity.getId() == vector.get1st() && entity instanceof Direction) {
                    direction = (Direction) entity;
                    System.out.println("direction: " + direction.toString());
                    continue;
                }
            }
        }

        JoLine result = null;
        return result;

    }

    @Override
    public void regenerate() throws Exception {
        // TODO
    }
}
