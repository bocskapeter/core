package eu.bopet.jocadv.ie.step;

import eu.bopet.jocadv.core.features.JoFeature;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Set;

class ReadStepFileTest {

    @Test
    void ReadStepFileTest() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        File folder = new File("src/main/resources/stepfiles");
        File[] files = folder.listFiles();
        if (files.length > 0) {
            for (File f : files) {
                System.out.println("File: " + f.getName());
                File file = new File(classLoader.getResource(f.getName()).getFile());
                RegenerativeStep regenerativeStep = new RegenerativeStep(file);
                StepFeature feature = (StepFeature) regenerativeStep.getResult();
                Set<JoFeature> entityList = feature.getFeatures();
                if (!entityList.isEmpty()) {
                    System.out.println("Entities: " + entityList.size() + "\n");
                }
            }
        }

    }
}