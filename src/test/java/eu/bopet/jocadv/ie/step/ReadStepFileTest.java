package eu.bopet.jocadv.ie.step;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

class ReadStepFileTest {

    @Test
    void ReadStepFileTest() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("test.step").getFile());
        List<StepEntity> entityList = ReadStepFile.readStepFile(file);
        System.out.println("Entities: " + entityList);
    }
}