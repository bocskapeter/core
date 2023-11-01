package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.core.features.basic.JoCircle;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import eu.bopet.jocadv.core.features.datums.JoCoSys;
import eu.bopet.jocadv.core.features.sketch.JoSValue;
import eu.bopet.jocadv.ie.step.StepEntity;
import eu.bopet.jocadv.ie.step.StepFeature;
import eu.bopet.jocadv.ie.step.StepLink;
import eu.bopet.jocadv.ie.step.util.UtilIntDouble;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

public class Circle extends UtilIntDouble implements StepLink {

    public Circle(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "Circle{" + super.toString() + '}';
    }

    @Override
    public void generateJoFeature(StepFeature feature) throws Exception {
        StepEntity stepEntity = feature.getStepEntityByID(super.get1st());
        if (stepEntity instanceof Axis2Placement3D) {
            Axis2Placement3D placement3D = (Axis2Placement3D) feature.getStepEntityByID(super.get1st());
            double r = this.get2nd();
            if (!feature.getFeatureMap().containsKey(placement3D)) {
                placement3D.generateJoFeature(feature);
            }
            JoCoSys joCoSys = (JoCoSys) feature.getFeatureMap().get(placement3D);
            Vector3D radius = joCoSys.getX().getDirection().getVector3D().scalarMultiply(super.get2nd());
            Vector3D vector3D = joCoSys.getOrigin().getVector3D().add(radius);
            JoPoint joPoint = new JoPoint(JoSValue.IMPORTED, vector3D);
            JoCircle joCircle = new JoCircle(joCoSys.getOrigin(), joPoint, joCoSys.getXy());
            feature.getFeatureMap().put(this, joCircle);
        }
        if (stepEntity instanceof Axis2Placement2D) {
            // TODO
        }
    }

    @Override
    public void regenerate() throws Exception {
        //TODO
    }
}
