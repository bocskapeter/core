package eu.bopet.jocadv.ie.step.context;

public class Context {
    private String id;
    private String type;

    public Context(String id, String type) {
        this.id = id;
        this.type = type;
    }

    @Override
    public String toString() {
        return "id='" + id + '\'' + ", type='" + type + '\'';
    }
}
