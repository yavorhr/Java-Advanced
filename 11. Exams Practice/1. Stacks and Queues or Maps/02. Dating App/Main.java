import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] malesInput = scanner.nextLine().split("\\s+");
        String[] femalesInput = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> maleStack = new ArrayDeque<>();
        ArrayDeque<Integer> femaleQueue = new ArrayDeque<>();

        int counter = 0;

        //fulfill queue of males
        for (int i = 0; i < malesInput.length; i++) {
            maleStack.push(Integer.parseInt(malesInput[i])); //add first
        }

        //fulfill stack of females
        for (int i = 0; i < femalesInput.length; i++) {
            femaleQueue.add(Integer.parseInt(femalesInput[i])); //add last
        }

        while (maleStack.size() > 0 && femaleQueue.size() > 0) {
            int male = maleStack.peek();
            int female = femaleQueue.peek();
            if (male > 0 && female > 0) {
                if (male % 25 == 0 || female % 25 == 0) {

                    if (male % 25 == 0) {
                        if (maleStack.size() > 1) {
                            maleStack.pop();
                            maleStack.pop();
                        } else {
                            maleStack.pop();
                        }
                    }

                    if (female % 25 == 0) {
                        if (femaleQueue.size() > 1) {
                            femaleQueue.remove();
                            femaleQueue.remove();
                        } else {
                            femaleQueue.remove();
                        }
                    }
                    continue;
                }
            }

            if (male <= 0 || female <= 0) {

                if (male <= 0) {
                    maleStack.pop(); //removes first
                }
                if (female <= 0) {
                    femaleQueue.remove(); //removes first
                }
                continue;
            }

            if (male == female) {
                counter++;
                maleStack.pop();
                femaleQueue.remove();
            } else {
                femaleQueue.remove();

                male -= 2;
                maleStack.pop();

                ArrayDeque<Integer> setQueue = new ArrayDeque<>();
                setQueue.add(male);
                for (int i = 0; i < maleStack.size(); i++) {
                    int current = maleStack.pop();
                    setQueue.add(current);
                    i--;
                }
                maleStack = setQueue;
            }
        }

        System.out.println("Matches: " + counter);

        if (maleStack.size() > 0) {
            System.out.print("Males left: ");

            for (int i = 0; i < maleStack.size(); i++) {
                if (i == maleStack.size() - 1) {
                    System.out.println(maleStack.pop());
                } else {
                    System.out.print(maleStack.pop() + ", ");
                    i--;
                }
            }
            System.out.println("Females left: none");

        } else if (maleStack.isEmpty() && femaleQueue.isEmpty()) {
            System.out.println("Males left: none");
            System.out.println("Females left: none");
        } else if (maleStack.isEmpty()) {
            System.out.println("Males left: none");


            System.out.print("Females left: ");

            for (int i = 0; i < femaleQueue.size(); i++) {
                if (i == femaleQueue.size() - 1) {
                    System.out.println(femaleQueue.remove());
                } else {
                    System.out.print(femaleQueue.remove() + ", ");
                    i--;
                }
            }
        }
    }
}
