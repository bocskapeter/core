package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.basic.JoEllipse;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import eu.bopet.jocadv.core.features.datums.JoCoSys;
import eu.bopet.jocadv.core.features.sketch.JoSValue;
import eu.bopet.jocadv.ie.step.StepEntity;
import eu.bopet.jocadv.ie.step.StepFeature;
import eu.bopet.jocadv.ie.step.StepLink;
import eu.bopet.jocadv.ie.step.util.UtilIntDoubleDouble;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

public class Ellipse extends UtilIntDoubleDouble implements StepLink {
    public Ellipse(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "Ellipse{" + super.toString() + '}';
    }

    @Override
    public void generateJoFeature(StepFeature feature) throws Exception {
        StepEntity stepEntity = feature.getStepEntityByID(super.getAnInt());
        if (!feature.getFeatureMap().containsKey(stepEntity)) {
            ((StepLink) stepEntity).generateJoFeature(feature);
        }
        JoFeature joFeature = feature.getFeatureMap().get(stepEntity);
        if (joFeature instanceof JoCoSys) {
            JoCoSys coSys = (JoCoSys) joFeature;
            JoPoint center = coSys.getOrigin();
            Vector3D firstPoint3D = center.getVector3D().add(coSys.getX().getDirection().getVector3D().scalarMultiply(super.getDouble1()));
            Vector3D secondPoint3D = center.getVector3D().add(coSys.getY().getDirection().getVector3D().scalarMultiply(super.getDouble2()));
            JoPoint firstPoint = new JoPoint(JoSValue.IMPORTED, firstPoint3D);
            JoPoint secondPoint = new JoPoint(JoSValue.IMPORTED, secondPoint3D);
            JoEllipse ellipse = new JoEllipse(center, firstPoint, secondPoint);
            ellipse.setIntID(super.getId());
            ellipse.setName(super.getName());
            feature.getFeatureMap().put(this, ellipse);
        } else {
            System.out.println("Ellipse processing - Unknown position: " + stepEntity);
        }
    }

    @Override
    public void regenerate() throws Exception {

    }
}
