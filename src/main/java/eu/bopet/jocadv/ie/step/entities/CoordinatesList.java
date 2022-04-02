package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.StepEntityBase;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CoordinatesList extends StepEntityBase {

    private List<List<Double>> coordinates;

    public CoordinatesList(int id, String name, String attributes) {
        super(id, name);
        coordinates = new ArrayList<>();
        String[] coordinatesString = attributes.substring(attributes.indexOf(",(") + 1).split(Pattern.quote("),("));
        for (String s : coordinatesString) {
            List<Double> cList = new ArrayList<>();
            String[] c = s.replace("(", "").replace(")", "").split(",");
            for (String doubleString : c) {
                cList.add(Double.parseDouble(doubleString));
            }
            coordinates.add(cList);
        }
    }

    @Override
    public String toString() {
        return "CoordinatesList{" + super.toString() +
                "coordinates=" + coordinates +
                '}';
    }
}
