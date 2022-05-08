package eu.bopet.jocadv.ie.step.curve;

import eu.bopet.jocadv.ie.step.StepEntityBase;
import eu.bopet.jocadv.ie.step.representation.GeometricRepresentationItem;
import eu.bopet.jocadv.ie.step.representation.RepresentationItem;
import eu.bopet.jocadv.ie.step.util.StepCode;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Curves extends StepEntityBase {
    private Set<Curve> curves;

    public Curves(int id, String name, String set) {
        super(id, name);
        curves = new LinkedHashSet<>();
        List<String> curveStringList = StepEntityBase.getSets(set);
        for (String s : curveStringList) {
            for (String code : StepCode.CURVES) {
                if (s.startsWith(code)) {
                    String attributes = s.substring(s.indexOf("(") + 1, s.lastIndexOf(")"));
                    switch (code) {
                        case StepCode.RATIONAL_B_SPLINE_CURVE: {
                            RationalBSplineCurve curve = new RationalBSplineCurve(attributes);
                            curves.add(curve);
                            s = "";
                            continue;
                        }
                        case StepCode.B_SPLINE_CURVE_WITH_KNOTS: {
                            BSplineCurveWithKnots curve = new BSplineCurveWithKnots(attributes);
                            curves.add(curve);
                            s = "";
                            continue;
                        }
                        case StepCode.B_SPLINE_CURVE: {
                            BSplineCurve curve = new BSplineCurve(attributes);
                            curves.add(curve);
                            s = "";
                            continue;
                        }
                        case StepCode.BOUNDED_CURVE: {
                            BoundedCurve curve = new BoundedCurve();
                            curves.add(curve);
                            s = "";
                            continue;
                        }
                        case StepCode.CURVE: {
                            StepCurve curve = new StepCurve();
                            curves.add(curve);
                            s = "";
                            continue;
                        }
                        case StepCode.GEOMETRIC_REPRESENTATION_ITEM: {
                            GeometricRepresentationItem item = new GeometricRepresentationItem();
                            curves.add(item);
                            s = "";
                            continue;
                        }
                        case StepCode.REPRESENTATION_ITEM: {
                            RepresentationItem item = new RepresentationItem();
                            curves.add(item);
                            s = "";
                            continue;
                        }
                        default: {
                            System.out.println("Not processed curve: " + s);
                        }
                    }
                    System.out.println("!!! Curve not found: " + s);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Curves{" + super.toString() +
                " curves=" + curves +
                '}';
    }
}
