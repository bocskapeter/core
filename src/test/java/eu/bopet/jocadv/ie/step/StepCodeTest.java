package eu.bopet.jocadv.ie.step;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class StepCodeTest {

    @Test
    void ReadStepCodeTest() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("convert/convert.txt").getFile());
        System.out.println("Starting with file: " + file.getPath() + " - " + file.getName());
        List<String> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            for (String line; (line = br.readLine()) != null; ) {
                result.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        if (!result.isEmpty()) {
//            Collections.sort(result);
//        }
        for (String s : result) {
            System.out.println(s.toUpperCase(Locale.ROOT));
        }
    }
}