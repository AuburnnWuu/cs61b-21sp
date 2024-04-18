package deque;

public class LinkedListDeque<T> implements Deque<T>{

    private class StuffNode{
        public T item;
        public StuffNode next;
        public StuffNode prev;

        public StuffNode(T i, StuffNode n){
            item = i;
            next = n;
        }
    }

    private StuffNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new StuffNode(null, null);
        size = 0;
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public void addFirst(T item){
        /**
         * We dont have to give a name to the new node we wanna insert.
         * It will become the new node naturally be new "firstNode"
         */
        StuffNode firstNode = sentinel.next;
        firstNode.prev = new StuffNode(item, firstNode);
        sentinel.next = firstNode.prev;
        firstNode.prev.prev = sentinel;
        size += 1;
    }

    public void addLast(T item){
        StuffNode lastNode = sentinel.prev;
        lastNode.next = new StuffNode(item, sentinel);
        sentinel.prev = lastNode.next;
        sentinel.prev.prev = lastNode;
        size += 1;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        int cnt = size;
        StuffNode p = sentinel.next;
        for (; cnt > 0; cnt--){
            System.out.println(p.item);
            p = p.next;
        }
        System.out.println();
    }

    public T removeFirst(){
        if(isEmpty()){
            return null;
        }
        StuffNode firstNode = sentinel.next;
        sentinel.next = firstNode.next;
        firstNode.next.prev = sentinel;
        firstNode.prev = null;
        firstNode.next = null;
        size -= 1;
        return firstNode.item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        StuffNode lastNode = sentinel.prev;
        lastNode.prev.next = sentinel;
        sentinel.prev = lastNode.prev;
        lastNode.next = null;
        lastNode.prev = null;
        size -= 1;
        return lastNode.item;
    }

    public T get(int index){
        if(index >= size || index < 0){
            return null;
        }
        StuffNode p = sentinel.next;
        while(index > 0){
            p = p.next;
            index--;
        }
        return p.item;
    }

    private T getRecursivePri(int index, StuffNode p){
        if(index == 0){
            return p.item;
        }
        p = p.next;
        index--;
        return getRecursivePri(index, p);
    }

    public T getRecursive(int index){
        if(index >= size || index < 0){
            return null;
        }
        StuffNode p = sentinel.next;
        return getRecursivePri(index, p);
    }
    
    public static void main(String[] args) {
        LinkedListDeque<Object> objectLinkedListDeque = new LinkedListDeque<>();
        objectLinkedListDeque.addFirst(5);
        objectLinkedListDeque.addFirst(4);
        objectLinkedListDeque.addFirst(3);
        objectLinkedListDeque.addFirst(2);
        objectLinkedListDeque.addFirst(1);
        System.out.println(objectLinkedListDeque.getRecursive(4));
        int[] ints = new int[8];
        int[] intasd = new int[]{1,2,3,4,5,6,7};
        System.arraycopy(intasd,0,ints,0,0);
        if (ints[1] == 0){
            System.out.println("num");
        }
        System.out.println(ints[1]);
    }

}
