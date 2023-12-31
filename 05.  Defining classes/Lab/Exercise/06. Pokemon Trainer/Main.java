import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Trainer> trainersMap = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"Tournament".equals(input)) {
            String[] tokens = input.split(" ");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonHealth, pokemonElement);
            addTrainerToMap(trainersMap, trainerName, pokemon);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!"End".equals(input)) {
            String element = input;

            for (Trainer trainer : trainersMap.values()) {
                if (trainer.hasElement(element)) {
                    trainer.increaseBadges(1);
                } else {
                    trainer.damagePokemons(10);
                }
            }
            input = scanner.nextLine();
        }
        printResult(trainersMap);
    }

    private static void addTrainerToMap(Map<String, Trainer> trainersMap, String trainerName, Pokemon pokemon) {
        trainersMap.putIfAbsent(trainerName, new Trainer(trainerName));
        Trainer trainer = trainersMap.get(trainerName);
        trainer.getPokemons().add(pokemon);

        trainersMap.put(trainerName, trainer);
    }

    private static void printResult(Map<String, Trainer> trainersMap) {
        trainersMap.values().stream().sorted((t1, t2) -> t2.getBadges() - t1.getBadges()).forEach(System.out::println);
    }
}


