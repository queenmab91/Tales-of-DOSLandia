public class Weapon {

    private String name;
    private String description;

    private int damage;

    protected boolean isDrawn;

    public Weapon (String name, String description, int damage) {
        this.name = name;
        this.description = description;
        this.damage = damage;
        isDrawn = false;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getDamage() {
        return damage;
    }
}
