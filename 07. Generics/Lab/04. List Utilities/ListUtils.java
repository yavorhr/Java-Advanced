import java.util.List;

public class ListUtils {
    public static <T extends Comparable<T>> T getMin(List<T> list) {
        return list.stream().min(Comparable::compareTo).orElseThrow(IllegalArgumentException::new);
    }
    public static <T extends Comparable<T>> T getMax(List<T> list) {
        return list.stream().max(Comparable::compareTo).orElseThrow(IllegalArgumentException::new);

    }
}
