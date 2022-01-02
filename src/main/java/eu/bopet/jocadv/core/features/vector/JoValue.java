package eu.bopet.jocadv.core.features.vector;

import org.apache.commons.math3.util.Precision;

public class JoValue {
    public final static short CONSTANT = 0;
    public final static short USER = 1;
    public final static short AUTO = 2;
    public final static short FIX = 3;
    public final static short VARIABLE = 4;


    public final static JoValue ZERO = new JoValue(CONSTANT, 0);
    public final static JoValue ONE = new JoValue(CONSTANT, 1.0);
    public static final double DEFAULT_TOLERANCE = 1.70e-12; //[mm] diameter of the nucleus for hydrogen
    public static final int NUMBER_OF_DIGITS_TO_SCALE = 11;

    private static final String[] SYMBOLS = {"⏚", "🖳", "?", "✔", "↔"};

    private short status;
    private double value;
    private double stored;

    public JoValue(short status, double value) {
        this.status = status;
        this.value = value;
        this.stored = value;
    }

    public double get() {
        return value;
    }

    public void set(double newValue) {
        if (status == VARIABLE || status == USER || status == AUTO) {
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
        if (status != CONSTANT) {
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
