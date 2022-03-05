import java.util.ArrayList;
import java.util.List;

public class Guild {
    private List<Player> roster;
    private String name;
    private int capacity;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (this.roster.size() < this.capacity) {
            this.roster.add(player);
        }
    }

    public int count() {
        return this.roster.size();
    }

    public boolean removePlayer(String name) {
        for (Player player : this.roster) {
            if (player.getName().equals(name)) {
                roster.remove(player);
                return true;
            }
        }
        return false;
    }

    public void promotePlayer(String player) {
        for (Player currentPlayer : roster) {
            if (currentPlayer.getName().equals(player)) {
                currentPlayer.setRank("Member");
                break;
            }
        }
    }

    public void demotePlayer(String player) {
        for (Player currentPlayer : roster) {
            if (currentPlayer.getName().equals(player)) {
                currentPlayer.setRank("Trial");
                break;
            }
        }
    }

    public Player[] kickPlayersByClass(String givenClass) {
        Player[] players = this.roster.stream().filter(p -> p.getClazz().equals(givenClass)).toArray(Player[]::new);

        this.roster.removeIf(player -> player.getClazz().equals(givenClass));

        return players;


    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Players in the guild: ")
                .append(this.name).append(":")
                .append(System.lineSeparator());

        for (Player player : roster) {
           sb.append(player.toString())
            .append(System.lineSeparator());
        }
     return sb.toString().trim();
    }

}


