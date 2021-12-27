package eu.bopet.jocadv.core.constraints.sketch;

import eu.bopet.jocadv.core.features.sketch.SketchGeometry;
import eu.bopet.jocadv.core.features.vector.JoValue;

import java.util.List;

public interface SketchConstraint {
    public final static short USER_DEFINED = 1;
    public final static short AUTO_CONSTRAINT = 2;

    /**
     * @return status
     */
    short getStatus();

    /**
     * @return list of geometries the constraint applied on
     */
    List<SketchGeometry> getGeometries();

    /**
     * @return list of values - xn
     */
    List<JoValue> getValues();

    /**
     * @return function value - f(xn)
     */
    double getFunctionValue();

    /**
     * @return partial derivative - ∂f(xn)/∂xn
     */
    double getDerivative(JoValue joValue);
}
