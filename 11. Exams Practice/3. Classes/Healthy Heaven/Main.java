import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//// Initialize the repository
//        Restaurant restaurant = new Restaurant("Casa Domingo");

// Initialize the entities
        Vegetable tomato = new Vegetable("Tomato", 20);
        Vegetable cucumber = new Vegetable("Cucumber", 15);

        Salad salad = new Salad("Tomatoes with cucumbers");

        salad.add(tomato);
        salad.add(cucumber);

        System.out.println(salad.getTotalCalories()); // 35
        System.out.println(salad.getProductCount());  // 2

        System.out.println(salad.toString());
// * Salad Tomatoes with cucumbers is 35 calories and have 2 products:
//  - Tomato have 20 calories
//  - Cucumber have 15 calories

    }
}




