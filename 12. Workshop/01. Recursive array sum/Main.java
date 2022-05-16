public class Main {
    public static void main(String[] args) {

        int[] arr = {13, 42, 69, 73};

        System.out.println(sumOfArray(arr,0));
    }

    public static int sumOfArray(int[] arr, int index) {
        if (index == arr.length - 1) {
            return arr[index];
        }
        return arr[index] + sumOfArray(arr, index + 1);
    }
}

