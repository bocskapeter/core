package eu.bopet.jocadv.ie.step.tolerance;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class GeometricToleranceWithModifiers implements Tolerance {
    private Set<GeometricToleranceModifier> modifiers;

    public GeometricToleranceWithModifiers(String attribute) {
        modifiers = new LinkedHashSet<>();
        String[] parts = attribute.split(Pattern.quote(","));
        for (String s : parts) {
            modifiers.add(GeometricToleranceModifier.valueOf(s.replace("(", "")
                    .replace(")", "").replace(".", "")
                    .replace(" ", "")));
        }
    }

    @Override
    public String toString() {
        return "GeometricToleranceWithModifiers{" +
                "modifiers=" + modifiers +
                '}';
    }
}
