import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] roboData = scanner.nextLine().split(";");

        String[] robots = new String[roboData.length];
        int[] workingTime = new int[roboData.length];
        int[] processTime = new int[roboData.length];

        for (int i = 0; i < roboData.length; i++) {
            robots[i] = roboData[i].split("-")[0];
            workingTime[i] = Integer.parseInt(roboData[i].split("-")[1]);
        }

        String[] timeAsString = scanner.nextLine().split(":");

        int hours = Integer.parseInt(timeAsString[0]);
        int minutes = Integer.parseInt(timeAsString[1]);
        int seconds = Integer.parseInt(timeAsString[2]);

        int startTime = hours * 3600 + minutes * 60 + seconds;
        int time = 0;

        ArrayDeque<String> products = new ArrayDeque<>();

        String currentProducts = scanner.nextLine();
        while (!"End".equals(currentProducts)) {
            products.offer(currentProducts);
            currentProducts = scanner.nextLine();
        }

        while (!products.isEmpty()) {
            time++;
            String product = products.poll();
            boolean isAssigned = false;
            for (int i = 0; i < robots.length; i++) {
                if (processTime[i] == 0 && !isAssigned) {
                    processTime[i] = workingTime[i];
                    printTask(robots[i], startTime + time, product);
                    isAssigned = true;
                }
                if (processTime[i] > 0) {
                    processTime[i]--;
                }
            }

            if (!isAssigned) {
                products.offer(product);
            }
        }
    }

    private static void printTask(String robot, int time, String product) {
        int hours = time / 3600 % 24;
        int minutes = time % 3600 / 60;
        int seconds = time % 60;

        DecimalFormat formatTime = new DecimalFormat("00");
        System.out.println(String.format("%s - %s [%s:%s:%s]", robot, product,
                formatTime.format(hours), formatTime.format(minutes), formatTime.format(seconds)));
    }
}







