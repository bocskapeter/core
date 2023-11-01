package eu.bopet.jocadv.core.constraints.sketch;

import eu.bopet.jocadv.core.features.sketch.JoSValue;

import java.util.List;

public interface SketchConstraint {
    short SYSTEM = 0;
    short USER_DEFINED = 1;
    short AUTO_CONSTRAINT = 2;

    /**
     * @return status
     */
    short getStatus();

    /**
     * @return list of objects the constraint is using
     */
    List<Object> getComponents();

    /**
     * @return list of values - xn
     */
    List<JoSValue> getValues();

    /**
     * @return function value - f(xn)
     */
    double getFunctionValue();

    /**
     * @return partial derivative - ∂f(xn)/∂xn - default is numerical derivative
     */
    default double getDerivative(JoSValue joSValue) {
        if (getValues().contains(joSValue)) {
            double originalValue = joSValue.get();
            joSValue.set(originalValue + JoSValue.NUMERICAL_DERIVATIVE_RESOLUTION);
            double functionValuePositiveDirection = getFunctionValue();
            joSValue.set(originalValue - JoSValue.NUMERICAL_DERIVATIVE_RESOLUTION);
            double functionValueNegativeDirection = getFunctionValue();
            joSValue.set(originalValue);
            return (functionValuePositiveDirection - functionValueNegativeDirection)
                    / (2.0 * JoSValue.NUMERICAL_DERIVATIVE_RESOLUTION);
        }
        return 0.0;
    }
}
