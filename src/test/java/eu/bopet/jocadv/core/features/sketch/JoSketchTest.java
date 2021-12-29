package eu.bopet.jocadv.core.features.sketch;

import eu.bopet.jocadv.core.features.datums.JoCoSys;
import eu.bopet.jocadv.core.features.JoPoint;
import eu.bopet.jocadv.core.features.vector.JoValue;
import eu.bopet.jocadv.core.features.vector.JoVector;
import org.junit.jupiter.api.Test;

class JoSketchTest {

    @Test
    void addConstraint() {
        JoSketch sketch = new JoSketch(JoCoSys.DEFAULT_COORDINATE_SYSTEM,null);
        JoValue x1 = new JoValue(1.26);
        JoValue y1 = new JoValue(2.59);
        JoValue z1 = new JoValue(0.015);

        JoValue x2 = new JoValue(8.26);
        JoValue y2 = new JoValue(6.59);
        JoValue z2 = new JoValue(0.06);

        JoPoint point1 = new JoPoint(new JoVector(x1,y1,z1,null),null);
        JoPoint point2 = new JoPoint(new JoVector(x2,y2,z2,null),null);
        sketch.addGeometry(point1);
        sketch.addGeometry(point2);
    }
}