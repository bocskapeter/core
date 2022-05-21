package eu.bopet.jocadv.ie.step;

import eu.bopet.jocadv.core.features.JoFeature;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Set;

class ReadStepFileTest {

    @Test
    void ReadStepFileTest() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        String fileName = "nist_ftc_08_asme1_ap242-e1-tg.stp";
        File file = new File(classLoader.getResource(fileName).getFile());
        RegenerativeStep regenerativeStep = new RegenerativeStep(file);
        StepFeature feature = (StepFeature) regenerativeStep.getResult();
        Set<JoFeature> entityList = feature.getFeatures();
        if (!entityList.isEmpty()) {

            System.out.println("\n----****----\nEntities: " + entityList.size());
        }
    }
}