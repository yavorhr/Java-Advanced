import java.util.ArrayDeque;

public class Jar <T>{
    private ArrayDeque<T> jarStack;

    public Jar() {
        this.jarStack = new ArrayDeque<>();
    }

    public void add(T element){
        this.jarStack.push(element);
    }

    public void remove() {
        this.jarStack.pop();
    }

    public ArrayDeque<T> getJarStack() {
        return jarStack;
    }

    public Jar<T> setJarStack(ArrayDeque<T> jarStack) {
        this.jarStack = jarStack;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s", getDeck(getJarStack()));
    }

    private String getDeck(ArrayDeque<T> jarStack) {
        StringBuilder sb = new StringBuilder();

        jarStack.forEach(e -> sb.append(e.toString()).append(" "));

        return sb.toString();
    }
}
