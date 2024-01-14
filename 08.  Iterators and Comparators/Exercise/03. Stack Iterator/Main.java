import java.util.*;

public class Main {
    public static void main(String[] args) {

        Stack stack = new Stack();
        stack.push(32);
        stack.push(50);
        stack.push(69);
        stack.push(99);

        Iterator<Integer> iterator = stack.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());;
        }

    }
}



