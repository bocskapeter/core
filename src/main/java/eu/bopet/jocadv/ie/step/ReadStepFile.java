package eu.bopet.jocadv.ie.step;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    public static List<StepEntity> readStepFile(File file) {
        List<StepEntity> result = new ArrayList<>();
        System.out.println("Starting with file: " + file.getPath() + " - " + file.getName());
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            StringBuilder stringBuilder = new StringBuilder();
            // get the whole file
            for (String line; (line = br.readLine()) != null; ) {
                stringBuilder.append(line);
            }
            // process the parts
            String[] commands = stringBuilder.toString().split(";");
            for (String command : commands) {
                if (command.startsWith("#")) {
                    System.out.println(command);
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
                    }

                    if (secondTag.startsWith(VERTEX_POINT)) {
                        String bracket = att[1];
                        int pointId = Integer.parseInt(bracket.substring(1));
                        VertexPoint vertexPoint = new VertexPoint(pointId);
                        vertexPoint.setId(id);
                        vertexPoint.setName(name);
                        result.add(vertexPoint);
                        System.out.println("Vertex Point: " + vertexPoint);
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
                    }

                    if (secondTag.startsWith(PLANE)) {
                        int axis2Placement3DId = Integer.parseInt(att[1].substring(1));
                        Plane plane = new Plane(axis2Placement3DId);
                        plane.setId(id);
                        plane.setName(name);
                        result.add(plane);
                        System.out.println("Plane: " + plane);
                    }

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
