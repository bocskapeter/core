package eu.bopet.jocadv.core.features.exception;

import eu.bopet.jocadv.core.features.basic.JoEdge;

public class NotContinuousEdgeLoop extends Exception{
    private JoEdge firstEdge;
    private JoEdge secondEdge;

    public NotContinuousEdgeLoop(JoEdge firstEdge, JoEdge secondEdge) {
        this.firstEdge = firstEdge;
        this.secondEdge = secondEdge;
    }

    @Override
    public String toString() {
        return "NotContinuousEdgeLoop{" +
                "firstEdge=" + firstEdge +
                ", secondEdge=" + secondEdge +
                '}';
    }
}
