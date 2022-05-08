package eu.bopet.jocadv.ie.step;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

class StepCodeConverterTest {

    @Test
    void ConvertStepCodesTest() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("convert.txt").getFile());
        System.out.println("Starting with file: " + file.getPath() + " - " + file.getName());
        Set<String> result = new TreeSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            for (String line; (line = br.readLine()) != null; ) {
                result.add(line.toUpperCase().replace(" ", "").replace(",", ""));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String s : result) {
            System.out.println(s + ",");
            //System.out.println("public static final String " + s + " = \"" + s + "\";");
        }
        System.out.println("\npublic static final String[] ALL = {");
        for (String s : result) {
            System.out.println(s + ",");
        }
        System.out.println("};");
    }
}