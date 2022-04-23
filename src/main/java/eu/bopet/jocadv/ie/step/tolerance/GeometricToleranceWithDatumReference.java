package eu.bopet.jocadv.ie.step.tolerance;

import java.util.LinkedHashSet;
import java.util.Set;

public class GeometricToleranceWithDatumReference implements Tolerance {
    private Set<Integer> datumSystem;

    public GeometricToleranceWithDatumReference(String attribute) {
        datumSystem = new LinkedHashSet<>();
        String[] parts = attribute.replace("(", "").replace(")", "").split(",");
        for (String s : parts) {
            datumSystem.add(Integer.parseInt(s.replace("#", "")));
        }
    }

    @Override
    public String toString() {
        return "GeometricToleranceWithDatumReference{" +
                "datumSystem=" + datumSystem +
                '}';
    }
}
