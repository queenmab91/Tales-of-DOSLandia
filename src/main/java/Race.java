public class Race {
    private String name;
    private String description;

    private String transformationMessage;
    private int baseDamage;

    private int baseHealth;

    private int baseSpeed;

    public Race (String name, String description, int baseHealth, int baseDamage, int baseSpeed, String transformationMessage){
        this.name = name;
        this.description = description;
        this.baseDamage = baseDamage;
        this.baseHealth = baseHealth;
        this.baseSpeed = baseSpeed;
        this.transformationMessage = transformationMessage;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getTransformationMessage() {
        return transformationMessage;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public int getBaseHealth() {
        return baseHealth;
    }

    public int getBaseSpeed() {
        return baseSpeed;
    }
}
