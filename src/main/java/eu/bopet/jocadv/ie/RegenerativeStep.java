package eu.bopet.jocadv.ie;

import eu.bopet.jocadv.core.constraints.regenerative.RegenerativeLink;
import eu.bopet.jocadv.core.features.Feature;
import eu.bopet.jocadv.core.features.vector.JoValue;
import eu.bopet.jocadv.ie.step.ReadStepFile;
import eu.bopet.jocadv.ie.step.util.StepEntityBase;

import java.io.File;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RegenerativeStep implements RegenerativeLink {
    private File stepFile;
    private final StepFeature stepFeature;

    public RegenerativeStep(File stepFile) {
        this.stepFile = stepFile;
        Set<Feature> features = new LinkedHashSet<>();
        stepFeature = new StepFeature(this, features);
        List<StepEntityBase> stepEntities = ReadStepFile.readStepFile(stepFile);
        for (StepEntityBase entity : stepEntities) {
            if (entity instanceof RegenerativeLink) {
                RegenerativeLink regenerativeLink = (RegenerativeLink) entity;
                features.add(regenerativeLink.getResult());
            }
        }
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
    }

    @Override
    public Feature getResult() {
        return stepFeature;
    }

    @Override
    public Set<JoValue> getValues() {
        return null;
    }
}
