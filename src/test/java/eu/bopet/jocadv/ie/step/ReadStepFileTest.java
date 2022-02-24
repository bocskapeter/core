package eu.bopet.jocadv.ie.step;

import eu.bopet.jocadv.ie.step.util.StepEntity;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

class ReadStepFileTest {

    @Test
    void ReadStepFileTest() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("testFC.step").getFile());
        List<StepEntity> entityList = ReadStepFile.readStepFile(file);
        System.out.println("\n----****----\nEntities:");
        if (!entityList.isEmpty()) {
            for (StepEntity entity : entityList) {
                System.out.println(entity);
            }
        }
    }
}