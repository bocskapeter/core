package eu.bopet.jocadv.core.features.datums.vector;

public class JoValue {
    public final static short CONSTANT = 0;
    public final static short USER = 1;
    public final static short FIX = 2;
    public final static short VARIABLE = 3;

    public final static JoValue ZERO = new JoValue(CONSTANT, 0);
    public final static JoValue ONE = new JoValue(CONSTANT, 1.0);
    public static final double DEFAULT_TOLERANCE = 1.0e-10;

    private static final String[] SYMBOLS = {"⏚", "🖳", "x", "↔"};

    private short status;
    private double value;
    private double stored;

    public JoValue(double value) {
        this.value = value;
        this.stored = value;
        this.status = VARIABLE;
    }

    public JoValue(short status, double value) {
        this.status = status;
        this.value = value;
        this.stored = value;
    }

    public double get() {
        return value;
    }

    public void set(double newValue) {
        if (status == VARIABLE || status == USER) {
            this.value = newValue;
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
        return "Value{ " + SYMBOLS[status] + " " + value + " / " + stored + '}';
    }
}
