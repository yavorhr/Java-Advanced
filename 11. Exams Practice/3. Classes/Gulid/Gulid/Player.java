public class Player {
    private String name;
    private String clazz;
    private String rank;
    private String description;

    public Player(String name, String clazz) {
        this.name = name;
        this.clazz = clazz;
        this.rank = "Trial";
        this.description = "n/a";
    }

    public String getName() {
        return name;
    }

    public String getClazz() {
        return clazz;
    }

    public String getRank() {
        return rank;
    }

    public Player setRank(String rank) {
        this.rank = rank;
        return this;
    }

    public Player setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return String.format("Player %s:\n%s Rank: %s\nDescription: %s" , this.name, this.clazz, this.rank, this.description);
    }
}
