package eu.bopet.jocadv.core.features.basic;

import java.util.List;

public interface JoEdge {
    List<JoPoint> getPoints();
    void reverse();

    boolean sameSense();

    JoEdge getReverse();
}
