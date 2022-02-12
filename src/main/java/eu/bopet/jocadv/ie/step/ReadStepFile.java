package eu.bopet.jocadv.ie.step;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ReadStepFile {
    static final String CARTESIAN_POINT = "CARTESIAN_POINT";
    static final String DIRECTION = "DIRECTION";
    static final String VECTOR = "VECTOR";
    static final String LINE = "LINE";
    static final String VERTEX_POINT = "VERTEX_POINT";
    static final String EDGE_CURVE = "EDGE_CURVE";
    static final String P_CURVE = "PCURVE";
    static final String AXIS2_PLACEMENT_3D = "AXIS2_PLACEMENT_3D";
    static final String PLANE = "PLANE";
    static final String ORIENTED_EDGE = "ORIENTED_EDGE";
    static final String SURFACE_CURVE = "SURFACE_CURVE";
    static final String EDGE_LOOP = "EDGE_LOOP";
    static final String FACE_BOUND = "FACE_BOUND";
    static final String ADVANCED_FACE = "ADVANCED_FACE";
    static final String CLOSED_SHELL = "CLOSED_SHELL";
    static final String MANIFOLD_SOLID_BREP = "MANIFOLD_SOLID_BREP";
    static final String DEFINITIONAL_REPRESENTATION = "DEFINITIONAL_REPRESENTATION";
    static final String CYLINDRICAL_SURFACE = "CYLINDRICAL_SURFACE";
    static final String CIRCLE = "CIRCLE";
    static final String TOROIDAL_SURFACE = "TOROIDAL_SURFACE";
    static final String AXIS2_PLACEMENT_2D = "AXIS2_PLACEMENT_2D";
    static final String B_SPLINE_CURVE_WITH_KNOTS = "B_SPLINE_CURVE_WITH_KNOTS";
    static final String SEAM_CURVE = "SEAM_CURVE";
    static final String ELLIPSE = "ELLIPSE";
    static final String SURFACE_OF_LINEAR_EXTRUSION = "SURFACE_OF_LINEAR_EXTRUSION";
    static final String CONICAL_SURFACE = "CONICAL_SURFACE";

    public static List<StepEntity> readStepFile(File file) {
        List<StepEntity> result = new ArrayList<>();
        System.out.println("Starting with file: " + file.getPath() + " - " + file.getName());
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            StringBuilder stringBuilder = new StringBuilder();
            // get the whole file
            for (String line; (line = br.readLine()) != null; ) {
                stringBuilder.append(line);
            }
            // process the lines
            String[] commands = stringBuilder.toString().split(";");
            for (String command : commands) {
                if (command.startsWith("#")) {
                    String[] tags = command.split("=");
                    String idString = tags[0].substring(1).replaceAll("\\s+", "");
                    int id = Integer.parseInt(idString);

                    String secondTag = tags[1].stripLeading();
                    String attribute = secondTag.substring(secondTag.indexOf("(") + 1, secondTag.lastIndexOf(")"));
                    String[] att = attribute.split(",", 2);
                    String name = att[0].replaceAll("'", "");

                    if (secondTag.startsWith(CARTESIAN_POINT)) {
                        String bracket = att[1];
                        String substring = bracket.substring(bracket.indexOf("(") + 1, bracket.lastIndexOf(")"));
                        String[] values = substring.split(",");
                        double[] coordinates = new double[values.length];
                        for (int i = 0; i < coordinates.length; i++) {
                            coordinates[i] = Double.parseDouble(values[i]);
                        }
                        CartesianPoint point = new CartesianPoint(coordinates);
                        point.setId(id);
                        point.setName(name);
                        result.add(point);
                        System.out.println("Cartesian Point: " + point);
                        continue;
                    }

                    if (secondTag.startsWith(DIRECTION)) {
                        String bracket = att[1];
                        String substring = bracket.substring(bracket.indexOf("(") + 1, bracket.lastIndexOf(")"));
                        String[] values = substring.split(",");
                        double[] coordinates = new double[values.length];
                        for (int i = 0; i < coordinates.length; i++) {
                            coordinates[i] = Double.parseDouble(values[i]);
                        }
                        Direction direction = new Direction(coordinates);
                        direction.setId(id);
                        direction.setName(name);
                        result.add(direction);
                        System.out.println("Direction: " + direction);
                        continue;
                    }

                    if (secondTag.startsWith(VECTOR)) {
                        String bracket = att[1];
                        String[] values = bracket.split(",");
                        int directionId = Integer.parseInt(values[0].substring(1));
                        double length = Double.parseDouble(values[1]);
                        Vector vector = new Vector(directionId, length);
                        vector.setId(id);
                        vector.setName(name);
                        result.add(vector);
                        System.out.println("Vector: " + vector);
                        continue;
                    }

                    if (secondTag.startsWith(LINE)) {
                        String bracket = att[1];
                        String[] values = bracket.split(",");
                        int cartesianPointId = Integer.parseInt(values[0].substring(1));
                        int vectorId = Integer.parseInt(values[1].substring(1));
                        Line line = new Line(cartesianPointId, vectorId);
                        line.setId(id);
                        line.setName(name);
                        result.add(line);
                        System.out.println("Line: " + line);
                        continue;
                    }

                    if (secondTag.startsWith(VERTEX_POINT)) {
                        String bracket = att[1];
                        int pointId = Integer.parseInt(bracket.substring(1));
                        VertexPoint vertexPoint = new VertexPoint(pointId);
                        vertexPoint.setId(id);
                        vertexPoint.setName(name);
                        result.add(vertexPoint);
                        System.out.println("Vertex Point: " + vertexPoint);
                        continue;
                    }

                    if (secondTag.startsWith(EDGE_CURVE)) {
                        String bracket = att[1];
                        String[] values = bracket.split(",");
                        int startId = Integer.parseInt(values[0].substring(1));
                        int endId = Integer.parseInt(values[1].substring(1));
                        int curveId = Integer.parseInt(values[2].substring(1));
                        boolean sameSense = values[3].contains("T");
                        EdgeCurve edgeCurve = new EdgeCurve(startId, endId, curveId, sameSense);
                        edgeCurve.setId(id);
                        edgeCurve.setName(name);
                        result.add(edgeCurve);
                        System.out.println("Edge Curve: " + edgeCurve);
                        continue;
                    }

                    if (secondTag.startsWith(P_CURVE)) {
                        String bracket = att[1];
                        String[] values = bracket.split(",");
                        int basisSurfaceId = Integer.parseInt(values[0].substring(1));
                        int referenceToCurveId = Integer.parseInt(values[1].substring(1));
                        PCurve pCurve = new PCurve(basisSurfaceId, referenceToCurveId);
                        pCurve.setId(id);
                        pCurve.setName(name);
                        result.add(pCurve);
                        System.out.println("PCurve: " + pCurve);
                        continue;
                    }

                    if (secondTag.startsWith(AXIS2_PLACEMENT_3D)) {
                        String bracket = att[1];
                        String[] values = bracket.split(",");
                        int locationId = Integer.parseInt(values[0].substring(1));
                        int axisId = Integer.parseInt(values[1].substring(1));
                        int refDirectionId = Integer.parseInt(values[2].substring(1));
                        Axis2Placement3D axis2Placement3D = new Axis2Placement3D(locationId, axisId, refDirectionId);
                        axis2Placement3D.setId(id);
                        axis2Placement3D.setName(name);
                        result.add(axis2Placement3D);
                        System.out.println("Axis2 Placement 3D: " + axis2Placement3D);
                        continue;
                    }

                    if (secondTag.startsWith(PLANE)) {
                        int axis2Placement3DId = Integer.parseInt(att[1].substring(1));
                        Plane plane = new Plane(axis2Placement3DId);
                        plane.setId(id);
                        plane.setName(name);
                        result.add(plane);
                        System.out.println("Plane: " + plane);
                        continue;
                    }

                    if (secondTag.startsWith(ORIENTED_EDGE)) {
                        String bracket = att[1];
                        String[] values = bracket.split(",");
                        int startId;
                        if (values[0].contains("*")) startId = -1;
                        else startId = Integer.parseInt(values[0].substring(1));
                        int endId;
                        if (values[1].contains("*")) endId = -1;
                        else endId = Integer.parseInt(values[1].substring(1));
                        int edgeId = Integer.parseInt(values[2].substring(1));
                        boolean orientation = values[3].contains("T");
                        OrientedEdge orientedEdge = new OrientedEdge(startId, endId, edgeId, orientation);
                        orientedEdge.setId(id);
                        orientedEdge.setName(name);
                        result.add(orientedEdge);
                        System.out.println("Oriented Edge: " + orientedEdge);
                        continue;
                    }

                    if (secondTag.startsWith(SURFACE_CURVE)) {
                        String bracket = att[1];
                        String[] values = bracket.split(",");
                        int curveId = Integer.parseInt(values[0].substring(1));
                        String substring = bracket.substring(bracket.indexOf("(") + 1, bracket.lastIndexOf(")"));
                        String[] geometries = substring.split(",");
                        List<Integer> associatedGeometry = new ArrayList<>();
                        for (String geometry : geometries) {
                            associatedGeometry.add(Integer.parseInt(geometry.substring(1)));
                        }
                        String last = values[values.length - 1].replace(".", "");
                        PreferredSurfaceCurveRepresentation rep = PreferredSurfaceCurveRepresentation.valueOf(last);
                        SurfaceCurve surfaceCurve = new SurfaceCurve(curveId, associatedGeometry, rep);
                        surfaceCurve.setId(id);
                        surfaceCurve.setName(name);
                        result.add(surfaceCurve);
                        System.out.println("Surface Curve: " + surfaceCurve);
                        continue;
                    }

                    if (secondTag.startsWith(EDGE_LOOP)) {
                        String bracket = att[1];
                        String substring = bracket.substring(bracket.indexOf("(") + 1, bracket.lastIndexOf(")"));
                        String[] values = substring.split(",");
                        List<Integer> edgeIdList = new ArrayList<>();
                        for (String value : values) {
                            int edgeId = Integer.parseInt(value.substring(1));
                            edgeIdList.add(edgeId);
                        }
                        EdgeLoop edgeLoop = new EdgeLoop(edgeIdList);
                        edgeLoop.setId(id);
                        edgeLoop.setName(name);
                        result.add(edgeLoop);
                        System.out.println("Edge Loop: " + edgeLoop);
                        continue;
                    }

                    if (secondTag.startsWith(FACE_BOUND)) {
                        String bracket = att[1];
                        String[] values = bracket.split(",");
                        int loopId = Integer.parseInt(values[0].substring(1));
                        boolean orientation = values[1].contains("T");
                        FaceBound faceBound = new FaceBound(loopId, orientation);
                        faceBound.setId(id);
                        faceBound.setName(name);
                        result.add(faceBound);
                        System.out.println("Face bound: " + faceBound);
                        continue;
                    }

                    if (secondTag.startsWith(ADVANCED_FACE)) {
                        String bracket = att[1];
                        String substring = bracket.substring(bracket.indexOf("(") + 1, bracket.lastIndexOf(")"));
                        String[] values = substring.split(",");
                        Set<Integer> boundIds = new LinkedHashSet<>();
                        for (String value : values) {
                            boundIds.add(Integer.parseInt(value.substring(1)));
                        }
                        String[] rest = (bracket.substring(bracket.indexOf(")") + 1)).split(",");
                        int surfaceId = Integer.parseInt(rest[1].substring(1));
                        boolean sameSense = rest[2].contains("T");
                        AdvancedFace advancedFace = new AdvancedFace(boundIds, surfaceId, sameSense);
                        advancedFace.setId(id);
                        advancedFace.setName(name);
                        result.add(advancedFace);
                        System.out.println("Advanced face: " + advancedFace);
                        continue;
                    }

                    if (secondTag.startsWith(CLOSED_SHELL)) {
                        String bracket = att[1].substring(att[1].indexOf("(") + 1, att[1].lastIndexOf(")"))
                                .replaceAll(" ", "");
                        String[] values = bracket.split(",");
                        Set<Integer> faceIds = new LinkedHashSet<>();
                        for (String value : values) {
                            int faceId = Integer.parseInt(value.substring(1));
                            faceIds.add(faceId);
                        }
                        ClosedShell closedShell = new ClosedShell(faceIds);
                        closedShell.setId(id);
                        closedShell.setName(name);
                        result.add(closedShell);
                        System.out.println("Closed shell: " + closedShell);
                        continue;
                    }

                    if (secondTag.startsWith(MANIFOLD_SOLID_BREP)) {
                        String bracket = att[1];
                        int shellId = Integer.parseInt(bracket.substring(1));
                        ManifoldSolidBRep manifoldSolidBRep = new ManifoldSolidBRep(shellId);
                        manifoldSolidBRep.setId(id);
                        manifoldSolidBRep.setName(name);
                        result.add(manifoldSolidBRep);
                        System.out.println("Manifold solid BRep: " + manifoldSolidBRep);
                        continue;
                    }

                    if (secondTag.startsWith(DEFINITIONAL_REPRESENTATION)) {
                        String bracket = att[1];
                        String substring = bracket.substring(bracket.indexOf("(") + 1, bracket.lastIndexOf(")"));
                        String[] items = substring.split(",");
                        Set<Integer> itemIds = new LinkedHashSet<>();
                        for (String item : items) {
                            itemIds.add(Integer.parseInt(item.substring(1)));
                        }
                        String last = bracket.substring(bracket.lastIndexOf(",") + 1);
                        int contextId = Integer.parseInt(last.substring(1));
                        DefinitionalRepresentation definitionalRepresentation
                                = new DefinitionalRepresentation(itemIds, contextId);
                        definitionalRepresentation.setId(id);
                        definitionalRepresentation.setName(name);
                        result.add(definitionalRepresentation);
                        System.out.println("Definitional representation: " + definitionalRepresentation);
                        continue;
                    }

                    if (secondTag.startsWith(CYLINDRICAL_SURFACE)) {
                        String bracket = att[1];
                        String[] values = bracket.split(",");
                        int positionId = Integer.parseInt(values[0].substring(1));
                        double radius = Double.parseDouble(values[1]);
                        CylindricalSurface cylindricalSurface = new CylindricalSurface(positionId, radius);
                        cylindricalSurface.setId(id);
                        cylindricalSurface.setName(name);
                        result.add(cylindricalSurface);
                        System.out.println("Cylindrical surface: " + cylindricalSurface);
                        continue;
                    }

                    if (secondTag.startsWith(CIRCLE)) {
                        String bracket = att[1];
                        String[] values = bracket.split(",");
                        int positionId = Integer.parseInt(values[0].substring(1));
                        double radius = Double.parseDouble(values[1]);
                        Circle circle = new Circle(positionId, radius);
                        circle.setId(id);
                        circle.setName(name);
                        result.add(circle);
                        System.out.println("Circle: " + circle);
                        continue;
                    }

                    if (secondTag.startsWith(TOROIDAL_SURFACE)) {
                        String bracket = att[1];
                        String[] values = bracket.split(",");
                        int positionId = Integer.parseInt(values[0].substring(1));
                        double majorRadius = Double.parseDouble(values[1]);
                        double minorRadius = Double.parseDouble(values[2]);
                        ToroidalSurface toroidalSurface = new ToroidalSurface(positionId, majorRadius, minorRadius);
                        toroidalSurface.setId(id);
                        toroidalSurface.setName(name);
                        result.add(toroidalSurface);
                        System.out.println("Toroidal surface: " + toroidalSurface);
                        continue;
                    }

                    if (secondTag.startsWith(AXIS2_PLACEMENT_2D)) {
                        String bracket = att[1];
                        String[] values = bracket.split(",");
                        int locationId = Integer.parseInt(values[0].substring(1));
                        int refDirectionId = Integer.parseInt(values[1].substring(1));
                        Axis2Placement2D axis2Placement2D = new Axis2Placement2D(locationId, refDirectionId);
                        axis2Placement2D.setId(id);
                        axis2Placement2D.setName(name);
                        result.add(axis2Placement2D);
                        System.out.println("Axis2 placement 2D: " + axis2Placement2D);
                        continue;
                    }

                    if (secondTag.startsWith(B_SPLINE_CURVE_WITH_KNOTS)) {
                        String bracket = att[1];
                        String[] values = bracket.split(",");
                        int degree = Integer.parseInt(values[0]);
                        String substring = bracket.substring(bracket.indexOf("(") + 1, bracket.indexOf(")"))
                                .replaceAll(" ", "");
                        String[] pointIDs = substring.split(",");
                        List<Integer> pointIdList = new ArrayList<>();
                        for (String pointId : pointIDs) {
                            int pId = Integer.parseInt(pointId.substring(1));
                            pointIdList.add(pId);
                        }
                        substring = bracket.substring(bracket.indexOf(")") + 1);
                        String[] parts = substring.split(",");
                        BSplineCurveForm curveForm =
                                BSplineCurveForm.valueOf(parts[1].replace(".", ""));
                        boolean closedCurve = parts[2].contains("T");
                        boolean selfIntersect = parts[3].contains("T");
                        String knotStrings = substring.substring(substring.indexOf("(") + 1, substring.indexOf(")"));
                        String[] knotStringArray = knotStrings.split(",");
                        List<Integer> knotMultiplicities = new ArrayList<>();
                        for (String knotString : knotStringArray) {
                            int knotInt = Integer.parseInt(knotString);
                            knotMultiplicities.add(knotInt);
                        }
                        substring = substring.substring(substring.indexOf(")") + 1);
                        knotStrings = substring.substring(substring.indexOf("(") + 1, substring.indexOf(")"));
                        knotStringArray = knotStrings.split(",");
                        List<Double> knots = new ArrayList<>();
                        for (String knotString : knotStringArray) {
                            double knot = Double.parseDouble(knotString);
                            knots.add(knot);
                        }
                        substring = substring.substring(substring.indexOf(")") + 1);
                        parts = substring.split(",");
                        KnotType knotType = KnotType.valueOf(parts[1].replace(".", ""));
                        BSplineCurveWithKnots bSplineCurveWithKnots
                                = new BSplineCurveWithKnots(degree, pointIdList, curveForm, closedCurve, selfIntersect,
                                knotMultiplicities, knots, knotType);
                        bSplineCurveWithKnots.setId(id);
                        bSplineCurveWithKnots.setName(name);
                        result.add(bSplineCurveWithKnots);
                        System.out.println("BSpline curve with knots: " + bSplineCurveWithKnots);
                        continue;
                    }

                    if (secondTag.startsWith(SEAM_CURVE)) {
                        String bracket = att[1];
                        String[] values = bracket.split(",");

                        int curveId = Integer.parseInt(values[0].substring(1));

                        String substring = bracket.substring(bracket.indexOf("(") + 1, bracket.lastIndexOf(")"));
                        values = substring.split(",");
                        List<Integer> associatedGeometryIds = new ArrayList<>();
                        for (String value : values) {
                            int associatedGeometryId = Integer.parseInt(value.substring(1));
                            associatedGeometryIds.add(associatedGeometryId);
                        }
                        String masterRepString = bracket.substring(bracket.lastIndexOf(",") + 1)
                                .replace(".", "");
                        PreferredSurfaceCurveRepresentation masterRep =
                                PreferredSurfaceCurveRepresentation.valueOf(masterRepString);
                        SeamCurve seamCurve = new SeamCurve(curveId, associatedGeometryIds, masterRep);
                        seamCurve.setId(id);
                        seamCurve.setName(name);
                        result.add(seamCurve);
                        System.out.println("Seam curve: " + seamCurve);
                        continue;
                    }

                    if (secondTag.startsWith(ELLIPSE)) {
                        String bracket = att[1];
                        String[] values = bracket.split(",");
                        int positionId = Integer.parseInt(values[0].substring(1));
                        double axis1 = Double.parseDouble(values[1]);
                        double axis2 = Double.parseDouble(values[2]);
                        Ellipse ellipse = new Ellipse(positionId, axis1, axis2);
                        ellipse.setId(id);
                        ellipse.setName(name);
                        result.add(ellipse);
                        System.out.println("Ellipse: " + ellipse);
                        continue;
                    }

                    if (secondTag.startsWith(SURFACE_OF_LINEAR_EXTRUSION)) {
                        String bracket = att[1];
                        String[] values = bracket.split(",");
                        int curveId = Integer.parseInt(values[0].substring(1));
                        int axisId = Integer.parseInt(values[1].substring(1));
                        SurfaceOfLinearExtrusion surfaceOfLinearExtrusion =
                                new SurfaceOfLinearExtrusion(curveId, axisId);
                        surfaceOfLinearExtrusion.setId(id);
                        surfaceOfLinearExtrusion.setName(name);
                        result.add(surfaceOfLinearExtrusion);
                        System.out.println("Surface of linear extrusion: " + surfaceOfLinearExtrusion);
                        continue;
                    }

                    if (secondTag.startsWith(CONICAL_SURFACE)) {
                        System.out.println(command);
                        String bracket = att[1];
                        String[] values = bracket.split(",");
                        int positionId = Integer.parseInt(values[0].substring(1));
                        double radius = Double.parseDouble(values[1]);
                        double angle = Double.parseDouble(values[2]);
                        ConicalSurface conicalSurface = new ConicalSurface(positionId, radius, angle);
                        conicalSurface.setId(id);
                        conicalSurface.setName(name);
                        result.add(conicalSurface);
                        System.out.println("Conical surface: " + conicalSurface);
                        continue;
                    }

                    System.out.println("!!! not processed: " + command);

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
