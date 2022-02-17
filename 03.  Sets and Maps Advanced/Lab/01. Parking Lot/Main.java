import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashSet<String> parkingLot = new LinkedHashSet<>();

        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String[] token = input.split(", ");
            String direction = token[0];
            String carNumber = token[1];

            if (direction.equals("IN")) {
                parkingLot.add(carNumber);
            } else {
                parkingLot.remove(carNumber);
            }
            input = scanner.nextLine();
        }

        for (String car : parkingLot) {
            System.out.println(car);
        }

        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        }
    }
}











