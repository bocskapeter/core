package eu.bopet.jocadv.ie.step;

import eu.bopet.jocadv.core.features.JoFeature;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Set;

class ReadStepFileTest {

    @Test
    void ReadStepFileTest() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("test.step").getFile());
        RegenerativeStep regenerativeStep = new RegenerativeStep(file);
        StepFeature feature = (StepFeature) regenerativeStep.getResult();
        Set<JoFeature> entityList = feature.getFeatures();
        System.out.println("\n----****----\nEntities:");
        if (!entityList.isEmpty()) {
            for (JoFeature entity : entityList) {
                System.out.println(entity);
            }
        }
    }
}