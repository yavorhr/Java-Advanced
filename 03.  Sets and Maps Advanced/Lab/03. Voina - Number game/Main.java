import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstDeck = mapInputToSet(scanner);
        Set<Integer> secondDeck = mapInputToSet(scanner);

        int maxRounds = 50;
        while (maxRounds > 0 && !firstDeck.isEmpty() && !secondDeck.isEmpty()) {
            int firstCard = firstDeck.iterator().next();
            int secondCard = secondDeck.iterator().next();

            removeTopCards(firstDeck, secondDeck, firstCard, secondCard);

            addCardsToWinningDeck(firstCard, secondCard, firstDeck, secondDeck);

            maxRounds--;
        }

        printResult(firstDeck, secondDeck);
    }

    private static void printResult(Set<Integer> firstDeck, Set<Integer> secondDeck) {
        if (firstDeck.size() > secondDeck.size()) {
            System.out.println("First player win!");
        } else if (secondDeck.size() > firstDeck.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }

    private static void removeTopCards(Set<Integer> firstDeck, Set<Integer> secondDeck, int firstCard, int secondCard) {
        firstDeck.remove(firstCard);
        secondDeck.remove(secondCard);
    }

    private static LinkedHashSet<Integer> mapInputToSet(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));
    }

    private static void addCardsToWinningDeck(int firstCard, int secondCard, Set<Integer> firstDeck, Set<Integer> secondDeck) {
        if (firstCard > secondCard) {
            firstDeck.add(firstCard);
            firstDeck.add(secondCard);
        } else if (secondCard > firstCard) {
            secondDeck.add(firstCard);
            secondDeck.add(secondCard);
        }
    }

}









