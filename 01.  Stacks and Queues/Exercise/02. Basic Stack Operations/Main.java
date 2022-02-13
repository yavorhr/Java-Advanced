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


        ArrayDeque<Integer> stackNumbers = new ArrayDeque<>();
        // n - > add (push)
        for (int i = 0; i < n; i++) {
            stackNumbers.push(Integer.parseInt(secondLineData[i]));
        }

        // s -> remove (pop)
        for (int i = 0; i < s; i++) {
            stackNumbers.pop();
        }

        //always check if stack isEmpty
        if (stackNumbers.isEmpty()) {
            System.out.println(0);
        } else {
            if (stackNumbers.contains(x)) {
                System.out.println("true");
            } else {
                //find min element using API -> System.out.println(stackNumbers.stream().mapToInt(e->e).min().getAsInt());
                //find min element using Collections -> Collections.min(stackNumbers);
                //algorithm for minElement
                System.out.println(getMinElement(stackNumbers));
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


