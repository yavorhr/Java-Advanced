import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> printerQueue = new ArrayDeque<>();

        String command = scanner.nextLine();
        while (!"print".equals(command)) {
            if (command.equals("cancel")) {
                if (!printerQueue.isEmpty()) {
                    System.out.printf("Canceled %s\n", printerQueue.poll());
                } else {
                    System.out.println("Printer is on standby");
                }
            } else {
                printerQueue.offer(command);
            }

            command = scanner.nextLine();
        }

        printCommands(printerQueue);
    }

    private static void printCommands(ArrayDeque<String> printerQueue) {
        while (!printerQueue.isEmpty()){
            System.out.println(printerQueue.poll());
        }
    }
}


