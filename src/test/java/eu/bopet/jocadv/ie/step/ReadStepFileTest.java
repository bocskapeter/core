package eu.bopet.jocadv.ie.step;

import eu.bopet.jocadv.ie.step.util.StepEntityBase;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

class ReadStepFileTest {

    @Test
    void ReadStepFileTest() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("testFC.step").getFile());
        List<StepEntityBase> entityList = ReadStepFile.readStepFile(file);
        System.out.println("\n----****----\nEntities:");
        if (!entityList.isEmpty()) {
            for (StepEntityBase entity : entityList) {
                System.out.println(entity);
                if (entity instanceof StepLink) {
                    StepLink stepLink = (StepLink) entity;
                    System.out.println("StepLink: " + stepLink.getResult(entityList));
                }
            }
        }
    }
}