import java.util.List;

public class Pokemon {
    private String name;
    private String element;
    private int health;

    public Pokemon(String name, int health, String element) {
        this.name = name;
        this.health = health;
        this.element = element;
    }

    public String getName() {
        return name;
    }

    public Pokemon setName(String name) {
        this.name = name;
        return this;
    }

    public int getHealth() {
        return health;
    }

    public Pokemon setHealth(int health) {
        this.health = health;
        return this;
    }

    public String getElement() {
        return element;
    }

    public Pokemon setElement(String element) {
        this.element = element;
        return this;
    }

    public void takeDamage(int damage){
        this.health -= damage;
    }
}
