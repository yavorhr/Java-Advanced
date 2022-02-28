import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] stonesNumbers = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        Lake lake = new Lake(stonesNumbers);

        StringBuilder sb = new StringBuilder();

        for (Integer integer : lake) {
            sb.append(integer).append(", ");
        }
        System.out.println(sb.toString().substring(0, sb.toString().lastIndexOf(", ")));
    }
}


