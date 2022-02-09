package eu.bopet.jocadv.ie.step;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadStepFile {
    static final String CARTESIAN_POINT = "CARTESIAN_POINT";
    static final List<StepEntity> ENTITIES = new ArrayList<>();

    public static void readStepFile(File file) {
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
                    System.out.println("id: " + id);

                    String secondTag = tags[1].stripLeading();
                    String attribute = secondTag.substring(secondTag.indexOf("(") + 1, secondTag.lastIndexOf(")"));
                    String[] att = attribute.split(",",2);
                    String name = att[0].replaceAll("'","");
                    System.out.println("Name: " + name);

                    if (secondTag.startsWith(CARTESIAN_POINT)) {
                        String bracket = att[1];
                        String substring = bracket.substring(bracket.indexOf("(") + 1, bracket.lastIndexOf(")"));
                        String[] values = substring.split(",");
                        double[] coordinates = new double[values.length];
                        for (int i=0; i<coordinates.length;i++){
                            coordinates[i] = Double.parseDouble(values[i]);
                        }
                        CartesianPoint point = new CartesianPoint(coordinates);
                        point.setId(id);
                        point.setName(name);
                        ENTITIES.add(point);
                        System.out.println("Point: " + point);
                    }

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
