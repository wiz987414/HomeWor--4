import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class CollectionUtils<T> implements Comparable<T> {

    static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    static <T> List<T> newArrayList() {
        return new ArrayList<>();
    }

    static <T> int indexOf(List<? extends T> source, T item) {
        int index = -1;
        if (item != null && source.contains(item))
            index = source.indexOf(item);
        return index;
    }

    static <T> List<T> limit(List<T> source, int size) {
        List<T> outList = new ArrayList<>();
        if (size > 0)
            outList = source.subList(0, size);
        return outList;
    }

    static <T> void add(List<? super T> source, T newItem) {
        source.add(newItem);
    }

    static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        for (T element : c2) {
            if (removeFrom.contains(element))
                removeFrom.remove(element);
        }
    }

    static <T> boolean containsAll(List<? extends T> c1, List<? extends T> c2) {
        return  c1.containsAll(c2);
    }

    static <T> boolean containsAny(List<? extends T> c1, List<? extends T> c2) {
        for (T element : c2)
            if (c1.contains(element))
                return true;
        return false;
    }

    static <T extends Comparable<? super T>> List<T> range(List<? extends T> list, T min, T max) {
        List<T> outList = new ArrayList<>();
        Collections.sort(list);
        boolean isSequence = false;
        for (T element : list) {
            if (element == min) {
                isSequence = true;
            } else if (element == max) {
                outList.add(element);
                isSequence = false;
            }
            if (isSequence)
                outList.add(element);
        }
        return outList;
    }

    static <T extends Comparable<? super T>> List<T> range(List<? extends T> list, T min, T max, Comparator<? super T> comparator) {
        List<T> outList = new ArrayList<>();
        list.sort(comparator);
        boolean isSequence = false;
        for (T element : list) {
            if (element == min) {
                isSequence = true;
            } else if (element == max) {
                outList.add(element);
                isSequence = false;
            }
            if (isSequence)
                outList.add(element);
        }
        return outList;
    }

    @Override
    public int compareTo(T o) {
        return (this.hashCode() == (o.hashCode()) ? 0 : (this.hashCode() < o.hashCode() ? -1 : 1));
    }
}
