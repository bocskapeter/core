package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.core.features.JoValue;
import eu.bopet.jocadv.core.features.datums.JoCoSys;
import eu.bopet.jocadv.core.features.sketch.JoCircle;
import eu.bopet.jocadv.core.features.sketch.JoSphere;
import eu.bopet.jocadv.ie.step.StepEntityBase;
import eu.bopet.jocadv.ie.step.StepFeature;
import eu.bopet.jocadv.ie.step.StepLink;
import eu.bopet.jocadv.ie.step.util.UtilIntDouble;

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
        StepEntityBase stepEntityBase = feature.getStepEntityByID(super.get1st());
        if (stepEntityBase instanceof Axis2Placement3D) {
            Axis2Placement3D placement3D = (Axis2Placement3D) feature.getStepEntityByID(super.get1st());
            double r = this.get2nd();
            if (!feature.getFeatureMap().containsKey(placement3D)) {
                placement3D.generateJoFeature(feature);
            }
            JoCoSys joCoSys = (JoCoSys) feature.getFeatureMap().get(placement3D);
            JoValue radius = new JoValue(JoValue.IMPORTED, r);
            JoSphere joSphere = new JoSphere(joCoSys.getOrigin(), radius);
            JoCircle joCircle = new JoCircle(joSphere, joCoSys.getXy());
            joCircle.setIntID(super.getId());
            joCircle.setName(super.getName());
            feature.getFeatureMap().put(this, joCircle);
        }
        if (stepEntityBase instanceof Axis2Placement2D) {
            // TODO
        }
    }

    @Override
    public void regenerate() throws Exception {
        //TODO
    }
}
