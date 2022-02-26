package eu.bopet.jocadv.ie.step.curve;

import eu.bopet.jocadv.ie.step.util.StepCode;
import eu.bopet.jocadv.ie.step.util.StepEntity;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Curves extends StepEntity {
    private Set<Curve> curves;

    public Curves(int id, String name, String set) {
        super(id, name);
        curves = new LinkedHashSet<>();
        List<String> curveStringList = StepEntity.getSets(set, StepCode.CURVES);
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
                            Curve curve = new Curve();
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
                            System.out.println(item);
                            continue;
                        }

                    }
                    System.out.println("!!! Not found: " + s);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Curves{" +
                "curves=" + curves +
                '}';
    }
}