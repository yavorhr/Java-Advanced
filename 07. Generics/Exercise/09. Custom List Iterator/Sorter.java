public class Sorter {

    public static <T extends Comparable<T>> void sort(CustomList<T> customList) {
        for (int i = 0; i < customList.getSize() - 1; i++) {
            T prevElement = customList.get(i);
            for (int j = i + 1; j < customList.getSize(); j++) {
                T nextElement = customList.get(j);

                if (prevElement.compareTo(nextElement) > 0) {
                    customList.swap(i,j);
                }
            }
        }
    }
}
