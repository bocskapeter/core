package eu.bopet.jocadv.ie.step;

import eu.bopet.jocadv.ie.step.characterizedObject.CharacterizedObjects;
import eu.bopet.jocadv.ie.step.context.Contexts;
import eu.bopet.jocadv.ie.step.context.DesignContext;
import eu.bopet.jocadv.ie.step.context.MechanicalContext;
import eu.bopet.jocadv.ie.step.curve.Curves;
import eu.bopet.jocadv.ie.step.curve.TessellatedCurveSet;
import eu.bopet.jocadv.ie.step.entities.AdvancedBRepShapeRepresentation;
import eu.bopet.jocadv.ie.step.entities.AdvancedFace;
import eu.bopet.jocadv.ie.step.entities.AllAroundShapeAspect;
import eu.bopet.jocadv.ie.step.entities.AngularLocation;
import eu.bopet.jocadv.ie.step.entities.AngularSize;
import eu.bopet.jocadv.ie.step.entities.AnnotationCurveOccurrence;
import eu.bopet.jocadv.ie.step.entities.AnnotationOccurrence;
import eu.bopet.jocadv.ie.step.entities.AnnotationPlaceholderOccurrence;
import eu.bopet.jocadv.ie.step.entities.AnnotationPlane;
import eu.bopet.jocadv.ie.step.entities.ApplicationContext;
import eu.bopet.jocadv.ie.step.entities.ApplicationProtocolDefinition;
import eu.bopet.jocadv.ie.step.entities.AppliedDocumentReference;
import eu.bopet.jocadv.ie.step.entities.Approval;
import eu.bopet.jocadv.ie.step.entities.ApprovalDateTime;
import eu.bopet.jocadv.ie.step.entities.ApprovalPersonOrganization;
import eu.bopet.jocadv.ie.step.entities.ApprovalRole;
import eu.bopet.jocadv.ie.step.entities.ApprovalStatus;
import eu.bopet.jocadv.ie.step.entities.AreaUnit;
import eu.bopet.jocadv.ie.step.entities.Axis2Placement2D;
import eu.bopet.jocadv.ie.step.entities.Axis2Placement3D;
import eu.bopet.jocadv.ie.step.entities.BSplineCurveWithKnots;
import eu.bopet.jocadv.ie.step.entities.CCDesignApproval;
import eu.bopet.jocadv.ie.step.entities.CCDesignDateAndTimeAssignment;
import eu.bopet.jocadv.ie.step.entities.CCDesignPersonAndOrganizationAssignment;
import eu.bopet.jocadv.ie.step.entities.CCDesignSecurityClassification;
import eu.bopet.jocadv.ie.step.entities.CalendarDate;
import eu.bopet.jocadv.ie.step.entities.CameraModelD3;
import eu.bopet.jocadv.ie.step.entities.CartesianPoint;
import eu.bopet.jocadv.ie.step.entities.CharacterizedItemWithinRepresentation;
import eu.bopet.jocadv.ie.step.entities.Circle;
import eu.bopet.jocadv.ie.step.entities.CircularRunOutTolerance;
import eu.bopet.jocadv.ie.step.entities.ClosedShell;
import eu.bopet.jocadv.ie.step.entities.Colour;
import eu.bopet.jocadv.ie.step.entities.ColourRGB;
import eu.bopet.jocadv.ie.step.entities.ComplexTriangulatedFace;
import eu.bopet.jocadv.ie.step.entities.ComplexTriangulatedSurfaceSet;
import eu.bopet.jocadv.ie.step.entities.CompositeCurve;
import eu.bopet.jocadv.ie.step.entities.CompositeCurveSegment;
import eu.bopet.jocadv.ie.step.entities.CompositeGroupShapeAspect;
import eu.bopet.jocadv.ie.step.entities.CompositeShapeAspect;
import eu.bopet.jocadv.ie.step.entities.CompoundRepresentationItem;
import eu.bopet.jocadv.ie.step.entities.ConicalSurface;
import eu.bopet.jocadv.ie.step.entities.ConstructiveGeometryRepresentationRelationship;
import eu.bopet.jocadv.ie.step.entities.CoordinatedUniversalTimeOffset;
import eu.bopet.jocadv.ie.step.entities.CoordinatesList;
import eu.bopet.jocadv.ie.step.entities.CurveStyle;
import eu.bopet.jocadv.ie.step.entities.CylindricalSurface;
import eu.bopet.jocadv.ie.step.entities.DateAndTime;
import eu.bopet.jocadv.ie.step.entities.DateTimeRole;
import eu.bopet.jocadv.ie.step.entities.Datum;
import eu.bopet.jocadv.ie.step.entities.DatumFeature;
import eu.bopet.jocadv.ie.step.entities.DatumReferenceCompartment;
import eu.bopet.jocadv.ie.step.entities.DatumReferenceElement;
import eu.bopet.jocadv.ie.step.entities.DatumSystem;
import eu.bopet.jocadv.ie.step.entities.DefaultModelGeometricView;
import eu.bopet.jocadv.ie.step.entities.DefinitionalRepresentation;
import eu.bopet.jocadv.ie.step.entities.DerivedUnit;
import eu.bopet.jocadv.ie.step.entities.DerivedUnitElement;
import eu.bopet.jocadv.ie.step.entities.DescriptiveRepresentationItem;
import eu.bopet.jocadv.ie.step.entities.DimensionalExponents;
import eu.bopet.jocadv.ie.step.entities.DimensionalLocation;
import eu.bopet.jocadv.ie.step.entities.DimensionalSize;
import eu.bopet.jocadv.ie.step.entities.Direction;
import eu.bopet.jocadv.ie.step.entities.Document;
import eu.bopet.jocadv.ie.step.entities.DocumentProductEquivalence;
import eu.bopet.jocadv.ie.step.entities.DocumentType;
import eu.bopet.jocadv.ie.step.entities.DraughtingCallOut;
import eu.bopet.jocadv.ie.step.entities.DraughtingCallOutRelationship;
import eu.bopet.jocadv.ie.step.entities.DraughtingModel;
import eu.bopet.jocadv.ie.step.entities.DraughtingModelItemAssociation;
import eu.bopet.jocadv.ie.step.entities.DraughtingPreDefinedColour;
import eu.bopet.jocadv.ie.step.entities.DraughtingPreDefinedCurveFont;
import eu.bopet.jocadv.ie.step.entities.EdgeCurve;
import eu.bopet.jocadv.ie.step.entities.EdgeLoop;
import eu.bopet.jocadv.ie.step.entities.Ellipse;
import eu.bopet.jocadv.ie.step.entities.FaceBound;
import eu.bopet.jocadv.ie.step.entities.FaceOuterBound;
import eu.bopet.jocadv.ie.step.entities.FeatureForDatumTargetRelationship;
import eu.bopet.jocadv.ie.step.entities.FillAreaStyle;
import eu.bopet.jocadv.ie.step.entities.FillAreaStyleColour;
import eu.bopet.jocadv.ie.step.entities.FlatnessTolerance;
import eu.bopet.jocadv.ie.step.entities.GeneralProperty;
import eu.bopet.jocadv.ie.step.entities.GeneralPropertyAssociation;
import eu.bopet.jocadv.ie.step.entities.GeometricCurveSet;
import eu.bopet.jocadv.ie.step.entities.GeometricItemSpecificUsage;
import eu.bopet.jocadv.ie.step.entities.GeometricSet;
import eu.bopet.jocadv.ie.step.entities.GeometricToleranceRelationship;
import eu.bopet.jocadv.ie.step.entities.GeometricallyBoundedSurfaceShapeRepresentation;
import eu.bopet.jocadv.ie.step.entities.GeometricallyBoundedWireframeShapeRepresentation;
import eu.bopet.jocadv.ie.step.entities.IdAttribute;
import eu.bopet.jocadv.ie.step.entities.IntegerRepresentationItem;
import eu.bopet.jocadv.ie.step.entities.Invisibility;
import eu.bopet.jocadv.ie.step.entities.ItemIdentifiedRepresentationUsage;
import eu.bopet.jocadv.ie.step.entities.Line;
import eu.bopet.jocadv.ie.step.entities.LocalTime;
import eu.bopet.jocadv.ie.step.entities.ManifoldSolidBRep;
import eu.bopet.jocadv.ie.step.entities.ManifoldSurfaceShapeRepresentation;
import eu.bopet.jocadv.ie.step.entities.MappedItem;
import eu.bopet.jocadv.ie.step.entities.MeasureQualification;
import eu.bopet.jocadv.ie.step.entities.MeasureRepresentationItem;
import eu.bopet.jocadv.ie.step.entities.MechanicalDesignAndDraughtingRelationship;
import eu.bopet.jocadv.ie.step.entities.MechanicalDesignGeometricPresentationRepresentation;
import eu.bopet.jocadv.ie.step.entities.ModelGeometricView;
import eu.bopet.jocadv.ie.step.entities.NameAttribute;
import eu.bopet.jocadv.ie.step.entities.ObjectRole;
import eu.bopet.jocadv.ie.step.entities.OpenShell;
import eu.bopet.jocadv.ie.step.entities.Organization;
import eu.bopet.jocadv.ie.step.entities.OrientedEdge;
import eu.bopet.jocadv.ie.step.entities.OverRidingStyledItem;
import eu.bopet.jocadv.ie.step.entities.PCurve;
import eu.bopet.jocadv.ie.step.entities.ParallelismTolerance;
import eu.bopet.jocadv.ie.step.entities.PerpendicularityTolerance;
import eu.bopet.jocadv.ie.step.entities.Person;
import eu.bopet.jocadv.ie.step.entities.PersonAndOrganization;
import eu.bopet.jocadv.ie.step.entities.PersonAndOrganizationRole;
import eu.bopet.jocadv.ie.step.entities.PlacedDatumTargetFeature;
import eu.bopet.jocadv.ie.step.entities.PlanarBox;
import eu.bopet.jocadv.ie.step.entities.Plane;
import eu.bopet.jocadv.ie.step.entities.PlusMinusTolerance;
import eu.bopet.jocadv.ie.step.entities.PointStyle;
import eu.bopet.jocadv.ie.step.entities.Polyline;
import eu.bopet.jocadv.ie.step.entities.PreDefinedMarker;
import eu.bopet.jocadv.ie.step.entities.PreDefinedPointMarkerSymbol;
import eu.bopet.jocadv.ie.step.entities.PresentationLayerAssignment;
import eu.bopet.jocadv.ie.step.entities.PresentationStyleAssignment;
import eu.bopet.jocadv.ie.step.entities.Product;
import eu.bopet.jocadv.ie.step.entities.ProductCategory;
import eu.bopet.jocadv.ie.step.entities.ProductCategoryRelationship;
import eu.bopet.jocadv.ie.step.entities.ProductContext;
import eu.bopet.jocadv.ie.step.entities.ProductDefinition;
import eu.bopet.jocadv.ie.step.entities.ProductDefinitionContext;
import eu.bopet.jocadv.ie.step.entities.ProductDefinitionContextAssociation;
import eu.bopet.jocadv.ie.step.entities.ProductDefinitionContextRole;
import eu.bopet.jocadv.ie.step.entities.ProductDefinitionFormation;
import eu.bopet.jocadv.ie.step.entities.ProductDefinitionFormationWithSpecifiedSource;
import eu.bopet.jocadv.ie.step.entities.ProductDefinitionShape;
import eu.bopet.jocadv.ie.step.entities.ProductRelatedProductCategory;
import eu.bopet.jocadv.ie.step.entities.ProjectedZoneDefinition;
import eu.bopet.jocadv.ie.step.entities.PropertyDefinition;
import eu.bopet.jocadv.ie.step.entities.PropertyDefinitionRepresentation;
import eu.bopet.jocadv.ie.step.entities.RealRepresentationItem;
import eu.bopet.jocadv.ie.step.entities.RoleAssociation;
import eu.bopet.jocadv.ie.step.entities.SeamCurve;
import eu.bopet.jocadv.ie.step.entities.SecurityClassification;
import eu.bopet.jocadv.ie.step.entities.SecurityClassificationLevel;
import eu.bopet.jocadv.ie.step.entities.ShapeAspect;
import eu.bopet.jocadv.ie.step.entities.ShapeDefinitionRepresentation;
import eu.bopet.jocadv.ie.step.entities.ShapeRepresentationRelationship;
import eu.bopet.jocadv.ie.step.entities.ShellBasedSurfaceModel;
import eu.bopet.jocadv.ie.step.entities.StyledItem;
import eu.bopet.jocadv.ie.step.entities.SurfaceCurve;
import eu.bopet.jocadv.ie.step.entities.SurfaceOfLinearExtrusion;
import eu.bopet.jocadv.ie.step.entities.SurfaceProfileTolerance;
import eu.bopet.jocadv.ie.step.entities.SurfaceSideStyle;
import eu.bopet.jocadv.ie.step.entities.SurfaceStyleBoundary;
import eu.bopet.jocadv.ie.step.entities.SurfaceStyleFillArea;
import eu.bopet.jocadv.ie.step.entities.SurfaceStyleParameterLine;
import eu.bopet.jocadv.ie.step.entities.SurfaceStyleRenderingWithProperties;
import eu.bopet.jocadv.ie.step.entities.SurfaceStyleTransparent;
import eu.bopet.jocadv.ie.step.entities.SurfaceStyleUsage;
import eu.bopet.jocadv.ie.step.entities.TessellatedAnnotationOccurrence;
import eu.bopet.jocadv.ie.step.entities.TessellatedGeometricSet;
import eu.bopet.jocadv.ie.step.entities.TessellatedShapeRepresentation;
import eu.bopet.jocadv.ie.step.entities.TessellatedSolid;
import eu.bopet.jocadv.ie.step.entities.ToleranceValue;
import eu.bopet.jocadv.ie.step.entities.ToleranceZone;
import eu.bopet.jocadv.ie.step.entities.ToleranceZoneForm;
import eu.bopet.jocadv.ie.step.entities.ToroidalSurface;
import eu.bopet.jocadv.ie.step.entities.TrimmedCurve;
import eu.bopet.jocadv.ie.step.entities.TypeQualifier;
import eu.bopet.jocadv.ie.step.entities.ValueFormatTypeQualifier;
import eu.bopet.jocadv.ie.step.entities.ValueRepresentationItem;
import eu.bopet.jocadv.ie.step.entities.Vector;
import eu.bopet.jocadv.ie.step.entities.VertexLoop;
import eu.bopet.jocadv.ie.step.entities.VertexPoint;
import eu.bopet.jocadv.ie.step.entities.ViewVolume;
import eu.bopet.jocadv.ie.step.entities.VolumeUnit;
import eu.bopet.jocadv.ie.step.exception.StepProcessingException;
import eu.bopet.jocadv.ie.step.measure.LengthMeasureWithUnit;
import eu.bopet.jocadv.ie.step.measure.MassMeasureWithUnit;
import eu.bopet.jocadv.ie.step.measure.MeasureWithUnit;
import eu.bopet.jocadv.ie.step.measure.Measures;
import eu.bopet.jocadv.ie.step.measure.PlaneAngleMeasureWithUnit;
import eu.bopet.jocadv.ie.step.measure.UncertaintyMeasureWithUnit;
import eu.bopet.jocadv.ie.step.representation.ConstructiveGeometryRepresentation;
import eu.bopet.jocadv.ie.step.representation.DimensionalCharacteristicRepresentation;
import eu.bopet.jocadv.ie.step.representation.Representation;
import eu.bopet.jocadv.ie.step.representation.RepresentationMap;
import eu.bopet.jocadv.ie.step.representation.RepresentationRelationship;
import eu.bopet.jocadv.ie.step.representation.ShapeDimensionRepresentation;
import eu.bopet.jocadv.ie.step.representation.ShapeRepresentation;
import eu.bopet.jocadv.ie.step.shapeAspect.ShapeAspects;
import eu.bopet.jocadv.ie.step.surface.BSplineSurfaceWithKnots;
import eu.bopet.jocadv.ie.step.surface.SphericalSurface;
import eu.bopet.jocadv.ie.step.surface.Surfaces;
import eu.bopet.jocadv.ie.step.tolerance.AngularityTolerance;
import eu.bopet.jocadv.ie.step.tolerance.ConcentricityTolerance;
import eu.bopet.jocadv.ie.step.tolerance.RoundnessTolerance;
import eu.bopet.jocadv.ie.step.tolerance.StraightnessTolerance;
import eu.bopet.jocadv.ie.step.tolerance.Tolerances;
import eu.bopet.jocadv.ie.step.tolerance.TotalRunOutTolerance;
import eu.bopet.jocadv.ie.step.unit.Units;
import eu.bopet.jocadv.ie.step.util.StepCode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadStepFile {

    public static List<StepEntityBase> readStepFile(File file) throws StepProcessingException {
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
                    if (secondTag.startsWith(StepCode.PRODUCT_CATEGORY_RELATIONSHIP)) {
                        ProductCategoryRelationship productCategoryRelationship =
                                new ProductCategoryRelationship(id, name, att[1]);
                        result.add(productCategoryRelationship);
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
                        ComplexTriangulatedSurfaceSet complexTriangulatedSurfaceSet =
                                new ComplexTriangulatedSurfaceSet(id, name, att[1]);
                        result.add(complexTriangulatedSurfaceSet);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.DEFAULT_MODEL_GEOMETRIC_VIEW)) {
                        DefaultModelGeometricView defaultModelGeometricView =
                                new DefaultModelGeometricView(id, name, att[1]);
                        result.add(defaultModelGeometricView);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.MODEL_GEOMETRIC_VIEW)) {
                        ModelGeometricView modelGeometricView =
                                new ModelGeometricView(id, name, att[1]);
                        result.add(modelGeometricView);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.MECHANICAL_DESIGN_AND_DRAUGHTING_RELATIONSHIP)) {
                        MechanicalDesignAndDraughtingRelationship mechanicalDesignAndDraughtingRelationship =
                                new MechanicalDesignAndDraughtingRelationship(id, name, att[1]);
                        result.add(mechanicalDesignAndDraughtingRelationship);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.CAMERA_MODEL_D3)) {
                        CameraModelD3 cameraModelD3 = new CameraModelD3(id, name, att[1]);
                        result.add(cameraModelD3);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.VIEW_VOLUME)) {
                        ViewVolume viewVolume = new ViewVolume(id, "", attributes);
                        result.add(viewVolume);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.PLANAR_BOX)) {
                        PlanarBox planarBox = new PlanarBox(id, name, att[1]);
                        result.add(planarBox);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.DIMENSIONAL_LOCATION)) {
                        DimensionalLocation dimensionalLocation = new DimensionalLocation(id, name, att[1]);
                        result.add(dimensionalLocation);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.GEOMETRIC_TOLERANCE_RELATIONSHIP)) {
                        GeometricToleranceRelationship geometricToleranceRelationship
                                = new GeometricToleranceRelationship(id, name, att[1]);
                        result.add(geometricToleranceRelationship);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.ALL_AROUND_SHAPE_ASPECT)) {
                        AllAroundShapeAspect allAroundShapeAspect = new AllAroundShapeAspect(id, name, att[1]);
                        result.add(allAroundShapeAspect);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.DATUM_REFERENCE_ELEMENT)) {
                        DatumReferenceElement datumReferenceElement = new DatumReferenceElement(id, name, att[1]);
                        result.add(datumReferenceElement);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.FLATNESS_TOLERANCE)) {
                        FlatnessTolerance flatnessTolerance = new FlatnessTolerance(id, name, att[1]);
                        result.add(flatnessTolerance);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.PARALLELISM_TOLERANCE)) {
                        ParallelismTolerance parallelismTolerance = new ParallelismTolerance(id, name, att[1]);
                        result.add(parallelismTolerance);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.DATUM_FEATURE)) {
                        DatumFeature datumFeature = new DatumFeature(id, name, att[1]);
                        result.add(datumFeature);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.PROPERTY_DEFINITION_REPRESENTATION)) {
                        PropertyDefinitionRepresentation propertyDefinitionRepresentation =
                                new PropertyDefinitionRepresentation(id, "", attributes);
                        result.add(propertyDefinitionRepresentation);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.REPRESENTATION_MAP)) {
                        RepresentationMap representationMap = new RepresentationMap(id, "", attributes);
                        result.add(representationMap);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.REPRESENTATION_RELATIONSHIP)) {
                        RepresentationRelationship representationRelationship =
                                new RepresentationRelationship(id, name, att[1]);
                        result.add(representationRelationship);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.REPRESENTATION)) {
                        Representation representation = new Representation(id, name, att[1]);
                        result.add(representation);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.PROPERTY_DEFINITION)) {
                        PropertyDefinition propertyDefinition = new PropertyDefinition(id, name, att[1]);
                        result.add(propertyDefinition);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.DESCRIPTIVE_REPRESENTATION_ITEM)) {
                        DescriptiveRepresentationItem descriptiveRepresentationItem =
                                new DescriptiveRepresentationItem(id, name, att[1]);
                        result.add(descriptiveRepresentationItem);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.SHAPE_ASPECT_RELATIONSHIP)) {
                        ShapeRepresentationRelationship shapeRepresentationRelationship
                                = new ShapeRepresentationRelationship(id, name, att[1]);
                        result.add(shapeRepresentationRelationship);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.TOLERANCE_ZONE_FORM)) {
                        ToleranceZoneForm toleranceZoneForm = new ToleranceZoneForm(id, name);
                        result.add(toleranceZoneForm);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.TOLERANCE_ZONE)) {
                        ToleranceZone toleranceZone = new ToleranceZone(id, name, att[1]);
                        result.add(toleranceZone);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.DATUM_REFERENCE_COMPARTMENT)) {
                        DatumReferenceCompartment datumReferenceCompartment =
                                new DatumReferenceCompartment(id, name, att[1]);
                        result.add(datumReferenceCompartment);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.DATUM_SYSTEM)) {
                        DatumSystem datumSystem = new DatumSystem(id, name, att[1]);
                        result.add(datumSystem);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.DATUM)) {
                        Datum datum = new Datum(id, name, att[1]);
                        result.add(datum);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.PLUS_MINUS_TOLERANCE)) {
                        PlusMinusTolerance plusMinusTolerance = new PlusMinusTolerance(id, "", attributes);
                        result.add(plusMinusTolerance);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.TOLERANCE_VALUE)) {
                        ToleranceValue toleranceValue = new ToleranceValue(id, "", attributes);
                        result.add(toleranceValue);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.MEASURE_QUALIFICATION)) {
                        MeasureQualification measureQualification = new MeasureQualification(id, name, att[1]);
                        result.add(measureQualification);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.MEASURE_WITH_UNIT)) {
                        MeasureWithUnit measureWithUnit = new MeasureWithUnit(id, "", attributes);
                        result.add(measureWithUnit);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.DIMENSIONAL_CHARACTERISTIC_REPRESENTATION)) {
                        DimensionalCharacteristicRepresentation dimensionalCharacteristicRepresentation =
                                new DimensionalCharacteristicRepresentation(id, "", attributes);
                        result.add(dimensionalCharacteristicRepresentation);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.DIMENSIONAL_SIZE)) {
                        DimensionalSize dimensionalSize = new DimensionalSize(id, "", attributes);
                        result.add(dimensionalSize);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.SHAPE_DIMENSION_REPRESENTATION)) {
                        ShapeDimensionRepresentation shapeDimensionRepresentation =
                                new ShapeDimensionRepresentation(id, name, att[1]);
                        result.add(shapeDimensionRepresentation);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.SHAPE_ASPECT)) {
                        ShapeAspect shapeAspect = new ShapeAspect(id, name, att[1]);
                        result.add(shapeAspect);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.MAPPED_ITEM)) {
                        MappedItem mappedItem = new MappedItem(id, name, att[1]);
                        result.add(mappedItem);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.COLOUR)) {
                        Colour colour = new Colour(id, "");
                        result.add(colour);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.DRAUGHTING_CALLOUT_RELATIONSHIP)) {
                        DraughtingCallOutRelationship draughtingCallOutRelationship =
                                new DraughtingCallOutRelationship(id, name, att[1]);
                        result.add(draughtingCallOutRelationship);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.DRAUGHTING_CALLOUT)) {
                        DraughtingCallOut draughtingCallOut = new DraughtingCallOut(id, name, att[1]);
                        result.add(draughtingCallOut);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.DRAUGHTING_PRE_DEFINED_COLOUR)) {
                        DraughtingPreDefinedColour draughtingPreDefinedColour =
                                new DraughtingPreDefinedColour(id, name);
                        result.add(draughtingPreDefinedColour);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.TESSELLATED_CURVE_SET)) {
                        TessellatedCurveSet tessellatedCurveSet = new TessellatedCurveSet(id, name, att[1]);
                        result.add(tessellatedCurveSet);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.CONSTRUCTIVE_GEOMETRY_REPRESENTATION_RELATIONSHIP)) {
                        ConstructiveGeometryRepresentationRelationship constructiveGeometryRepresentationRelationship =
                                new ConstructiveGeometryRepresentationRelationship(id, name, att[1]);
                        result.add(constructiveGeometryRepresentationRelationship);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.CONSTRUCTIVE_GEOMETRY_REPRESENTATION)) {
                        ConstructiveGeometryRepresentation constructiveGeometryRepresentation =
                                new ConstructiveGeometryRepresentation(id, name, att[1]);
                        result.add(constructiveGeometryRepresentation);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.COMPOSITE_GROUP_SHAPE_ASPECT)) {
                        CompositeGroupShapeAspect compositeGroupShapeAspect =
                                new CompositeGroupShapeAspect(id, name, att[1]);
                        result.add(compositeGroupShapeAspect);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.VALUE_FORMAT_TYPE_QUALIFIER)) {
                        ValueFormatTypeQualifier valueFormatTypeQualifier = new ValueFormatTypeQualifier(id, name);
                        result.add(valueFormatTypeQualifier);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.DRAUGHTING_MODEL_ITEM_ASSOCIATION)) {
                        DraughtingModelItemAssociation draughtingModelItemAssociation =
                                new DraughtingModelItemAssociation(id, name, att[1]);
                        result.add(draughtingModelItemAssociation);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.GEOMETRIC_ITEM_SPECIFIC_USAGE)) {
                        GeometricItemSpecificUsage geometricItemSpecificUsage =
                                new GeometricItemSpecificUsage(id, name, att[1]);
                        result.add(geometricItemSpecificUsage);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.ID_ATTRIBUTE)) {
                        IdAttribute idAttribute = new IdAttribute(id, name, att[1]);
                        result.add(idAttribute);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.ANNOTATION_PLANE)) {
                        AnnotationPlane annotationPlane = new AnnotationPlane(id, name, att[1]);
                        result.add(annotationPlane);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.TESSELLATED_ANNOTATION_OCCURRENCE)) {
                        TessellatedAnnotationOccurrence tessellatedAnnotationOccurrence =
                                new TessellatedAnnotationOccurrence(id, name, att[1]);
                        result.add(tessellatedAnnotationOccurrence);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.DERIVED_UNIT_ELEMENT)) {
                        DerivedUnitElement derivedUnitElement = new DerivedUnitElement(id, "", attributes);
                        result.add(derivedUnitElement);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.DERIVED_UNIT)) {
                        DerivedUnit derivedUnit = new DerivedUnit(id, "", attributes);
                        result.add(derivedUnit);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.MEASURE_REPRESENTATION_ITEM)) {
                        MeasureRepresentationItem measureRepresentationItem =
                                new MeasureRepresentationItem(id, name, att[1]);
                        result.add(measureRepresentationItem);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.DRAUGHTING_MODEL)) {
                        DraughtingModel draughtingModel = new DraughtingModel(id, name, att[1]);
                        result.add(draughtingModel);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.ANNOTATION_OCCURRENCE)) {
                        AnnotationOccurrence annotationOccurrence = new AnnotationOccurrence(id, name, att[1]);
                        result.add(annotationOccurrence);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.POLYLINE)) {
                        Polyline polyline = new Polyline(id, name, att[1]);
                        result.add(polyline);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.VALUE_REPRESENTATION_ITEM)) {
                        ValueRepresentationItem valueRepresentationItem =
                                new ValueRepresentationItem(id, name, att[1]);
                        result.add(valueRepresentationItem);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.NAME_ATTRIBUTE)) {
                        NameAttribute nameAttribute = new NameAttribute(id, name, att[1]);
                        result.add(nameAttribute);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.ANGULAR_LOCATION)) {
                        AngularLocation angularLocation = new AngularLocation(id, name, att[1]);
                        result.add(angularLocation);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.PERPENDICULARITY_TOLERANCE)) {
                        PerpendicularityTolerance perpendicularityTolerance =
                                new PerpendicularityTolerance(id, name, att[1]);
                        result.add(perpendicularityTolerance);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.COMPOSITE_SHAPE_ASPECT)) {
                        CompositeShapeAspect compositeShapeAspect = new CompositeShapeAspect(id, name, att[1]);
                        result.add(compositeShapeAspect);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.SURFACE_STYLE_BOUNDARY)) {
                        SurfaceStyleBoundary surfaceStyleBoundary = new SurfaceStyleBoundary(id, "", attributes);
                        result.add(surfaceStyleBoundary);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.SURFACE_STYLE_PARAMETER_LINE)) {
                        SurfaceStyleParameterLine surfaceStyleParameterLine =
                                new SurfaceStyleParameterLine(id, "", attributes);
                        result.add(surfaceStyleParameterLine);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.GENERAL_PROPERTY_ASSOCIATION)) {
                        GeneralPropertyAssociation generalPropertyAssociation =
                                new GeneralPropertyAssociation(id, name, att[1]);
                        result.add(generalPropertyAssociation);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.GENERAL_PROPERTY)) {
                        GeneralProperty generalProperty =
                                new GeneralProperty(id, name, att[1]);
                        result.add(generalProperty);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.CHARACTERIZED_ITEM_WITHIN_REPRESENTATION)) {
                        CharacterizedItemWithinRepresentation characterizedItemWithinRepresentation =
                                new CharacterizedItemWithinRepresentation(id, name, att[1]);
                        result.add(characterizedItemWithinRepresentation);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.INTEGER_REPRESENTATION_ITEM)) {
                        IntegerRepresentationItem integerRepresentationItem =
                                new IntegerRepresentationItem(id, name, att[1].replace(".", ""));
                        result.add(integerRepresentationItem);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.PRE_DEFINED_POINT_MARKER_SYMBOL)) {
                        PreDefinedPointMarkerSymbol preDefinedPointMarkerSymbol =
                                new PreDefinedPointMarkerSymbol(id, "", attributes);
                        result.add(preDefinedPointMarkerSymbol);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.PRE_DEFINED_MARKER)) {
                        PreDefinedMarker preDefinedMarker = new PreDefinedMarker(id, name);
                        result.add(preDefinedMarker);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.SURFACE_STYLE_RENDERING_WITH_PROPERTIES)) {
                        SurfaceStyleRenderingWithProperties surfaceStyleRenderingWithProperties =
                                new SurfaceStyleRenderingWithProperties(id, "", attributes);
                        result.add(surfaceStyleRenderingWithProperties);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.SURFACE_STYLE_TRANSPARENT)) {
                        SurfaceStyleTransparent surfaceStyleTransparent =
                                new SurfaceStyleTransparent(id, "", attributes);
                        result.add(surfaceStyleTransparent);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.ITEM_IDENTIFIED_REPRESENTATION_USAGE)) {
                        ItemIdentifiedRepresentationUsage itemIdentifiedRepresentationUsage =
                                new ItemIdentifiedRepresentationUsage(id, name, att[1]);
                        result.add(itemIdentifiedRepresentationUsage);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.REAL_REPRESENTATION_ITEM)) {
                        RealRepresentationItem realRepresentationItem =
                                new RealRepresentationItem(id, name, att[1]);
                        result.add(realRepresentationItem);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.SURFACE_PROFILE_TOLERANCE)) {
                        SurfaceProfileTolerance surfaceProfileTolerance =
                                new SurfaceProfileTolerance(id, name, att[1]);
                        result.add(surfaceProfileTolerance);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.FEATURE_FOR_DATUM_TARGET_RELATIONSHIP)) {
                        FeatureForDatumTargetRelationship featureForDatumTargetRelationship =
                                new FeatureForDatumTargetRelationship(id, name, att[1]);
                        result.add(featureForDatumTargetRelationship);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.PLACED_DATUM_TARGET_FEATURE)) {
                        PlacedDatumTargetFeature placedDatumTargetFeature =
                                new PlacedDatumTargetFeature(id, name, att[1]);
                        result.add(placedDatumTargetFeature);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.ANNOTATION_PLACEHOLDER_OCCURRENCE)) {
                        AnnotationPlaceholderOccurrence annotationPlaceholderOccurrence =
                                new AnnotationPlaceholderOccurrence(id, name, att[1]);
                        result.add(annotationPlaceholderOccurrence);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.GEOMETRIC_SET)) {
                        GeometricSet geometricSet = new GeometricSet(id, name, att[1]);
                        result.add(geometricSet);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.MANIFOLD_SURFACE_SHAPE_REPRESENTATION)) {
                        ManifoldSurfaceShapeRepresentation manifoldSurfaceShapeRepresentation =
                                new ManifoldSurfaceShapeRepresentation(id, name, att[1]);
                        result.add(manifoldSurfaceShapeRepresentation);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.OPEN_SHELL)) {
                        OpenShell openShell = new OpenShell(id, name, att[1]);
                        result.add(openShell);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.SHELL_BASED_SURFACE_MODEL)) {
                        ShellBasedSurfaceModel shellBasedSurfaceModel = new ShellBasedSurfaceModel(id, name, att[1]);
                        result.add(shellBasedSurfaceModel);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.AREA_UNIT)) {
                        AreaUnit areaUnit = new AreaUnit(id, "", attributes);
                        result.add(areaUnit);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.VOLUME_UNIT)) {
                        VolumeUnit volumeUnit = new VolumeUnit(id, "", attributes);
                        result.add(volumeUnit);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.COMPOSITE_CURVE_SEGMENT)) {
                        CompositeCurveSegment compositeCurveSegment =
                                new CompositeCurveSegment(id, "", attributes);
                        result.add(compositeCurveSegment);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.COMPOSITE_CURVE)) {
                        CompositeCurve compositeCurve = new CompositeCurve(id, "", attributes);
                        result.add(compositeCurve);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.GEOMETRICALLY_BOUNDED_SURFACE_SHAPE_REPRESENTATION)) {
                        GeometricallyBoundedSurfaceShapeRepresentation geometricallyBoundedSurfaceShapeRepresentation =
                                new GeometricallyBoundedSurfaceShapeRepresentation(id, name, att[1]);
                        result.add(geometricallyBoundedSurfaceShapeRepresentation);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.ANGULARITY_TOLERANCE)) {
                        AngularityTolerance angularityTolerance = new AngularityTolerance(id, name, att[1]);
                        result.add(angularityTolerance);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.OVER_RIDING_STYLED_ITEM)) {
                        OverRidingStyledItem overRidingStyledItem = new OverRidingStyledItem(id, name, att[1]);
                        result.add(overRidingStyledItem);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.TESSELLATED_GEOMETRIC_SET)) {
                        TessellatedGeometricSet tessellatedGeometricSet =
                                new TessellatedGeometricSet(id, name, att[1]);
                        result.add(tessellatedGeometricSet);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.TESSELLATED_SHAPE_REPRESENTATION)) {
                        TessellatedShapeRepresentation tessellatedShapeRepresentation =
                                new TessellatedShapeRepresentation(id, name, att[1]);
                        result.add(tessellatedShapeRepresentation);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.PROJECTED_ZONE_DEFINITION)) {
                        ProjectedZoneDefinition projectedZoneDefinition
                                = new ProjectedZoneDefinition(id, "", attributes);
                        result.add(projectedZoneDefinition);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.ANGULAR_SIZE)) {
                        AngularSize angularSize = new AngularSize(id, "", attributes);
                        result.add(angularSize);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.ANNOTATION_CURVE_OCCURRENCE)) {
                        AnnotationCurveOccurrence annotationCurveOccurrence =
                                new AnnotationCurveOccurrence(id, name, att[1]);
                        result.add(annotationCurveOccurrence);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.TYPE_QUALIFIER)) {
                        TypeQualifier typeQualifier = new TypeQualifier(id, name);
                        result.add(typeQualifier);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.CIRCULAR_RUNOUT_TOLERANCE)) {
                        CircularRunOutTolerance circularRunOutTolerance =
                                new CircularRunOutTolerance(id, name, att[1]);
                        result.add(circularRunOutTolerance);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.STRAIGHTNESS_TOLERANCE)) {
                        StraightnessTolerance straightnessTolerance = new StraightnessTolerance(id, name, att[1]);
                        result.add(straightnessTolerance);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.CONCENTRICITY_TOLERANCE)) {
                        ConcentricityTolerance concentricityTolerance =
                                new ConcentricityTolerance(id, name, att[1]);
                        result.add(concentricityTolerance);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.ROUNDNESS_TOLERANCE)) {
                        RoundnessTolerance roundnessTolerance =
                                new RoundnessTolerance(id, name, att[1]);
                        result.add(roundnessTolerance);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.TOTAL_RUNOUT_TOLERANCE)) {
                        TotalRunOutTolerance totalRunOutTolerance =
                                new TotalRunOutTolerance(id, name, att[1]);
                        result.add(totalRunOutTolerance);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.DOCUMENT_PRODUCT_EQUIVALENCE)) {
                        DocumentProductEquivalence documentProductEquivalence =
                                new DocumentProductEquivalence(id, name, att[1]);
                        result.add(documentProductEquivalence);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.ROLE_ASSOCIATION)) {
                        RoleAssociation roleAssociation = new RoleAssociation(id, "", attributes);
                        result.add(roleAssociation);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.PRODUCT_DEFINITION_CONTEXT_ASSOCIATION)) {
                        ProductDefinitionContextAssociation productDefinitionContextAssociation =
                                new ProductDefinitionContextAssociation(id, "", attributes);
                        result.add(productDefinitionContextAssociation);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.PRODUCT_DEFINITION_CONTEXT_ROLE)) {
                        ProductDefinitionContextRole productDefinitionContextRole =
                                new ProductDefinitionContextRole(id, name, att[1]);
                        result.add(productDefinitionContextRole);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.APPLIED_DOCUMENT_REFERENCE)) {
                        AppliedDocumentReference appliedDocumentReference =
                                new AppliedDocumentReference(id, "", attributes);
                        result.add(appliedDocumentReference);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.DOCUMENT_TYPE)) {
                        DocumentType documentType = new DocumentType(id, name);
                        result.add(documentType);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.DOCUMENT)) {
                        Document document = new Document(id, name, att[1]);
                        result.add(document);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.OBJECT_ROLE)) {
                        ObjectRole objectRole = new ObjectRole(id, name, att[1]);
                        result.add(objectRole);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.COMPOUND_REPRESENTATION_ITEM)) {
                        CompoundRepresentationItem compoundRepresentationItem =
                                new CompoundRepresentationItem(id, name, att[1]);
                        result.add(compoundRepresentationItem);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.MASS_MEASURE_WITH_UNIT)) {
                        MassMeasureWithUnit massMeasureWithUnit =
                                new MassMeasureWithUnit(id, "", attributes);
                        result.add(massMeasureWithUnit);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.COMPLEX_TRIANGULATED_FACE)) {
                        ComplexTriangulatedFace complexTriangulatedFace =
                                new ComplexTriangulatedFace(id, name, att[1]);
                        result.add(complexTriangulatedFace);
                        continue;
                    }
                    if (secondTag.startsWith(StepCode.TESSELLATED_SOLID)) {
                        TessellatedSolid tessellatedSolid = new TessellatedSolid(id, name, att[1]);
                        System.out.println(command);
                        System.out.println(tessellatedSolid);
                        result.add(tessellatedSolid);
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
                        if (Arrays.asList(StepCode.TOLERANCES).contains(firstSet)) {
                            Tolerances tolerances = new Tolerances(id, "", set);
                            result.add(tolerances);
                            continue;
                        }
                        if (Arrays.asList(StepCode.MEASURES).contains(firstSet)) {
                            Measures measures = new Measures(id, "", set);
                            result.add(measures);
                            continue;
                        }
                        if (Arrays.asList(StepCode.CHARACTERIZED_OBJECTS).contains(firstSet)) {
                            CharacterizedObjects characterizedObjects = new CharacterizedObjects(id, "", set);
                            result.add(characterizedObjects);
                            continue;
                        }
                        if (Arrays.asList(StepCode.SHAPE_ASPECTS).contains(firstSet)) {
                            ShapeAspects shapeAspects = new ShapeAspects(id, "", set);
                            result.add(shapeAspects);
                            continue;
                        }
                        System.out.println("???Set of : " + set + "\n first set: " + firstSet);
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
            e.printStackTrace();
            throw new StepProcessingException(errorLine);
        }
        int entitiesCount = result.size();
        int checkedEntities = result.get(result.size() - 1).getId() - result.get(0).getId() + 1;
        if (entitiesCount == checkedEntities) {
            System.out.println("All " + entitiesCount + " entities have been processed.");
        } else {
            System.out.println("Entities processed: " + entitiesCount);
            System.out.println("Id check: " + checkedEntities);
        }
        return result;
    }
}
