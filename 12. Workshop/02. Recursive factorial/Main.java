public class Main {
    public static void main(String[] args) {

        int number = 5;
        System.out.println(fact(5));
    }

    public static int fact(int num) {
        if (num == 1) {
            return 1;
        }

        return num * fact(num - 1);
        //5 * fact(5-1)
        //4 * fact(4-1)
        //3 * fact(3-1)
        //2 * fact (2-1)
        //num == 1
    }
}
