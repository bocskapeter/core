package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilInt;

import java.util.Set;

public class TrimmedCurve extends UtilInt {
    private Set<SelectedTrim> trim1;
    private Set<SelectedTrim> trim2;
    private boolean sense;
    private TrimmingPreference preference;

    public TrimmedCurve(int id, String name, String attribute) {
        super(id, name, attribute.substring(0, attribute.indexOf(",")));
        System.out.println("att: " + attribute);
        String trim1String = attribute.substring(attribute.indexOf(",") + 2, attribute.indexOf("),("));
        System.out.println("trim1: " + trim1String);

    }

    @Override
    public String toString() {
        return "TrimmedCurve{" + super.toString() +
                ", trim1=" + trim1 +
                ", trim2=" + trim2 +
                ", sense=" + sense +
                ", preference=" + preference +
                '}';
    }
}
