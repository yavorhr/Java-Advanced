import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstLineData = scanner.nextLine().split("\\s+"); //n, s, x
        String[] secondLineData = scanner.nextLine().split("\\s+");

        int n = Integer.parseInt(firstLineData[0]);
        int s = Integer.parseInt(firstLineData[1]);
        int x = Integer.parseInt(firstLineData[2]);


        ArrayDeque<Integer> queueNumbers = new ArrayDeque<>();
        // n - > add (push)
        for (int i = 0; i < n; i++) {
            queueNumbers.offer(Integer.parseInt(secondLineData[i]));
        }

        // s -> remove (pop)
        for (int i = 0; i < s; i++) {
            queueNumbers.poll();
        }

        //always check if stack isEmpty
        if (queueNumbers.isEmpty()) {
            System.out.println(0);
        } else {
            if (queueNumbers.contains(x)) {
                System.out.println("true");
            } else {
                //find min element using API -> System.out.println(queueNumbers.stream().mapToInt(e->e).min().getAsInt());
                //find min element using Collections -> Collections.min(queueNumbers);
                //algorithm for minElement
                System.out.println(getMinElement(queueNumbers));

            }
        }
    }

    private static int getMinElement(ArrayDeque<Integer> stackNumbers) {
        int min = Integer.MAX_VALUE;
        for (int number : stackNumbers) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }
}






