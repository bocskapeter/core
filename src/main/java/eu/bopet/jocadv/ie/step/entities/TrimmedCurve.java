package eu.bopet.jocadv.ie.step.entities;

import eu.bopet.jocadv.ie.step.util.UtilInt;

import java.util.LinkedHashSet;
import java.util.Set;

public class TrimmedCurve extends UtilInt {
    private Set<SelectedTrim> trim1;
    private Set<SelectedTrim> trim2;
    private boolean sense;
    private TrimmingPreference preference;

    public TrimmedCurve(int id, String name, String attribute) {
        super(id, name, attribute.substring(0, attribute.indexOf(",")));
        trim1 = new LinkedHashSet<>();
        trim2 = new LinkedHashSet<>();
        preference = TrimmingPreference.valueOf(attribute.substring(attribute.lastIndexOf(",") + 1).replace(".", ""));
        String[] trim1String = attribute.substring(attribute.indexOf(",") + 2, attribute.indexOf("),(")).split(",");
        String[] trim2String = attribute.substring(attribute.indexOf("),(") + 3, attribute.lastIndexOf("),")).split(",");
        switch (preference) {
            case PARAMETER: {
                for (String s : trim1String) {
                    ParameterValue parameterValue = new ParameterValue(s.substring(s.indexOf("(") + 1, s.indexOf(")")));
                    trim1.add(parameterValue);
                }
                for (String s : trim2String) {
                    ParameterValue parameterValue = new ParameterValue(s.substring(s.indexOf("(") + 1, s.indexOf(")")));
                    trim2.add(parameterValue);
                }
                break;
            }
            case CARTESIAN: {
                CartesianTrim cartesianTrim1 = new CartesianTrim(-1, "", trim1String[0]);
                CartesianTrim cartesianTrim2 = new CartesianTrim(-1, "", trim2String[0]);
                trim1.add(cartesianTrim1);
                trim2.add(cartesianTrim2);
                break;
            }
            case UNSPECIFIED: {
                if (trim1String[0].contains("PARAMETER_VALUE")) {
                    for (String s : trim1String) {
                        ParameterValue parameterValue = new ParameterValue(s.substring(s.indexOf("(") + 1, s.indexOf(")")));
                        trim1.add(parameterValue);
                    }
                    for (String s : trim2String) {
                        ParameterValue parameterValue = new ParameterValue(s.substring(s.indexOf("(") + 1, s.indexOf(")")));
                        trim2.add(parameterValue);
                    }
                    break;
                }
                System.out.println("Not processed trimmed curve: unspecified!");
                System.out.println("Attribute: " + attribute);
                break;
            }
        }
        String senseString = attribute.substring(attribute.lastIndexOf("),") + 2, attribute.lastIndexOf(","));
        sense = senseString.contains("T");
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
