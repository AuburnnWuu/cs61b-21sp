package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

//    @Deprecated
//    public int findHead() {
//        if (nextFirst + 1 == items.length) {
//            return 0;
//        } else {
//            return nextFirst + 1;
//        }
//    }

    // ** important **
    // get relative position of "First" with any given index
    private int arrayIndex(int index) {
        if (nextFirst + 1 + index >= items.length) {
            return nextFirst + 1 + index - items.length;
        } else {
            return nextFirst + 1 + index;
        }
    }

    private void resize(int capacity) {
        T[] temp = (T[]) new Object[capacity];
//        if(nextFirst < nextLast){
//            System.arraycopy(items,0,temp, temp.length / 4,-1);
//        }else{
//            int sizeToEnd = items.length - nextFirst - 1;
//            System.arraycopy(items, findHead(), temp, temp.length / 4, sizeToEnd);
//            System.arraycopy(items, 0, temp, temp.length / 4 + sizeToEnd, nextLast);
//        }
        int ind = 0;
        for (int i = 0; i < size; i++) {
            ind = arrayIndex(i);
            temp[capacity / 4 + i] = items[ind];
        }
        items = temp;
        nextFirst = capacity / 4 - 1;
        nextLast = nextFirst + size + 1;
    }

    public void addFirst(T item) {
        if (size == items.length - 2) {
            resize(items.length * 2);
        }
        items[nextFirst] = item;
        size += 1;
        if (nextFirst == 0) {
            nextFirst = items.length - 1;
        } else {
            nextFirst -= 1;
        }
    }

    public void addLast(T item) {
        if (size == items.length - 2) {
            resize(items.length * 2);
        }
        items[nextLast] = item;
        size += 1;
        if (nextLast + 1 == items.length) {
            nextLast = 0;
        } else {
            nextLast += 1;
        }
    }

    public int size() {
        return size;
    }

    private T getFirst() {
        return items[arrayIndex(0)];
    }

    private T getLast() {
        return items[arrayIndex(size - 1)];
    }

    public T get(int index) {
        return items[arrayIndex(index)];
    }

    public T removeFirst() {
        if (getFirst() == null) {
            return null;
        }
        T first = getFirst();
        items[arrayIndex(0)] = null;
        size -= 1;
        nextFirst = arrayIndex(0);
        return first;
    }

    public T removeLast() {
        if (getLast() == null) {
            return null;
        }
        T last = getLast();
        items[arrayIndex(size - 1)] = null;
        size -= 1;
        nextLast = arrayIndex(size - 1);
        return last;
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[arrayIndex(i)] + " ");
        }
        System.out.println();
    }


    /**
     * Iterator
     */
    private class ArrayDequeIterator implements Iterator<T> {
        private int pointerPos;

        public ArrayDequeIterator() {
            pointerPos = 0;
        }

        @Override
        public boolean hasNext() {
            return pointerPos < size;
        }

        @Override
        public T next() {
            T item = get(pointerPos);
            pointerPos++;
            return item;
        }
    }

    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (o == this)
            return true;
        if (!(o instanceof Deque))
            return false;
        Deque<T> oc = (Deque<T>) o;
        if (!(oc.size() == this.size))
            return false;
        for (int i = 0; i < size; i++) {
            if (!(this.get(i).equals(oc.get(i))))
                return false;
        }
        return true;
    }

}
