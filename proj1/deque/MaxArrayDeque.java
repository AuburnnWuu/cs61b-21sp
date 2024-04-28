package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> cmp;

    public MaxArrayDeque(Comparator<T> cmp) {
        this.cmp = cmp;
    }

    public T max() {
        if (isEmpty())
            return null;
        T maxItem = this.get(0);
        for (T i : this) {
            if (cmp.compare(i, maxItem) > 0)
                maxItem = i;
        }
        return maxItem;
    }

    public T max(Comparator<T> c) {
        if (isEmpty())
            return null;
        T maxItem = this.get(0);
        for (T i : this) {
            if (c.compare(i, maxItem) > 0)
                maxItem = i;
        }
        return maxItem;
    }


}
