package Pockemon;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Trainer> trainers = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"Tournament".equals(input)) {
            String[] tokens = input.split("\\s+");

            String trainerName = tokens[0];
            String pokemon = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            Trainer trainer = new Trainer(trainerName);
            Pokemon caughtPokemon = new Pokemon(pokemon, pokemonElement, pokemonHealth);

            trainers.putIfAbsent(trainerName, trainer);
            trainers.get(trainerName).addPokemon(caughtPokemon);

            input = scanner.nextLine();
        }
        input = scanner.nextLine();

        while (!input.equals("End")) {
            String element = input;
            for (Trainer trainer : trainers.values()) {
                if (trainer.hasElementType(element)){
                    trainer.increaseBadges(1);
                } else {
                    trainer.damagePokemons(10);
                }
            };
            input = scanner.nextLine();
        }

        trainers.entrySet().stream().sorted((f,s) ->
            s.getValue().getBadges() - f.getValue().getBadges()
        ).forEach(entry->{
            System.out.println(entry.getValue().toString());
        });
    }
}



