package eu.bopet.jocadv.ie.step.tolerance;

import java.util.LinkedHashSet;
import java.util.Set;

public class GeometricToleranceWithDatumReference extends GeometricTolerance {
    private Set<Integer> datumSystem;

    public GeometricToleranceWithDatumReference(int id, String name, String attribute) {
        super(id, name, attribute);
        datumSystem = new LinkedHashSet<>();
        String datumSystemString = attribute.substring(attribute.indexOf(",(") + 1);
        String[] parts = datumSystemString.replace("(", "").replace(")", "")
                .split(",");
        for (String s : parts) {
            datumSystem.add(Integer.parseInt(s.replace("#", "")));
        }
    }

    @Override
    public String toString() {
        return "GeometricToleranceWithDatumReference{" + super.toString() +
                ", datumSystem=" + datumSystem +
                '}';
    }
}
