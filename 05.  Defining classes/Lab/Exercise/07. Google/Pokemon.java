public class Pokemon {
    private String name;
    private String type;

    public Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Pokemon setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public Pokemon setType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s %s", getName(),getType());
    }
}
