package eu.bopet.jocadv.core.constraints;

import eu.bopet.jocadv.core.features.datums.vector.JoValue;

import java.util.List;

public interface Constraint {
    public final static short USER_DEFINED = 1;
    public final static short AUTO_CONSTRAINT = 2;

    /**
     *
     * @return status
     */
    short getStatus();


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
