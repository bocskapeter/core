package eu.bopet.jocadv.ie.step;

import java.util.ArrayList;
import java.util.List;

public class EdgeLoop extends StepEntity {
    private List<Integer> edgeIdList;

    public EdgeLoop(List<Integer> edgeIdList) {
        this.edgeIdList = edgeIdList;
    }

    public static EdgeLoop getInstance(int id, String name, String attribute) {
        String substring = attribute.substring(attribute.indexOf("(") + 1, attribute.lastIndexOf(")"));
        String[] values = substring.split(",");
        List<Integer> edgeIdList = new ArrayList<>();
        for (String value : values) {
            int edgeId = Integer.parseInt(value.substring(1));
            edgeIdList.add(edgeId);
        }
        EdgeLoop edgeLoop = new EdgeLoop(edgeIdList);
        edgeLoop.setId(id);
        edgeLoop.setName(name);
        return edgeLoop;
    }

    @Override
    public String toString() {
        return "EdgeLoop{" + super.toString() +
                " edgeIdList=" + edgeIdList +
                '}';
    }
}
