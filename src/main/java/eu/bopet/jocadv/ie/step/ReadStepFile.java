package eu.bopet.jocadv.ie.step;

import eu.bopet.jocadv.ie.step.context.Contexts;
import eu.bopet.jocadv.ie.step.context.DesignContext;
import eu.bopet.jocadv.ie.step.context.MechanicalContext;
import eu.bopet.jocadv.ie.step.curve.Curves;
import eu.bopet.jocadv.ie.step.entities.AdvancedBRepShapeRepresentation;
import eu.bopet.jocadv.ie.step.entities.AdvancedFace;
import eu.bopet.jocadv.ie.step.entities.ApplicationContext;
import eu.bopet.jocadv.ie.step.entities.ApplicationProtocolDefinition;
import eu.bopet.jocadv.ie.step.entities.Approval;
import eu.bopet.jocadv.ie.step.entities.ApprovalDateTime;
import eu.bopet.jocadv.ie.step.entities.ApprovalPersonOrganization;
import eu.bopet.jocadv.ie.step.entities.ApprovalRole;
import eu.bopet.jocadv.ie.step.entities.ApprovalStatus;
import eu.bopet.jocadv.ie.step.entities.Axis2Placement2D;
import eu.bopet.jocadv.ie.step.entities.Axis2Placement3D;
import eu.bopet.jocadv.ie.step.entities.BSplineCurveWithKnots;
import eu.bopet.jocadv.ie.step.entities.CCDesignApproval;
import eu.bopet.jocadv.ie.step.entities.CCDesignDateAndTimeAssignment;
import eu.bopet.jocadv.ie.step.entities.CCDesignPersonAndOrganizationAssignment;
import eu.bopet.jocadv.ie.step.entities.CCDesignSecurityClassification;
import eu.bopet.jocadv.ie.step.entities.CalendarDate;
import eu.bopet.jocadv.ie.step.entities.CartesianPoint;
import eu.bopet.jocadv.ie.step.entities.Circle;
import eu.bopet.jocadv.ie.step.entities.ClosedShell;
import eu.bopet.jocadv.ie.step.entities.ColourRGB;
import eu.bopet.jocadv.ie.step.entities.ComplexTriangulatedSurfaceSet;
import eu.bopet.jocadv.ie.step.entities.ConicalSurface;
import eu.bopet.jocadv.ie.step.entities.CoordinatedUniversalTimeOffset;
import eu.bopet.jocadv.ie.step.entities.CoordinatesList;
import eu.bopet.jocadv.ie.step.entities.CurveStyle;
import eu.bopet.jocadv.ie.step.entities.CylindricalSurface;
import eu.bopet.jocadv.ie.step.entities.DateAndTime;
import eu.bopet.jocadv.ie.step.entities.DateTimeRole;
import eu.bopet.jocadv.ie.step.entities.DefinitionalRepresentation;
import eu.bopet.jocadv.ie.step.entities.DimensionalExponents;
import eu.bopet.jocadv.ie.step.entities.Direction;
import eu.bopet.jocadv.ie.step.entities.DraughtingPreDefinedCurveFont;
import eu.bopet.jocadv.ie.step.entities.EdgeCurve;
import eu.bopet.jocadv.ie.step.entities.EdgeLoop;
import eu.bopet.jocadv.ie.step.entities.Ellipse;
import eu.bopet.jocadv.ie.step.entities.FaceBound;
import eu.bopet.jocadv.ie.step.entities.FaceOuterBound;
import eu.bopet.jocadv.ie.step.entities.FillAreaStyle;
import eu.bopet.jocadv.ie.step.entities.FillAreaStyleColour;
import eu.bopet.jocadv.ie.step.entities.GeometricCurveSet;
import eu.bopet.jocadv.ie.step.entities.GeometricallyBoundedWireframeShapeRepresentation;
import eu.bopet.jocadv.ie.step.entities.Invisibility;
import eu.bopet.jocadv.ie.step.entities.Line;
import eu.bopet.jocadv.ie.step.entities.LocalTime;
import eu.bopet.jocadv.ie.step.entities.ManifoldSolidBRep;
import eu.bopet.jocadv.ie.step.entities.MechanicalDesignGeometricPresentationRepresentation;
import eu.bopet.jocadv.ie.step.entities.Organization;
import eu.bopet.jocadv.ie.step.entities.OrientedEdge;
import eu.bopet.jocadv.ie.step.entities.PCurve;
import eu.bopet.jocadv.ie.step.entities.Person;
import eu.bopet.jocadv.ie.step.entities.PersonAndOrganization;
import eu.bopet.jocadv.ie.step.entities.PersonAndOrganizationRole;
import eu.bopet.jocadv.ie.step.entities.Plane;
import eu.bopet.jocadv.ie.step.entities.PointStyle;
import eu.bopet.jocadv.ie.step.entities.PresentationLayerAssignment;
import eu.bopet.jocadv.ie.step.entities.PresentationStyleAssignment;
import eu.bopet.jocadv.ie.step.entities.Product;
import eu.bopet.jocadv.ie.step.entities.ProductCategory;
import eu.bopet.jocadv.ie.step.entities.ProductContext;
import eu.bopet.jocadv.ie.step.entities.ProductDefinition;
import eu.bopet.jocadv.ie.step.entities.ProductDefinitionContext;
import eu.bopet.jocadv.ie.step.entities.ProductDefinitionFormation;
import eu.bopet.jocadv.ie.step.entities.ProductDefinitionFormationWithSpecifiedSource;
import eu.bopet.jocadv.ie.step.entities.ProductDefinitionShape;
import eu.bopet.jocadv.ie.step.entities.ProductRelatedProductCategory;
import eu.bopet.jocadv.ie.step.entities.SeamCurve;
import eu.bopet.jocadv.ie.step.entities.SecurityClassification;
import eu.bopet.jocadv.ie.step.entities.SecurityClassificationLevel;
import eu.bopet.jocadv.ie.step.entities.ShapeDefinitionRepresentation;
import eu.bopet.jocadv.ie.step.entities.ShapeRepresentationRelationship;
import eu.bopet.jocadv.ie.step.entities.StyledItem;
import eu.bopet.jocadv.ie.step.entities.SurfaceCurve;
import eu.bopet.jocadv.ie.step.entities.SurfaceOfLinearExtrusion;
import eu.bopet.jocadv.ie.step.entities.SurfaceSideStyle;
import eu.bopet.jocadv.ie.step.entities.SurfaceStyleFillArea;
import eu.bopet.jocadv.ie.step.entities.SurfaceStyleUsage;
import eu.bopet.jocadv.ie.step.entities.ToroidalSurface;
import eu.bopet.jocadv.ie.step.entities.TrimmedCurve;
import eu.bopet.jocadv.ie.step.entities.Vector;
import eu.bopet.jocadv.ie.step.entities.VertexLoop;
import eu.bopet.jocadv.ie.step.entities.VertexPoint;
import eu.bopet.jocadv.ie.step.measure.LengthMeasureWithUnit;
import eu.bopet.jocadv.ie.step.measure.PlaneAngleMeasureWithUnit;
import eu.bopet.jocadv.ie.step.measure.UncertaintyMeasureWithUnit;
import eu.bopet.jocadv.ie.step.representation.ShapeRepresentation;
import eu.bopet.jocadv.ie.step.surface.BSplineSurfaceWithKnots;
import eu.bopet.jocadv.ie.step.surface.SphericalSurface;
import eu.bopet.jocadv.ie.step.surface.Surfaces;
import eu.bopet.jocadv.ie.step.unit.Units;
import eu.bopet.jocadv.ie.step.util.StepCode;
import eu.bopet.jocadv.ie.step.util.StepEntityBase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
                                new BSplineSurfaceWithKnots(id, name, false, att[1].replace(" ", ""));
                        result.add(bSplineSurfaceWithKnots);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.UNCERTAINTY_MEASURE_WITH_UNIT)) {
                        UncertaintyMeasureWithUnit uncertaintyMeasureWithUnit =
                                new UncertaintyMeasureWithUnit(id, name, attributes);
                        result.add(uncertaintyMeasureWithUnit);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.PRODUCT_RELATED_PRODUCT_CATEGORY)) {
                        ProductRelatedProductCategory productRelatedProductCategory = new ProductRelatedProductCategory(id, name, attributes);
                        result.add(productRelatedProductCategory);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.MECHANICAL_DESIGN_GEOMETRIC_PRESENTATION_REPRESENTATION)) {
                        MechanicalDesignGeometricPresentationRepresentation mechanicalDesignGeometricPresentationRepresentation =
                                new MechanicalDesignGeometricPresentationRepresentation(id, name, att[1].replace(" ", ""));
                        result.add(mechanicalDesignGeometricPresentationRepresentation);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.STYLED_ITEM)) {
                        StyledItem item = new StyledItem(id, name, att[1].replace(" ", ""));
                        result.add(item);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.PRESENTATION_STYLE_ASSIGNMENT)) {
                        PresentationStyleAssignment presentationStyleAssignment =
                                new PresentationStyleAssignment(id, "", attributes);
                        result.add(presentationStyleAssignment);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.SURFACE_STYLE_USAGE)) {
                        SurfaceStyleUsage surfaceStyleUsage = new SurfaceStyleUsage(id, "", attributes);
                        result.add(surfaceStyleUsage);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.SURFACE_SIDE_STYLE)) {
                        SurfaceSideStyle surfaceSideStyle = new SurfaceSideStyle(id, name, att[1].replace(" ", ""));
                        result.add(surfaceSideStyle);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.SURFACE_STYLE_FILL_AREA)) {
                        SurfaceStyleFillArea surfaceStyleFillArea =
                                new SurfaceStyleFillArea(id, "", attributes.replace(" ", ""));
                        result.add(surfaceStyleFillArea);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.FILL_AREA_STYLE_COLOUR)) {
                        FillAreaStyleColour fillAreaStyleColour = new FillAreaStyleColour(id, name, att[1]);
                        result.add(fillAreaStyleColour);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.FILL_AREA_STYLE)) {
                        FillAreaStyle fillAreaStyle = new FillAreaStyle(id, name, att[1].replace(" ", ""));
                        result.add(fillAreaStyle);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.COLOUR_RGB)) {
                        ColourRGB colourRGB = new ColourRGB(id, name, att[1]);
                        result.add(colourRGB);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.SHAPE_REPRESENTATION_RELATIONSHIP)) {
                        ShapeRepresentationRelationship shapeRepresentationRelationship =
                                new ShapeRepresentationRelationship(id, name, att[1]);
                        result.add(shapeRepresentationRelationship);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.DESIGN_CONTEXT)) {
                        DesignContext designContext = new DesignContext(id, name, att[1]);
                        result.add(designContext);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.PRODUCT_DEFINITION_FORMATION_WITH_SPECIFIED_SOURCE)) {
                        ProductDefinitionFormationWithSpecifiedSource productDefinitionFormationWithSpecifiedSource =
                                new ProductDefinitionFormationWithSpecifiedSource(id, name, att[1]);
                        result.add(productDefinitionFormationWithSpecifiedSource);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.MECHANICAL_CONTEXT)) {
                        MechanicalContext mechanicalContext = new MechanicalContext(id, name, att[1]);
                        result.add(mechanicalContext);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.SHAPE_REPRESENTATION)) {
                        ShapeRepresentation shapeRepresentation = new ShapeRepresentation(id, name, att[1]);
                        result.add(shapeRepresentation);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.GEOMETRIC_CURVE_SET)) {
                        GeometricCurveSet geometricCurveSet = new GeometricCurveSet(id, name, att[1]);
                        result.add(geometricCurveSet);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.VERTEX_LOOP)) {
                        VertexLoop vertexLoop = new VertexLoop(id, name, att[1]);
                        result.add(vertexLoop);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.SPHERICAL_SURFACE)) {
                        SphericalSurface sphericalSurface = new SphericalSurface(id, name, att[1]);
                        result.add(sphericalSurface);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.FACE_OUTER_BOUND)) {
                        FaceOuterBound faceOuterBound = new FaceOuterBound(id, name, att[1]);
                        result.add(faceOuterBound);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.CURVE_STYLE)) {
                        CurveStyle curveStyle = new CurveStyle(id, name, att[1]);
                        result.add(curveStyle);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.DRAUGHTING_PRE_DEFINED_CURVE_FONT)) {
                        DraughtingPreDefinedCurveFont draughtingPreDefinedCurveFont =
                                new DraughtingPreDefinedCurveFont(id, name);
                        result.add(draughtingPreDefinedCurveFont);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.TRIMMED_CURVE)) {
                        TrimmedCurve trimmedCurve = new TrimmedCurve(id, name, att[1]);
                        result.add(trimmedCurve);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.INVISIBILITY)) {
                        Invisibility invisibility = new Invisibility(id, "", attributes);
                        result.add(invisibility);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.PRESENTATION_LAYER_ASSIGNMENT)) {
                        PresentationLayerAssignment presentationLayerAssignment = new PresentationLayerAssignment(id, name, att[1]);
                        result.add(presentationLayerAssignment);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.POINT_STYLE)) {
                        PointStyle pointStyle = new PointStyle(id, name, att[1]);
                        result.add(pointStyle);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.PLANE_ANGLE_MEASURE_WITH_UNIT)) {
                        PlaneAngleMeasureWithUnit planeAngleMeasureWithUnit = new PlaneAngleMeasureWithUnit(id, "", attributes);
                        result.add(planeAngleMeasureWithUnit);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.DIMENSIONAL_EXPONENTS)) {
                        DimensionalExponents dimensionalExponents = new DimensionalExponents(id, "", attributes);
                        result.add(dimensionalExponents);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.LENGTH_MEASURE_WITH_UNIT)) {
                        LengthMeasureWithUnit lengthMeasureWithUnit = new LengthMeasureWithUnit(id, "", attributes);
                        result.add(lengthMeasureWithUnit);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.CC_DESIGN_APPROVAL)) {
                        CCDesignApproval ccDesignApproval = new CCDesignApproval(id, "", attributes);
                        result.add(ccDesignApproval);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.APPROVAL_PERSON_ORGANIZATION)) {
                        ApprovalPersonOrganization approvalPersonOrganization =
                                new ApprovalPersonOrganization(id, "", attributes);
                        result.add(approvalPersonOrganization);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.APPROVAL_ROLE)) {
                        ApprovalRole approvalRole = new ApprovalRole(id, name);
                        result.add(approvalRole);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.APPROVAL_DATE_TIME)) {
                        ApprovalDateTime approvalDateTime = new ApprovalDateTime(id, "", attributes);
                        result.add(approvalDateTime);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.APPROVAL_STATUS)) {
                        ApprovalStatus approvalStatus = new ApprovalStatus(id, attributes.replace("'", ""));
                        result.add(approvalStatus);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.APPROVAL)) {
                        Approval approval = new Approval(id, "", attributes);
                        result.add(approval);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.CC_DESIGN_SECURITY_CLASSIFICATION)) {
                        CCDesignSecurityClassification ccDesignSecurityClassification =
                                new CCDesignSecurityClassification(id, "", attributes);
                        result.add(ccDesignSecurityClassification);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.SECURITY_CLASSIFICATION_LEVEL)) {
                        SecurityClassificationLevel securityClassificationLevel =
                                new SecurityClassificationLevel(id, attributes.replace("'", ""));
                        result.add(securityClassificationLevel);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.SECURITY_CLASSIFICATION)) {
                        SecurityClassification securityClassification = new SecurityClassification(id, name, att[1]);
                        result.add(securityClassification);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.CC_DESIGN_DATE_AND_TIME_ASSIGNMENT)) {
                        CCDesignDateAndTimeAssignment ccDesignDateAndTimeAssignment =
                                new CCDesignDateAndTimeAssignment(id, "", attributes);
                        result.add(ccDesignDateAndTimeAssignment);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.DATE_TIME_ROLE)) {
                        DateTimeRole dateTimeRole = new DateTimeRole(id, name);
                        result.add(dateTimeRole);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.DATE_AND_TIME)) {
                        DateAndTime dateAndTime = new DateAndTime(id, "", attributes);
                        result.add(dateAndTime);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.LOCAL_TIME)) {
                        LocalTime localTime = new LocalTime(id, "", attributes);
                        result.add(localTime);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.COORDINATED_UNIVERSAL_TIME_OFFSET)) {
                        CoordinatedUniversalTimeOffset coordinatedUniversalTimeOffset =
                                new CoordinatedUniversalTimeOffset(id, "", attributes);
                        result.add(coordinatedUniversalTimeOffset);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.CALENDAR_DATE)) {
                        CalendarDate calendarDate = new CalendarDate(id, "", attributes);
                        result.add(calendarDate);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.CC_DESIGN_PERSON_AND_ORGANIZATION_ASSIGNMENT)) {
                        CCDesignPersonAndOrganizationAssignment ccDesignPersonAndOrganizationAssignment =
                                new CCDesignPersonAndOrganizationAssignment(id, "", attributes);
                        result.add(ccDesignPersonAndOrganizationAssignment);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.PERSON_AND_ORGANIZATION_ROLE)) {
                        PersonAndOrganizationRole personAndOrganizationRole =
                                new PersonAndOrganizationRole(id, name);
                        result.add(personAndOrganizationRole);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.PERSON_AND_ORGANIZATION)) {
                        PersonAndOrganization personAndOrganization =
                                new PersonAndOrganization(id, "", attributes);
                        result.add(personAndOrganization);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.ORGANIZATION)) {
                        Organization organization = new Organization(id, name, att[1]);
                        result.add(organization);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.PERSON)) {
                        Person person = new Person(id, name, att[1]);
                        result.add(person);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.COORDINATES_LIST)) {
                        CoordinatesList coordinatesList = new CoordinatesList(id, name, att[1]);
                        result.add(coordinatesList);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.COMPLEX_TRIANGULATED_SURFACE_SET)) {
                        System.out.println("c: " + command);
                        ComplexTriangulatedSurfaceSet complexTriangulatedSurfaceSet =
                                new ComplexTriangulatedSurfaceSet(id, name, att[1]);
                        System.out.println(complexTriangulatedSurfaceSet);
                        result.add(complexTriangulatedSurfaceSet);
                        continue;
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
                            Units units = new Units(id, name, set.replace(" ", ""));
                            result.add(units);
                            continue;
                        }
                        if (Arrays.asList(StepCode.SURFACES).contains(firstSet)) {
                            Surfaces surfaces = new Surfaces(id, "", set.replace(" ", ""));
                            result.add(surfaces);
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

        } catch (Exception e) {
            System.out.println("Error in line: " + errorLine);
            e.printStackTrace();
        }
        int entitiesCount = result.size();
        int checkedEntities = result.get(result.size() - 1).getId() - result.get(0).getId() + 1;
        System.out.println("Entities processed: " + entitiesCount);
        System.out.println("Id check: " + checkedEntities);
        return result;
    }
}
