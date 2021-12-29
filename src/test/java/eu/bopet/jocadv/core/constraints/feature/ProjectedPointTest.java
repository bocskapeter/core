package eu.bopet.jocadv.core.constraints.feature;

import eu.bopet.jocadv.core.features.JoPoint;
import eu.bopet.jocadv.core.features.datums.JoPlane;
import eu.bopet.jocadv.core.features.vector.JoValue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjectedPointTest {

    @Test
    void createProjectedPoint() {
        System.out.println(" init ");
        JoValue offset = new JoValue(JoValue.USER, 0.0);
        OffsetPlane offsetPlane = new OffsetPlane(JoPlane.XY, offset);
        ProjectedPoint projectedPoint = new ProjectedPoint((JoPlane) offsetPlane.getResult(), JoPoint.ORIGIN);
        System.out.println(" change offset ");
        offset.set(1.0);
        System.out.println(" start regenerate ");
        offsetPlane.regenerate();
        projectedPoint.regenerate();
        JoPoint point = (JoPoint) projectedPoint.getResult();
        System.out.println(" regenerate compete");
        assertEquals(point.getVector().getZ().get(),offset.get());
    }

}