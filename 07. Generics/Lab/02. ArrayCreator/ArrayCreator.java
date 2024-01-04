import java.lang.reflect.Array;

public class ArrayCreator<T> {

    public ArrayCreator() {
    }

    public static <T> T[] create(int length, T item) {
        Object arr = Array.newInstance(item.getClass(), length);

        return (T[]) arr;
    }
}
