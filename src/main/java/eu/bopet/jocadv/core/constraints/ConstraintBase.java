package eu.bopet.jocadv.core.constraints;

public abstract class ConstraintBase {
    private short status;

    public ConstraintBase(short status) {
        this.status = status;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }
}
