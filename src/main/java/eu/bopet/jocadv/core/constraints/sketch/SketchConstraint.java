package eu.bopet.jocadv.core.constraints.sketch;

import eu.bopet.jocadv.core.features.vector.JoValue;

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
    List<JoValue> getValues();

    /**
     * @return function value - f(xn)
     */
    double getFunctionValue();

    /**
     * @return partial derivative - ∂f(xn)/∂xn - default is numerical derivative
     */
    default double getDerivative(JoValue joValue) {
        if (getValues().contains(joValue)) {
            double originalValue = joValue.get();
            joValue.set(originalValue + JoValue.NUMERICAL_DERIVATIVE_RESOLUTION);
            double functionValuePositiveDirection = getFunctionValue();
            joValue.set(originalValue - JoValue.NUMERICAL_DERIVATIVE_RESOLUTION);
            double functionValueNegativeDirection = getFunctionValue();
            joValue.set(originalValue);
            return (functionValuePositiveDirection - functionValueNegativeDirection)
                    / (2.0 * JoValue.NUMERICAL_DERIVATIVE_RESOLUTION);
        }
        return 0.0;
    }
}
