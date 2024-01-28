import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {
    private String name;
    private List<Player> roster;
    private int capacity;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (this.capacity > this.roster.size()) {
            this.roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        return this.roster.removeIf(p -> p.getName().equals(name));
    }

    public void promotePlayer(String name) {
        Player player = findPlayerByName(name);
        try {
            if (!player.getRank().equals("Member")) {
                player.setRank("Member");
            }
        } catch (NullPointerException e) {
            System.out.print("Such player does not exist!");
        }
    }

    public void demotePlayer(String name) {
        Player player = findPlayerByName(name);
        try {
            if (!player.getRank().equals("Trial")) {
                player.setRank("Trial");
            }
        } catch (NullPointerException e) {
            System.out.print("Such player does not exist!");
        }
    }

    public Player[] kickPlayersByClass(String clazz) {

        Player[] players = this.roster
                .stream()
                .filter(p -> p.getClazz().equals(clazz))
                .collect(Collectors.toList())
                .toArray(Player[]::new);

        this.roster.removeIf(p -> p.getClazz().equals(clazz));

        return players;
    }

    public int count() {
        return this.roster.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder(String.format("Players in the guild: %s:\n", this.name));
        this.roster.forEach(p -> sb.append(p).append(System.lineSeparator()));
        return sb.toString().trim();
    }

    private Player findPlayerByName(String name) {
        return roster.stream().filter(p -> p.getName().equals(name)).collect(Collectors.toList()).get(0);
    }
}
