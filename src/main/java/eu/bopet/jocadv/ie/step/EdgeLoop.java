package eu.bopet.jocadv.ie.step;

import java.util.List;

public class EdgeLoop extends StepEntity {
    private List<Integer> edgeIdList;

    public EdgeLoop(List<Integer> edgeIdList) {
        this.edgeIdList = edgeIdList;
    }

    @Override
    public String toString() {
        return "EdgeLoop{" + super.toString() +
                " edgeIdList=" + edgeIdList +
                '}';
    }
}
