package eu.bopet.jocadv.ie.step;

import eu.bopet.jocadv.core.features.JoFeature;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;
import java.util.Map;

class ReadStepFileTest {

    @Test
    void ReadAllStepFilesInFolderTest() throws Exception {
        File folder = new File("src/main/resources/stepfiles");
        File[] files = folder.listFiles();
        assert files != null;
        for (File f : files) {
            if (f.isFile()) {
                System.out.println("-->File: " + f.getName());
                RegenerativeStep regenerativeStep = new RegenerativeStep(f);
                StepFeature feature = (StepFeature) regenerativeStep.getResult();
                List<StepEntity> entityList = feature.getStepEntities();
                if (!entityList.isEmpty()) {
                    System.out.println("Entities: " + entityList.size());
                }
                Map<StepEntity, JoFeature> fetrureMap = feature.getFeatureMap();
                if (!fetrureMap.isEmpty()) {
                    System.out.println("Mapped features: " + fetrureMap.size());
                }
                System.out.println("<--File has been processed.");
            }
        }
        System.out.println("Test done!");
    }
}