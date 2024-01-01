import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int badges;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.badges = 0;
        this.pokemons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Trainer setName(String name) {
        this.name = name;
        return this;
    }

    public int getBadges() {
        return badges;
    }

    public Trainer setBadges(int badges) {
        this.badges = badges;
        return this;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public Trainer setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
        return this;
    }

    public boolean hasElement(String element) {
        return this.pokemons.stream().anyMatch(p -> p.getElement().equals(element));
    }

    public void increaseBadges(int incrementAmount) {
        this.badges += incrementAmount;
    }

    public void damagePokemons(int damage) {
        this.pokemons.forEach(p -> p.takeDamage(damage));
        this.clearDeadPokemons();
    }

    private void clearDeadPokemons() {
        getPokemons().removeIf(p -> p.getHealth() <= 0);
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", getName(), getBadges(), getPokemons().size());
    }
}
