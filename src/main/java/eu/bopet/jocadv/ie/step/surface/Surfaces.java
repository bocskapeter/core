package eu.bopet.jocadv.ie.step.surface;

import eu.bopet.jocadv.ie.step.representation.GeometricRepresentationItem;
import eu.bopet.jocadv.ie.step.representation.RepresentationItem;
import eu.bopet.jocadv.ie.step.util.StepCode;
import eu.bopet.jocadv.ie.step.StepEntityBase;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Surfaces extends StepEntityBase {
    private Set<Surface> surfaces;

    public Surfaces(int id, String name, String set) {
        super(id, name);
        surfaces = new LinkedHashSet<>();
        List<String> surfaceStringList = StepEntityBase.getSets(set);
        for (String s : surfaceStringList) {
            for (String code : StepCode.SURFACES) {
                if (s.startsWith(code)) {
                    String attributes = s.substring(s.indexOf("(") + 1, s.lastIndexOf(")"));
                    switch (code) {
                        case StepCode.B_SPLINE_SURFACE_WITH_KNOTS: {
                            BSplineSurfaceWithKnots surface = new BSplineSurfaceWithKnots(-1, "", true, attributes);
                            surfaces.add(surface);
                            s = "";
                            continue;
                        }
                        case StepCode.RATIONAL_B_SPLINE_SURFACE: {
                            RationalBSplineSurface surface = new RationalBSplineSurface(attributes);
                            surfaces.add(surface);
                            s = "";
                            continue;
                        }
                        case StepCode.B_SPLINE_SURFACE: {
                            BSplineSurface surface = new BSplineSurface(attributes);
                            surfaces.add(surface);
                            s = "";
                            continue;
                        }
                        case StepCode.BOUNDED_SURFACE: {
                            BoundedSurface surface = new BoundedSurface();
                            surfaces.add(surface);
                            s = "";
                            continue;
                        }
                        case StepCode.GEOMETRIC_REPRESENTATION_ITEM: {
                            GeometricRepresentationItem surface = new GeometricRepresentationItem();
                            surfaces.add(surface);
                            s = "";
                            continue;
                        }
                        case StepCode.REPRESENTATION_ITEM: {
                            RepresentationItem surface = new RepresentationItem();
                            surfaces.add(surface);
                            s = "";
                            continue;
                        }
                        case StepCode.SURFACE: {
                            StepSurface surface = new StepSurface();
                            surfaces.add(surface);
                            s = "";
                            continue;
                        }
                    }
                    System.out.println("Code not processed: " + code);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Surfaces{" + super.toString() +
                " surfaces=" + surfaces +
                '}';
    }
}
