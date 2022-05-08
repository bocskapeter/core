package eu.bopet.jocadv.ie.step.characterizedObject;

public class CharacterizedObject implements CharacterObject {
    private String name;
    private String description;

    public CharacterizedObject(String attribute) {
        String[] parts = attribute.split(",");
        this.name = parts[0];
        this.description = parts[1];
    }

    @Override
    public String toString() {
        return "CharacterizedObject{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
