package eu.bopet.jocadv.ie.step;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadStepFile {

    public static List<StepEntity> readStepFile(File file) {
        List<StepEntity> result = new ArrayList<>();
        System.out.println("Starting with file: " + file.getPath() + " - " + file.getName());
        String errorLine = "";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String line; (line = br.readLine()) != null; ) {
                stringBuilder.append(line);
            }
            String[] commands = stringBuilder.toString().split(";");
            for (String command : commands) {
                errorLine = command;
                System.out.println(command);
                if (command.startsWith("#")) {
                    String[] tags = command.split("=");
                    int id = Integer.parseInt(tags[0].substring(1).replace(" ", ""));
                    String secondTag = tags[1].stripLeading();
                    String attribute = secondTag.substring(secondTag.indexOf("(") + 1, secondTag.lastIndexOf(")"));
                    String[] att = attribute.split(",", 2);
                    String name = att[0].replace("'", "");
                    if (secondTag.startsWith(StepCode.CARTESIAN_POINT)) {
                        CartesianPoint point = CartesianPoint.getInstance(id, name, att[1]);
                        result.add(point);
                        System.out.println(point);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.DIRECTION + "(")) {
                        Direction direction = Direction.getInstance(id, name, att[1]);
                        result.add(direction);
                        System.out.println(direction);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.VECTOR + "(")) {
                        Vector vector = Vector.getInstance(id, name, att[1]);
                        result.add(vector);
                        System.out.println(vector);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.LINE + "(")) {
                        Line line = Line.getInstance(id, name, att[1]);
                        result.add(line);
                        System.out.println(line);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.VERTEX_POINT)) {
                        VertexPoint vertexPoint = VertexPoint.getInstance(id, name, att[1]);
                        result.add(vertexPoint);
                        System.out.println(vertexPoint);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.EDGE_CURVE)) {
                        EdgeCurve edgeCurve = EdgeCurve.getInstance(id, name, att[1]);
                        result.add(edgeCurve);
                        System.out.println(edgeCurve);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.P_CURVE)) {
                        PCurve pCurve = PCurve.getInstance(id, name, att[1]);
                        result.add(pCurve);
                        System.out.println(pCurve);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.AXIS2_PLACEMENT_3D)) {
                        Axis2Placement3D axis2Placement3D = Axis2Placement3D.getInstance(id, name, att[1]);
                        result.add(axis2Placement3D);
                        System.out.println(axis2Placement3D);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.PLANE + "(")) {
                        Plane plane = Plane.getInstance(id, name, att[1]);
                        result.add(plane);
                        System.out.println(plane);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.ORIENTED_EDGE)) {
                        OrientedEdge orientedEdge = OrientedEdge.getInstance(id, name, att[1]);
                        result.add(orientedEdge);
                        System.out.println(orientedEdge);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.SURFACE_CURVE + "(")) {
                        SurfaceCurve surfaceCurve = SurfaceCurve.getInstance(id, name, att[1]);
                        result.add(surfaceCurve);
                        System.out.println(surfaceCurve);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.EDGE_LOOP)) {
                        EdgeLoop edgeLoop = EdgeLoop.getInstance(id, name, att[1]);
                        result.add(edgeLoop);
                        System.out.println(edgeLoop);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.FACE_BOUND)) {
                        FaceBound faceBound = FaceBound.getInstance(id, name, att[1]);
                        result.add(faceBound);
                        System.out.println(faceBound);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.ADVANCED_FACE)) {
                        AdvancedFace advancedFace = AdvancedFace.getInstance(id, name, att[1]);
                        result.add(advancedFace);
                        System.out.println(advancedFace);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.CLOSED_SHELL)) {
                        ClosedShell closedShell = ClosedShell.getInstance(id, name, att[1]);
                        result.add(closedShell);
                        System.out.println(closedShell);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.MANIFOLD_SOLID_B_REP)) {
                        ManifoldSolidBRep manifoldSolidBRep = ManifoldSolidBRep.getInstance(id, name, att[1]);
                        result.add(manifoldSolidBRep);
                        System.out.println(manifoldSolidBRep);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.DEFINITIONAL_REPRESENTATION + "(")) {
                        DefinitionalRepresentation definitionalRepresentation
                                = DefinitionalRepresentation.getInstance(id, name, att[1]);
                        result.add(definitionalRepresentation);
                        System.out.println(definitionalRepresentation);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.CYLINDRICAL_SURFACE)) {
                        CylindricalSurface cylindricalSurface = CylindricalSurface.getInstance(id, name, att[1]);
                        result.add(cylindricalSurface);
                        System.out.println(cylindricalSurface);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.CIRCLE)) {
                        Circle circle = Circle.getInstance(id, name, att[1]);
                        result.add(circle);
                        System.out.println(circle);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.TOROIDAL_SURFACE)) {
                        ToroidalSurface toroidalSurface = ToroidalSurface.getInstance(id, name, att[1]);
                        result.add(toroidalSurface);
                        System.out.println(toroidalSurface);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.AXIS2_PLACEMENT_2D)) {
                        Axis2Placement2D axis2Placement2D = Axis2Placement2D.getInstance(id, name, att[1]);
                        result.add(axis2Placement2D);
                        System.out.println(axis2Placement2D);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.B_SPLINE_CURVE_WITH_KNOTS)) {
                        BSplineCurveWithKnots bSplineCurveWithKnots
                                = BSplineCurveWithKnots.getInstance(id, name, att[1]);
                        result.add(bSplineCurveWithKnots);
                        System.out.println(bSplineCurveWithKnots);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.SEAM_CURVE)) {
                        SeamCurve seamCurve = SeamCurve.getInstance(id, name, att[1]);
                        result.add(seamCurve);
                        System.out.println(seamCurve);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.ELLIPSE)) {
                        Ellipse ellipse = Ellipse.getInstance(id, name, att[1]);
                        result.add(ellipse);
                        System.out.println(ellipse);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.SURFACE_OF_LINEAR_EXTRUSION)) {
                        SurfaceOfLinearExtrusion surfaceOfLinearExtrusion =
                                SurfaceOfLinearExtrusion.getInstance(id, name, att[1]);
                        result.add(surfaceOfLinearExtrusion);
                        System.out.println(surfaceOfLinearExtrusion);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.CONICAL_SURFACE)) {
                        ConicalSurface conicalSurface = ConicalSurface.getInstance(id, name, att[1]);
                        result.add(conicalSurface);
                        System.out.println(conicalSurface);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.ADVANCED_BREP_SHAPE_REPRESENTATION)) {
                        AdvancedBRepShapeRepresentation advancedBRepShapeRepresentation =
                                AdvancedBRepShapeRepresentation.getInstance(id, name, att[1]);
                        result.add(advancedBRepShapeRepresentation);
                        System.out.println(advancedBRepShapeRepresentation);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.PRODUCT_DEFINITION_CONTEXT + "(")) {
                        ProductDefinitionContext productDefinitionContext =
                                ProductDefinitionContext.getInstance(id, name, att[1]);
                        result.add(productDefinitionContext);
                        System.out.println(productDefinitionContext);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.PRODUCT_CONTEXT)) {
                        ProductContext productContext = ProductContext.getInstance(id, name, att[1]);
                        result.add(productContext);
                        System.out.println(productContext);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.PRODUCT_DEFINITION_SHAPE)) {
                        ProductDefinitionShape productDefinitionShape =
                                ProductDefinitionShape.getInstance(id, name, att[1]);
                        result.add(productDefinitionShape);
                        System.out.println(productDefinitionShape);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.PRODUCT_DEFINITION_FORMATION + "(")) {
                        ProductDefinitionFormation productDefinitionFormation =
                                ProductDefinitionFormation.getInstance(id, name, att[1]);
                        result.add(productDefinitionFormation);
                        System.out.println(productDefinitionFormation);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.PRODUCT_DEFINITION + "(")) {
                        ProductDefinition productDefinition = ProductDefinition.getInstance(id, name, att[1]);
                        result.add(productDefinition);
                        System.out.println(productDefinition);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.PRODUCT_CATEGORY + "(")) {
                        ProductCategory productCategory = ProductCategory.getInstance(id, name, att[1]);
                        result.add(productCategory);
                        System.out.println(productCategory);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.PRODUCT + "(")) {
                        Product product = Product.getInstance(id, name, att[1]);
                        result.add(product);
                        System.out.println(product);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.SHAPE_DEFINITION_REPRESENTATION)) {
                        ShapeDefinitionRepresentation shapeDefinitionRepresentation =
                                ShapeDefinitionRepresentation.getInstance(id, name, att[1]);
                        result.add(shapeDefinitionRepresentation);
                        System.out.println(shapeDefinitionRepresentation);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.APPLICATION_CONTEXT + "(")) {
                        ApplicationContext applicationContext = ApplicationContext.getInstance(id, name.stripLeading());
                        result.add(applicationContext);
                        System.out.println(applicationContext);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.APPLICATION_PROTOCOL_DEFINITION)) {
                        ApplicationProtocolDefinition applicationProtocolDefinition =
                                ApplicationProtocolDefinition.getInstance(id, name, att[1]);
                        result.add(applicationProtocolDefinition);
                        System.out.println(applicationProtocolDefinition);
                        continue;
                    }
                    if (tags[1].stripLeading().startsWith("(")) {
                        System.out.println("*** current  command: " + command);
                        System.out.println("Set of : " + tags[1].stripLeading().stripTrailing().substring(tags[1].indexOf("("), tags[1].lastIndexOf(")") - 1));

                    }

                    System.out.println("!!! not processed: " + command);

                }
            }

        } catch (IOException e) {
            System.out.println("Error in line: " + errorLine);
            e.printStackTrace();
        }
        return result;
    }
}
