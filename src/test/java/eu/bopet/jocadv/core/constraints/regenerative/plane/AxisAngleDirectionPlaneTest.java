package eu.bopet.jocadv.core.constraints.regenerative.plane;

import eu.bopet.jocadv.core.features.datums.JoAxis;
import eu.bopet.jocadv.core.features.datums.JoPlane;
import eu.bopet.jocadv.core.features.vector.JoValue;
import eu.bopet.jocadv.core.features.vector.JoVector;
import org.junit.jupiter.api.Test;

class AxisAngleDirectionPlaneTest {

    @Test
    void test() throws Exception {
        JoValue angle = new JoValue(JoValue.USER, 45.0 * Math.PI / 180);
        AxisAngleDirectionPlane axisAngleDirectionPlane = new AxisAngleDirectionPlane(JoAxis.Y, JoVector.I, angle);
        JoPlane plane = (JoPlane) axisAngleDirectionPlane.getResult();
        System.out.println("Plane: " + plane);
        angle.set(90.0 * Math.PI / 180);
        plane.getRegenerativeLink().regenerate();
        System.out.println("Plane: " + plane);
    }

}