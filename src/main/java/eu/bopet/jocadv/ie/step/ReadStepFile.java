package eu.bopet.jocadv.ie.step;

import eu.bopet.jocadv.ie.step.context.Contexts;
import eu.bopet.jocadv.ie.step.curve.Curves;
import eu.bopet.jocadv.ie.step.entities.AdvancedBRepShapeRepresentation;
import eu.bopet.jocadv.ie.step.entities.AdvancedFace;
import eu.bopet.jocadv.ie.step.entities.ApplicationContext;
import eu.bopet.jocadv.ie.step.entities.ApplicationProtocolDefinition;
import eu.bopet.jocadv.ie.step.entities.Axis2Placement2D;
import eu.bopet.jocadv.ie.step.entities.Axis2Placement3D;
import eu.bopet.jocadv.ie.step.entities.BSplineCurveWithKnots;
import eu.bopet.jocadv.ie.step.entities.CartesianPoint;
import eu.bopet.jocadv.ie.step.entities.Circle;
import eu.bopet.jocadv.ie.step.entities.ClosedShell;
import eu.bopet.jocadv.ie.step.entities.ConicalSurface;
import eu.bopet.jocadv.ie.step.entities.CylindricalSurface;
import eu.bopet.jocadv.ie.step.entities.DefinitionalRepresentation;
import eu.bopet.jocadv.ie.step.entities.Direction;
import eu.bopet.jocadv.ie.step.entities.EdgeCurve;
import eu.bopet.jocadv.ie.step.entities.EdgeLoop;
import eu.bopet.jocadv.ie.step.entities.Ellipse;
import eu.bopet.jocadv.ie.step.entities.FaceBound;
import eu.bopet.jocadv.ie.step.entities.GeometricallyBoundedWireframeShapeRepresentation;
import eu.bopet.jocadv.ie.step.entities.Line;
import eu.bopet.jocadv.ie.step.entities.ManifoldSolidBRep;
import eu.bopet.jocadv.ie.step.entities.OrientedEdge;
import eu.bopet.jocadv.ie.step.entities.PCurve;
import eu.bopet.jocadv.ie.step.entities.Plane;
import eu.bopet.jocadv.ie.step.entities.Product;
import eu.bopet.jocadv.ie.step.entities.ProductCategory;
import eu.bopet.jocadv.ie.step.entities.ProductContext;
import eu.bopet.jocadv.ie.step.entities.ProductDefinition;
import eu.bopet.jocadv.ie.step.entities.ProductDefinitionContext;
import eu.bopet.jocadv.ie.step.entities.ProductDefinitionFormation;
import eu.bopet.jocadv.ie.step.entities.ProductDefinitionShape;
import eu.bopet.jocadv.ie.step.entities.SeamCurve;
import eu.bopet.jocadv.ie.step.entities.ShapeDefinitionRepresentation;
import eu.bopet.jocadv.ie.step.entities.SurfaceCurve;
import eu.bopet.jocadv.ie.step.entities.SurfaceOfLinearExtrusion;
import eu.bopet.jocadv.ie.step.entities.ToroidalSurface;
import eu.bopet.jocadv.ie.step.entities.Vector;
import eu.bopet.jocadv.ie.step.entities.VertexPoint;
import eu.bopet.jocadv.ie.step.surface.BSplineSurfaceWithKnots;
import eu.bopet.jocadv.ie.step.util.StepCode;
import eu.bopet.jocadv.ie.step.util.StepEntityBase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadStepFile {

    public static List<StepEntityBase> readStepFile(File file) {
        List<StepEntityBase> result = new ArrayList<>();
        System.out.println("Starting with file: " + file.getName());
        String errorLine = "";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String line; (line = br.readLine()) != null; ) {
                stringBuilder.append(line);
            }
            String[] commands = stringBuilder.toString().split(";");
            if (Arrays.asList(commands).isEmpty()) {
                System.out.println("Empty file!");
                return result;
            } else if (commands[0].startsWith("ISO-10303-21")) {
                System.out.println("ISO-10303-21 step file found.");
            } else {
                System.out.println("Not ISO-10303-21 step file!");
                return result;
            }
            for (String command : commands) {
                errorLine = command;
                if (command.startsWith("#")) {
                    String[] tags = command.split("=");
                    int id = Integer.parseInt(tags[0].substring(1).replace(" ", ""));
                    String secondTag = tags[1].stripLeading();
                    String attributes = secondTag.substring(secondTag.indexOf("(") + 1, secondTag.lastIndexOf(")"));
                    String[] att = attributes.split(",", 2);
                    String name = att[0].replace("'", "");
                    if (secondTag.startsWith(StepCode.CARTESIAN_POINT)) {
                        CartesianPoint point = new CartesianPoint(id, name, att[1]);
                        result.add(point);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.DIRECTION + "(")) {
                        Direction direction = new Direction(id, name, att[1]);
                        result.add(direction);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.VECTOR + "(")) {
                        Vector vector = new Vector(id, name, att[1]);
                        result.add(vector);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.LINE + "(")) {
                        Line line = new Line(id, name, att[1]);
                        result.add(line);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.VERTEX_POINT)) {
                        VertexPoint vertexPoint = new VertexPoint(id, name, att[1]);
                        result.add(vertexPoint);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.EDGE_CURVE)) {
                        EdgeCurve edgeCurve = new EdgeCurve(id, name, att[1]);
                        result.add(edgeCurve);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.PCURVE)) {
                        PCurve pCurve = new PCurve(id, name, att[1]);
                        result.add(pCurve);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.AXIS2_PLACEMENT_3D)) {
                        Axis2Placement3D axis2Placement3D = new Axis2Placement3D(id, name, att[1]);
                        result.add(axis2Placement3D);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.PLANE + "(")) {
                        Plane plane = new Plane(id, name, att[1]);
                        result.add(plane);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.ORIENTED_EDGE)) {
                        OrientedEdge orientedEdge = new OrientedEdge(id, name, att[1]);
                        result.add(orientedEdge);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.SURFACE_CURVE + "(")) {
                        SurfaceCurve surfaceCurve = new SurfaceCurve(id, name, att[1]);
                        result.add(surfaceCurve);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.EDGE_LOOP)) {
                        EdgeLoop edgeLoop = new EdgeLoop(id, name, att[1]);
                        result.add(edgeLoop);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.FACE_BOUND)) {
                        FaceBound faceBound = new FaceBound(id, name, att[1]);
                        result.add(faceBound);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.ADVANCED_FACE)) {
                        AdvancedFace advancedFace = new AdvancedFace(id, name, att[1]);
                        result.add(advancedFace);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.CLOSED_SHELL)) {
                        ClosedShell closedShell = new ClosedShell(id, name, att[1]);
                        result.add(closedShell);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.MANIFOLD_SOLID_BREP)) {
                        ManifoldSolidBRep manifoldSolidBRep = new ManifoldSolidBRep(id, name, att[1]);
                        result.add(manifoldSolidBRep);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.DEFINITIONAL_REPRESENTATION + "(")) {
                        DefinitionalRepresentation definitionalRepresentation
                                = new DefinitionalRepresentation(id, name, att[1]);
                        result.add(definitionalRepresentation);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.CYLINDRICAL_SURFACE)) {
                        CylindricalSurface cylindricalSurface = new CylindricalSurface(id, name, att[1]);
                        result.add(cylindricalSurface);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.CIRCLE)) {
                        Circle circle = new Circle(id, name, att[1]);
                        result.add(circle);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.TOROIDAL_SURFACE)) {
                        ToroidalSurface toroidalSurface = new ToroidalSurface(id, name, att[1]);
                        result.add(toroidalSurface);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.AXIS2_PLACEMENT_2D)) {
                        Axis2Placement2D axis2Placement2D = new Axis2Placement2D(id, name, att[1]);
                        result.add(axis2Placement2D);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.B_SPLINE_CURVE_WITH_KNOTS)) {
                        BSplineCurveWithKnots bSplineCurveWithKnots
                                = new BSplineCurveWithKnots(id, name, att[1]);
                        result.add(bSplineCurveWithKnots);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.SEAM_CURVE)) {
                        SeamCurve seamCurve = new SeamCurve(id, name, att[1]);
                        result.add(seamCurve);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.ELLIPSE)) {
                        Ellipse ellipse = new Ellipse(id, name, att[1]);
                        result.add(ellipse);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.SURFACE_OF_LINEAR_EXTRUSION)) {
                        SurfaceOfLinearExtrusion surfaceOfLinearExtrusion =
                                new SurfaceOfLinearExtrusion(id, name, att[1]);
                        result.add(surfaceOfLinearExtrusion);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.CONICAL_SURFACE)) {
                        ConicalSurface conicalSurface = new ConicalSurface(id, name, att[1]);
                        result.add(conicalSurface);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.ADVANCED_BREP_SHAPE_REPRESENTATION)) {
                        AdvancedBRepShapeRepresentation advancedBRepShapeRepresentation =
                                new AdvancedBRepShapeRepresentation(id, name, att[1]);
                        result.add(advancedBRepShapeRepresentation);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.PRODUCT_DEFINITION_CONTEXT + "(")) {
                        ProductDefinitionContext productDefinitionContext =
                                new ProductDefinitionContext(id, name, att[1]);
                        result.add(productDefinitionContext);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.PRODUCT_CONTEXT)) {
                        ProductContext productContext = new ProductContext(id, name, att[1]);
                        result.add(productContext);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.PRODUCT_DEFINITION_SHAPE)) {
                        ProductDefinitionShape productDefinitionShape =
                                new ProductDefinitionShape(id, name, att[1]);
                        result.add(productDefinitionShape);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.PRODUCT_DEFINITION_FORMATION + "(")) {
                        ProductDefinitionFormation productDefinitionFormation =
                                new ProductDefinitionFormation(id, name, att[1]);
                        result.add(productDefinitionFormation);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.PRODUCT_DEFINITION + "(")) {
                        ProductDefinition productDefinition = new ProductDefinition(id, name, att[1]);
                        result.add(productDefinition);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.PRODUCT_CATEGORY + "(")) {
                        ProductCategory productCategory = new ProductCategory(id, name, att[1]);
                        result.add(productCategory);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.PRODUCT + "(")) {
                        Product product = new Product(id, name, att[1]);
                        result.add(product);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.SHAPE_DEFINITION_REPRESENTATION)) {
                        ShapeDefinitionRepresentation shapeDefinitionRepresentation =
                                new ShapeDefinitionRepresentation(id, "", attributes);
                        result.add(shapeDefinitionRepresentation);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.APPLICATION_CONTEXT + "(")) {
                        ApplicationContext applicationContext = new ApplicationContext(id, name.stripLeading());
                        result.add(applicationContext);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.APPLICATION_PROTOCOL_DEFINITION)) {
                        ApplicationProtocolDefinition applicationProtocolDefinition =
                                new ApplicationProtocolDefinition(id, name, att[1]);
                        result.add(applicationProtocolDefinition);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.GEOMETRICALLY_BOUNDED_WIREFRAME_SHAPE_REPRESENTATION)) {
                        GeometricallyBoundedWireframeShapeRepresentation representation =
                                new GeometricallyBoundedWireframeShapeRepresentation(id, name, att[1]);
                        result.add(representation);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.B_SPLINE_SURFACE_WITH_KNOTS)) {
                        BSplineSurfaceWithKnots bSplineSurfaceWithKnots =
                                new BSplineSurfaceWithKnots(id, name, att[1].replace(" ", ""));
                        result.add(bSplineSurfaceWithKnots);
                        continue;
                    }

                    if (secondTag.startsWith(StepCode.UNCERTAINTY_MEASURE_WITH_UNIT)) {
                        System.out.println("Haho : " + secondTag);
                    }


                    if (tags[1].stripLeading().startsWith("(")) {
                        String set = tags[1].substring(tags[1].indexOf("(") + 1, tags[1].lastIndexOf(")"));
                        String firstSet = set.substring(0, set.indexOf("(")).stripLeading().stripTrailing();
                        if (Arrays.asList(StepCode.CONTEXTS).contains(firstSet)) {
                            Contexts contexts = new Contexts(id, "", set.replace(" ", ""));
                            result.add(contexts);
                            continue;
                        }
                        if (Arrays.asList(StepCode.CURVES).contains(firstSet)) {
                            Curves curves = new Curves(id, "", set.replace(" ", ""));
                            result.add(curves);
                            continue;
                        }
                        if (Arrays.asList(StepCode.UNITS).contains(firstSet)) {
                            System.out.println("*Units!");
                            continue;
                        }
                        if (Arrays.asList(StepCode.SURFACES).contains(firstSet)) {
                            System.out.println("*Surfaces!\n" + command);
                            continue;
                        }
                        System.out.println("???Set of : " + set);
                    }

                    System.out.println("---> Not processed: " + command);
                    String code = secondTag.substring(0, secondTag.indexOf("("));
                    System.out.println("- Code: " + code);
                    if (Arrays.asList(StepCode.ALL).contains(code)) {
                        System.out.println("- Code have found!");
                    } else {
                        System.out.println(" !!! Code not found!");
                    }

                }
            }

        } catch (IOException e) {
            System.out.println("Error in line: " + errorLine);
            e.printStackTrace();
        }
        return result;
    }
}
