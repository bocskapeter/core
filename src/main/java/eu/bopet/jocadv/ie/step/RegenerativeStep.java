package eu.bopet.jocadv.ie.step;

import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.sketch.JoSValue;
import eu.bopet.jocadv.core.features.RegenerativeLink;

import java.io.File;
import java.util.LinkedHashSet;
import java.util.Set;

public class RegenerativeStep implements RegenerativeLink {
    private final StepFeature stepFeature;
    private File stepFile;

    public RegenerativeStep(File stepFile) throws Exception {
        this.stepFile = stepFile;
        Set<JoFeature> features = new LinkedHashSet<>();
        stepFeature = new StepFeature(this, stepFile.getName());
        ReadStepFile.readStepFile(stepFeature, stepFile);
    }

    public File getStepFile() {
        return stepFile;
    }

    public void setStepFile(File stepFile) throws Exception {
        this.stepFile = stepFile;
        regenerate();
    }

    @Override
    public void regenerate() throws Exception {
        // TODO
        // read step file and update all of the existing features
    }

    @Override
    public JoFeature getResult() {
        return stepFeature;
    }

    @Override
    public Set<JoSValue> getValues() {
        return null;
    }
}
