package eu.bopet.jocadv.core.features;


import org.apache.commons.math3.util.Precision;

public class JoValue {
    public final static short CONSTANT = 0;   // no status no value change can be done
    public final static short USER = 1;       // no status          change can be done
    public final static short IMPORTED = 2;   // no status          change can be done
    public final static short FIX = 3;        //           no value change can be done
    public final static short VARIABLE = 4;   //                    change can be done
    public final static short AUTO = 5;       //                    change can be done
    public final static JoValue ZERO = new JoValue(CONSTANT, 0);
    public final static JoValue ONE = new JoValue(CONSTANT, 1.0);
    /**
     * Under this value the values are considered the same. Like a kind of resolution.
     */
    public static final double DEFAULT_TOLERANCE = 1.00e-12;
    /**
     * Rounding the values to this number of digits. Related to the default tolerance value.
     */
    public static final int NUMBER_OF_DIGITS_TO_SCALE = 12;
    /**
     * Interval for the numerical derivative calculation.
     */
    public static final double NUMERICAL_DERIVATIVE_RESOLUTION = 0.1 * DEFAULT_TOLERANCE;
    private static final String[] SYMBOLS = {"⏚", "🖳", "↴", "✔", "↔", "?"};
    private short status;
    private double value;
    private double stored;

    public JoValue(short status, double value) {
        this.status = status;
        this.value = value;
        this.stored = value;
    }

    public JoValue(double value) {
        this.status = AUTO;
        this.value = value;
        this.stored = value;
    }

    public double get() {
        return value;
    }

    public void set(double newValue) {
        if (status == USER || status == IMPORTED || status == AUTO || status == VARIABLE) {
            double difference = Math.abs(newValue - value);
            if (difference > JoValue.DEFAULT_TOLERANCE) {
                this.value = Precision.round(newValue, NUMBER_OF_DIGITS_TO_SCALE);
            }
        }
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        if (this.status == FIX || this.status == AUTO || this.status == VARIABLE) {
            this.status = status;
        }
    }

    public void store() {
        stored = value;
    }

    public void restore() {
        value = stored;
    }

    @Override
    public String toString() {
        return "{" + SYMBOLS[status] + " " + value + "/" + stored + '}';
    }
}
