package eu.bopet.jocadv.core.features;

public class SketchNotLoopException extends Exception{
    private final JoPoint intersectionPoint;

    public SketchNotLoopException(JoPoint intersectionPoint) {
        this.intersectionPoint = intersectionPoint;
    }

    @Override
    public String toString() {
        return "Sketch Not Loop Exception{" +
                "Intersection Point=" + intersectionPoint +
                '}';
    }
}
