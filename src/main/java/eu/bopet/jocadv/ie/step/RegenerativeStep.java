package eu.bopet.jocadv.ie.step;

import eu.bopet.jocadv.core.constraints.regenerative.RegenerativeLink;
import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.vector.JoValue;
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
        Set<JoFeature> features = new LinkedHashSet<>();
        stepFeature = new StepFeature(this, features);
        List<StepEntityBase> stepEntities = ReadStepFile.readStepFile(stepFile);
        for (StepEntityBase entity : stepEntities) {
            if (entity instanceof StepLink) {
                StepLink stepLink = (StepLink) entity;
                features.add(stepLink.getResult(stepEntities));
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
    public JoFeature getResult() {
        return stepFeature;
    }

    @Override
    public Set<JoValue> getValues() {
        return null;
    }
}
