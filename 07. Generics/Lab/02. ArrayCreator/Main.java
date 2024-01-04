
public class Main {
    public static void main(String[] args) {

        Integer[] integers = ArrayCreator.create(3, 3);
        String[] strings = ArrayCreator.create(5, "abc");

        for (Integer n: integers) {
            System.out.print(n + " ");
        }

    }
}

