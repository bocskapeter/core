package eu.bopet.jocadv.core.constraints.regenerative;

import eu.bopet.jocadv.core.constraints.regenerative.point.ToPlaneProjectedPoint;
import eu.bopet.jocadv.core.constraints.regenerative.plane.OffsetPlane;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import eu.bopet.jocadv.core.features.datums.JoPlane;
import eu.bopet.jocadv.core.features.sketch.JoSValue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToPlaneProjectedPointTest {

    @Test
    void createProjectedPoint() throws Exception {
        System.out.println(" init ");
        JoSValue offset = new JoSValue(JoSValue.USER, 0.0);
        OffsetPlane offsetPlane = new OffsetPlane(JoPlane.XY, offset);
        ToPlaneProjectedPoint toPlaneProjectedPoint = new ToPlaneProjectedPoint((JoPlane) offsetPlane.getResult(), JoPoint.ORIGIN);
        System.out.println(" change offset ");
        offset.set(1.0);
        System.out.println(" start regenerate ");
        offsetPlane.regenerate();
        toPlaneProjectedPoint.regenerate();
        JoPoint point = (JoPoint) toPlaneProjectedPoint.getResult();
        System.out.println(" regenerate compete");
        assertEquals(point.getVector().getZ().get(),offset.get());
    }

}