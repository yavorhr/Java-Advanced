import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> integersList = List.of(130, 14, 5123, 321);
        List<String> stringsList = List.of("z", "d", "c", "y");

        Integer minInt = ListUtils.getMin(integersList);
        String mintStr = ListUtils.getMin(stringsList);

        System.out.println(minInt);
        System.out.println(mintStr);

    }
}

