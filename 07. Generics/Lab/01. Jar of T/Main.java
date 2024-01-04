
public class Main {
    public static void main(String[] args) {

        Pickle bulgarianPickle = new Pickle("bulgarian");
        Pickle americanPickle = new Pickle("american");

        Jar<Pickle> jarOfPickles = new Jar<>();
        jarOfPickles.add(bulgarianPickle);
        jarOfPickles.add(americanPickle);

        int num = 1;
        int secondNum = 2;

        Jar<Integer> integerJar = new Jar<>();

        integerJar.add(num);
        integerJar.add(secondNum);

        System.out.println(jarOfPickles.toString());
    }
}

