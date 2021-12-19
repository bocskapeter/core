package eu.bopet.jocadv.core.features.sketch;

import eu.bopet.jocadv.core.features.datums.JoPlane;
import eu.bopet.jocadv.core.features.datums.JoPoint;
import eu.bopet.jocadv.core.features.datums.vector.JoValue;
import eu.bopet.jocadv.core.features.datums.vector.JoVector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JoSketchTest {

    @Test
    void addConstraint() {
        JoSketch sketch = new JoSketch(JoPlane.XY);
        JoPoint point1 = new JoPoint(new JoVector(new JoValue(1.26),new JoValue(2.59),new JoValue(0.015)));
        JoPoint point2 = new JoPoint(new JoVector(new JoValue(8.26),new JoValue(6.59),new JoValue(0.06)));
        sketch.addGeometry(point1);
        sketch.addGeometry(point2);

    }
}