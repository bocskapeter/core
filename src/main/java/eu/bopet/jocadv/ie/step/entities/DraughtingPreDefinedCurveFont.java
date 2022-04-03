package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.StepEntityBase;

import java.util.Arrays;

public class DraughtingPreDefinedCurveFont extends StepEntityBase {
    public static String[] PRE_DEFINED_ITEMS = {
            "continuous",
            "chain",
            "chain double dash",
            "dashed",
            "dotted"
    };

    public DraughtingPreDefinedCurveFont(int id, String name) {
        super(id, name);
        if (!Arrays.asList(PRE_DEFINED_ITEMS).contains(name)) {
            System.out.println("Unknown curve font: " + name);
        }
    }

    @Override
    public String toString() {
        return "DraughtingPreDefinedCurveFont{" + super.toString() + "}";
    }
}