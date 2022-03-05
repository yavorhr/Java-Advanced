
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

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Player %s: %s%n", this.name, this.clazz));
        result.append(String.format("Rank: %s%n", this.rank));
        result.append(String.format("Description: %s", this.description));
        return result.toString().trim();
    }

    public void setDescription(String discription) {
        this.description = discription;
    }
}
