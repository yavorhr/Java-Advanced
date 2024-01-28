public class Rabbit {
    private String name;
    private String species;
    private boolean available;

    public Rabbit(String name, String species) {
        this.name = name;
        this.species = species;
        this.available = true;
    }

    public String getName() {
        return name;
    }

    public Rabbit setName(String name) {
        this.name = name;
        return this;
    }

    public String getSpecies() {
        return species;
    }

    public Rabbit setSpecies(String species) {
        this.species = species;
        return this;
    }

    public boolean isAvailable() {
        return available;
    }

    public Rabbit setAvailable(boolean available) {
        this.available = available;
        return this;
    }

    @Override
    public String toString() {
        return String.format("Rabbit (%s): %s",this.species, this.name);
    }
}
