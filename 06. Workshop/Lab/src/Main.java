public class Main {
    public static void main(String[] args) {

        SmartArray smartArray = new SmartArray();
//
////        Test add method
////        long start = System.currentTimeMillis();
////        for (int i = 0; i < 1000000; i++) {
////            smartArray.add(i);
////        }
////        long end = System.currentTimeMillis();
////        System.out.println(end-start);
//
////        smartArray.add(13);
////        smartArray.add(69);
////        smartArray.add(42);
////        smartArray.add(63);
////        smartArray.add(173);
//
////      Test add method
////      System.out.println(smartArray.get(0));
//
////      Test remove method
////      System.out.println(smartArray.remove(1));
//
////      Test add at index method
////      smartArray.add(0,1);
//
////      Test forEach
////      smartArray.forEach(System.out::println);
//
//        System.out.println();

//        //test push()

        Stack stack = new Stack();

        for (int i = 0; i < 10; i++) {
            stack.push(i + 1);
        }

        //test forEach()
        stack.forEach(System.out::println);

        //test peak()
        System.out.println(stack.pop());

        //test pop()
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
        System.out.println();
    }
}
