package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.JoValue;
import eu.bopet.jocadv.core.features.basic.JoEdge;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import eu.bopet.jocadv.core.features.vector.JoVector;
import eu.bopet.jocadv.ie.step.StepEntityBase;
import eu.bopet.jocadv.ie.step.StepLink;
import eu.bopet.jocadv.ie.step.util.UtilIntInt;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Line extends UtilIntInt implements StepLink {
    private CartesianPoint point;
    private Vector vector;
    private Direction direction;
    private Vector3D direction3D;
    private Set<JoPoint> points;


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
                continue;
            }
            if (entity.getId() == this.get2nd() && entity instanceof Vector) {
                vector = (Vector) entity;
                continue;
            }
        }
        if (vector != null) {
            for (StepEntityBase entity : entityList) {
                if (entity.getId() == vector.get1st() && entity instanceof Direction) {
                    direction = (Direction) entity;
                    continue;
                }
            }
        }
        JoPoint point1 = (JoPoint) point.getResult(entityList);
        double scale = vector.get2nd();
        if (direction.getDoubles().length == 3) {
            direction3D = new Vector3D(direction.getDoubles());
        }
        if (direction.getDoubles().length == 2) {
            direction3D = new Vector3D(direction.getDoubles()[0], direction.getDoubles()[1], 0.0);
        }
        Vector3D point23D = direction3D.scalarMultiply(scale);
        JoValue x = new JoValue(JoValue.IMPORTED, point23D.getX());
        JoValue y = new JoValue(JoValue.IMPORTED, point23D.getY());
        JoValue z = new JoValue(JoValue.IMPORTED, point23D.getZ());
        JoVector vector2 = new JoVector(x, y, z, null);
        JoPoint point2 = new JoPoint(vector2, null);
        points = new LinkedHashSet<>();
        points.add(point1);
        points.add(point2);

        return new JoEdge(points, null);

    }

    @Override
    public void regenerate() throws Exception {
        // TODO
    }
}
