package eu.bopet.jocadv.ie.step;

import eu.bopet.jocadv.core.features.JoFeature;
import eu.bopet.jocadv.core.features.RegenerativeLink;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StepFeature implements JoFeature {
    private final String filename;
    private final Date timestamp;
    private String stepDescription;
    private String stepFileName;
    private String stepFileSchema;
    private RegenerativeLink regenerativeLink;
    private List<StepEntity> stepEntities;
    private Map<StepEntity, JoFeature> featureMap;

    public StepFeature(RegenerativeLink regenerativeLink, String filename) {
        this.filename = filename;
        this.timestamp = new Date();
        this.regenerativeLink = regenerativeLink;
        this.stepEntities = new ArrayList<>();
        this.featureMap = new HashMap<>();
        this.stepFileName = "";
        this.stepFileSchema = "";
    }

    public List<StepEntity> getStepEntities() {
        return stepEntities;
    }

    @Override
    public RegenerativeLink getRegenerativeLink() {
        return regenerativeLink;
    }

    @Override
    public void setRegenerativeLink(RegenerativeLink newRegenerativeLink) {
        this.regenerativeLink = newRegenerativeLink;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getStepDescription() {
        return stepDescription;
    }

    public void setStepDescription(String stepDescription) {
        this.stepDescription = stepDescription;
    }

    public String getStepFileName() {
        return stepFileName;
    }

    public void setStepFileName(String stepFileName) {
        this.stepFileName = stepFileName;
    }

    public String getStepFileSchema() {
        return stepFileSchema;
    }

    public void setStepFileSchema(String stepFileSchema) {
        this.stepFileSchema = stepFileSchema;
    }

    public Map<StepEntity, JoFeature> getFeatureMap() {
        return featureMap;
    }

    public void generateJoFeatures() throws Exception {
        for (StepEntity entityBase : stepEntities) {
            if (entityBase instanceof StepLink) {
                StepLink stepLink = (StepLink) entityBase;
                stepLink.generateJoFeature(this);
            }
        }
    }

    public StepEntity getStepEntityByID(int id) {
        for (StepEntity entity : stepEntities) {
            if (entity.getId() == id) return entity;
        }
        return null;
    }
}
