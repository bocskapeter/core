package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.core.features.sketch.JoSValue;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import eu.bopet.jocadv.core.features.datums.JoCoSys;
import eu.bopet.jocadv.core.features.exception.ParallelVectorException;
import eu.bopet.jocadv.core.features.vector.JoVector;
import eu.bopet.jocadv.ie.step.StepFeature;
import eu.bopet.jocadv.ie.step.StepLink;
import eu.bopet.jocadv.ie.step.util.UtilIntIntInt;

public class Axis2Placement3D extends UtilIntIntInt implements StepLink {

    public Axis2Placement3D(int id, String name, String attributes) {
        super(id, name, attributes);
    }

    @Override
    public String toString() {
        return "Axis2Placement3D{" + super.toString() + '}';
    }

    @Override
    public void generateJoFeature(StepFeature feature) throws ParallelVectorException {
        int id1 = super.getId1();
        int id2 = super.getId2();
        int id3 = super.getId3();
        CartesianPoint cartesianPoint = (CartesianPoint) feature.getStepEntityByID(id1);
        Direction directionX;
        Direction directionY;
        if (id2 < 1 || id3 < 1) {
            directionX = new Direction(-1, "", "(1.,0.,0.)");
            directionY = new Direction(-1, "", "(0.,1.,0.)");
        } else {
            directionX = (Direction) feature.getStepEntityByID(id2);
            directionY = (Direction) feature.getStepEntityByID(id3);
        }
        if (!feature.getFeatureMap().containsKey(cartesianPoint)) {
            cartesianPoint.generateJoFeature(feature);
        }
        if (!feature.getFeatureMap().containsKey(directionX)) {
            directionX.generateJoFeature(feature);
        }
        if (!feature.getFeatureMap().containsKey(directionY)) {
            directionY.generateJoFeature(feature);
        }
        JoPoint origin = (JoPoint) feature.getFeatureMap().get(cartesianPoint);
        JoVector joVectorX = (JoVector) feature.getFeatureMap().get(directionX);
        JoVector joVectorY = (JoVector) feature.getFeatureMap().get(directionY);
        JoCoSys joCoSys = new JoCoSys(JoSValue.IMPORTED, origin, joVectorX, joVectorY);
        joCoSys.setIntID(super.getId());
        joCoSys.setName(super.getName());
        feature.getFeatureMap().put(this, joCoSys);
    }

    @Override
    public void regenerate() throws Exception {
        //TODO
    }
}
