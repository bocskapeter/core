package eu.bopet.jocadv.ie.step;

import org.junit.jupiter.api.Test;

import java.io.File;

class ReadStepFileTest {

    @Test
    void ReadStepFileTest() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("test.step").getFile());
        ReadStepFile.readStepFile(file);
    }
}