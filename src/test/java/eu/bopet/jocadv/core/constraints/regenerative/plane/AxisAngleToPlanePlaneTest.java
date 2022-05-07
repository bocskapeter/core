package eu.bopet.jocadv.core.constraints.regenerative.plane;

import eu.bopet.jocadv.core.features.datums.JoAxis;
import eu.bopet.jocadv.core.features.datums.JoPlane;
import eu.bopet.jocadv.core.features.JoValue;
import org.junit.jupiter.api.Test;

class AxisAngleToPlanePlaneTest {

    @Test
    void test() throws Exception {
        JoValue angle = new JoValue(JoValue.USER, 45.0 * Math.PI / 180);
        AxisAngleToPlanePlane axisAngleToPlanePlane = new AxisAngleToPlanePlane(JoAxis.Y, JoPlane.YZ, angle);
        JoPlane plane = (JoPlane) axisAngleToPlanePlane.getResult();
        System.out.println("Plane: " + plane);
        angle.set(90.0 * Math.PI / 180);
        plane.getRegenerativeLink().regenerate();
        System.out.println("Plane: " + plane);
    }

}