import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashSet<String> parkingLot = new LinkedHashSet<>();

        while (!"END".equals(input)) {
            String[] tokens = input.split(", ");
            String direction = tokens[0];
            String licenseNumber = tokens[1];

            if (direction.equals("IN")) {
                parkingLot.add(licenseNumber);
            } else if (direction.equals("OUT")) {
                parkingLot.remove(licenseNumber);
            }

            input = scanner.nextLine();
        }


        String result = String.join(System.lineSeparator(), parkingLot);
        printResult(parkingLot,result);
    }
    private static void printResult(HashSet<String> parkingLot, String result) {
        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            System.out.println(result);
        }

    }
}









