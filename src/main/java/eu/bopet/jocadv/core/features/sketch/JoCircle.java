package eu.bopet.jocadv.core.features.sketch;

import eu.bopet.jocadv.core.features.FeatureBase;
import eu.bopet.jocadv.core.features.JoPoint;
import eu.bopet.jocadv.core.features.Selectable;
import eu.bopet.jocadv.core.features.datums.JoPlane;
import eu.bopet.jocadv.core.features.vector.JoValue;
import org.apache.commons.math3.geometry.euclidean.threed.Line;

import java.util.ArrayList;
import java.util.List;

public class JoCircle extends FeatureBase implements SketchGeometry, Selectable {
    private final JoSphere sphere;
    private final JoPlane plane;

    public JoCircle(JoSphere sphere, JoPlane plane) {
        this.sphere = sphere;
        this.plane = plane;
    }

    public JoSphere getSphere() {
        return sphere;
    }

    public JoPlane getPlane() {
        return plane;
    }

    @Override
    public double distance(Line pickingLine) {
        return sphere.distance(pickingLine);
    }

    @Override
    public List<JoValue> getValues() {
        return new ArrayList<>(sphere.getValues());
    }

    @Override
    public List<JoPoint> getPoints() {
        return new ArrayList<>(sphere.getPoints());
    }

    @Override
    public String toString() {
        String name = "⨀";
        if (this.getName() != null) name = this.getName();
        return name + "{" + sphere + " ⤓ " + plane + '}';
    }
}
