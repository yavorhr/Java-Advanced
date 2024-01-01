import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Engine> enginesMap = new HashMap<>();
        List<Car> carsList = new LinkedList<>();

        int n = readCount(scanner);

        while (n > 0) {
            String[] tokens = scanner.nextLine().split(" ");
            String engineModel = tokens[0];

            Engine engine = getEngine(tokens);
            enginesMap.put(engineModel, engine);

            n--;
        }

        int m = readCount(scanner);
        while (m > 0) {
            String[] tokens = scanner.nextLine().split(" ");
            String modelEngine = tokens[1];

            Engine engine = enginesMap.get(modelEngine);
            Car car = getCar(engine, tokens);
            carsList.add(car);

            m--;
        }

        carsList.forEach(System.out::println);
    }

    private static Car getCar(Engine engine, String[] tokens) {
        Car car = null;
        String model = tokens[0];

        if (engine != null) {
            if (tokens.length == 2) {
                car = new Car(model, engine);
            } else if (tokens.length == 3) {
                try {
                    int weight = Integer.parseInt(tokens[2]);
                    car = new Car(model, engine, weight);
                } catch (NumberFormatException e) {
                    String color = tokens[2];
                    car = new Car(model, engine, color);
                }

            } else if (tokens.length == 4) {
                int weight = Integer.parseInt(tokens[2]);
                String color = tokens[3];
                car = new Car(model, engine, weight, color);
            }
        }
        return car;
    }


    private static int readCount(Scanner scanner) {
        int n = scanner.nextInt();
        scanner.nextLine();
        return n;
    }

    private static Engine getEngine(String[] tokens) {

        String model = tokens[0];
        int power = Integer.parseInt(tokens[1]);

        Engine engine = null;

        if (tokens.length == 2) {
            engine = new Engine(model, power);
        } else if (tokens.length == 3) {
            try {
                int displacement = Integer.parseInt(tokens[2]);
                engine = new Engine(model, power, displacement);
            } catch (NumberFormatException e){
                String efficiency = tokens[2];
                engine = new Engine(model, power, efficiency);
            }
        } else if (tokens.length == 4) {
            int displacement = Integer.parseInt(tokens[2]);
            String efficiency = tokens[3];
            engine = new Engine(model, power, displacement, efficiency);
        }

        return engine;
    }
}


