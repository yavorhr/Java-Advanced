import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> playerCards = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("JOKER")) {
            String[] tokens = input.split(": ");
            String name = tokens[0];
            String[] deckArray = tokens[1].split(", ");

            Set<String> newDeck = new HashSet<>(Arrays.asList(deckArray));

            playerCards.putIfAbsent(name, new HashSet<>());
            if (playerCards.containsKey(name)) {
                Set<String> currentDeck = playerCards.get(name);
                newDeck.addAll(currentDeck);
                playerCards.put(name, newDeck);
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, Set<String>> player : playerCards.entrySet()) {
            int points = calculatePoints(player.getValue());
            System.out.printf("%s: %d\n", player.getKey(), points);
        }

    }

    private static int calculatePoints(Set<String> cards) {
        int sum = 0;

        HashMap<Character, Integer> powers = getLettersPower();

        for (String card : cards) {
            if (card.contains("10")) {
                sum += 10 * powers.get(card.charAt(2));
                continue;
            }

            char first = card.charAt(0); //2
            char second = card.charAt(1); //C

            sum += powers.get(first) * powers.get(second);
        }

        return sum;
    }

    private static HashMap<Character, Integer> getLettersPower(){
        HashMap<Character, Integer> powers = new HashMap<>();
        powers.put('1', 1);
        powers.put('2', 2);
        powers.put('3', 3);
        powers.put('4', 4);
        powers.put('5', 5);
        powers.put('6', 6);
        powers.put('7', 7);
        powers.put('8', 8);
        powers.put('9', 9);
        powers.put('J', 11);
        powers.put('Q', 12);
        powers.put('K', 13);
        powers.put('A', 14);
        powers.put('S', 4);
        powers.put('H', 3);
        powers.put('D', 2);
        powers.put('C', 1);

        return powers;
    }
}
