package eu.bopet.jocadv.core.features.sketch.exception;

import eu.bopet.jocadv.core.features.datums.JoPlane;
import eu.bopet.jocadv.core.features.sketch.JoSphere;

public class NotValidCircleException extends Exception {
    private final JoSphere sphere;
    private final JoPlane plane;

    public NotValidCircleException(JoSphere sphere, JoPlane plane) {
        this.sphere = sphere;
        this.plane = plane;
    }

    @Override
    public String toString() {
        return "NotValidCircleException{" +
                "sphere=" + sphere +
                ", plane=" + plane +
                '}';
    }
}
