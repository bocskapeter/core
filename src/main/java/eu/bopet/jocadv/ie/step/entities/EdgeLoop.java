package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.core.features.basic.JoEdge;
import eu.bopet.jocadv.core.features.basic.JoEdgeLoop;
import eu.bopet.jocadv.core.features.basic.JoPoint;
import eu.bopet.jocadv.core.features.exception.NotContinuousEdgeLoop;
import eu.bopet.jocadv.core.features.sketch.JoSValue;
import eu.bopet.jocadv.ie.step.StepFeature;
import eu.bopet.jocadv.ie.step.StepLink;
import eu.bopet.jocadv.ie.step.util.UtilListOfInt;

import java.util.ArrayList;
import java.util.List;

public class EdgeLoop extends UtilListOfInt implements StepLink {
    public EdgeLoop(int id, String name, String attribute) {
        super(id, name, attribute);
    }

    @Override
    public String toString() {
        return "EdgeLoop{" + super.toString() + '}';
    }

    @Override
    public void generateJoFeature(StepFeature feature) throws Exception {
        List<Integer> edgeIds = super.getList();
        List<JoEdge> edges = new ArrayList<>();
        JoEdgeLoop edgeLoop = new JoEdgeLoop(edges);
        for (int i : edgeIds) {
            StepLink stepLink = (StepLink) feature.getStepEntityByID(i);
            if (!feature.getFeatureMap().containsKey(stepLink)) {
                stepLink.generateJoFeature(feature);
            }
            JoEdge joEdge = (JoEdge) feature.getFeatureMap().get(stepLink);
            edges.add(joEdge);
        }
        checkEdgeLoop(edgeLoop);
        edgeLoop.setIntID(super.getId());
        edgeLoop.setName(super.getName());
        feature.getFeatureMap().put(this, edgeLoop);
    }

    private void checkEdgeLoop(JoEdgeLoop edgeLoop) {
        List<JoEdge> edges = edgeLoop.getEdges();
//        if (!edges.isEmpty()) {
//            JoEdge lastEdge = edges.get(edges.size() - 1);
//            int index = 0;
//            if (!lastEdge.sameSense()) {
//                index = lastEdge.getPoints().size() - 1;
//            }
//            JoPoint lastPoint = lastEdge.getPoints().get(index);
//            index = 0;
//            if (!joEdge.sameSense()) {
//                index = joEdge.getPoints().size() - 1;
//            }
//            JoPoint firstPoint = joEdge.getPoints().get(index);
//            if (lastPoint != firstPoint) {
//                double distance = firstPoint.distance(lastPoint);
//                if (distance > JoSValue.DEFAULT_TOLERANCE) {
//                    System.out.println("--- distance: " + distance);
//                    System.out.println(this);
//                    System.out.println("StepLink: " + stepLink);
//                    System.out.println("Last edge: " + lastEdge);
//                    System.out.println("This edge: " + joEdge);
//                    System.out.println("first point: " + firstPoint);
//                    System.out.println("last point: " + lastPoint);
//                    throw new NotContinuousEdgeLoop(lastEdge, joEdge);
//                }
//            } else {
//
//            }
//        } else {
//
//        }
    }

    @Override
    public void regenerate() throws Exception {

    }
}
