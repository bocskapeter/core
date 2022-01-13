package eu.bopet.jocadv.core.constraints.regenerative;

import eu.bopet.jocadv.core.constraints.regenerative.vector.CrossVector;
import eu.bopet.jocadv.core.constraints.regenerative.vector.OppositeVector;
import eu.bopet.jocadv.core.features.vector.JoVector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OppositeVectorTest {
    @Test
    void oppositeVector() throws ParallelVectorException {
        CrossVector crossVector = new CrossVector(JoVector.I,JoVector.J);
        JoVector vector = (JoVector) crossVector.getResult();
        assertEquals(vector.getX().get(),0.0);
        assertEquals(vector.getY().get(),0.0);
        assertEquals(vector.getZ().get(),1.0);
        OppositeVector oppositeVector1 = new OppositeVector(vector);
        JoVector oppositeVector = (JoVector) oppositeVector1.getResult();
        assertEquals(oppositeVector.getX().get(),-0.0);
        assertEquals(oppositeVector.getY().get(),-0.0);
        assertEquals(oppositeVector.getZ().get(),-1.0);
        OppositeVector oppositeVector2 = new OppositeVector(oppositeVector);
        JoVector lastVector = (JoVector) oppositeVector2.getResult();
        assertEquals(lastVector.getX().get(),0.0);
        assertEquals(lastVector.getY().get(),0.0);
        assertEquals(lastVector.getZ().get(),1.0);
        OppositeVector oppositeVector3 = new OppositeVector(lastVector);
        JoVector lastVector2 = (JoVector) oppositeVector3.getResult();
        assertEquals(lastVector2.getX().get(),-0.0);
        assertEquals(lastVector2.getY().get(),-0.0);
        assertEquals(lastVector2.getZ().get(),-1.0);
    }

}