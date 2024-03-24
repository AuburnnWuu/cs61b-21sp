import com.sun.org.apache.xerces.internal.util.EntityResolverWrapper;

public class IntList {

    // How to return the size of a list?

    private int first;
    private IntList rest;

    public IntList(int first, IntList rest) {
        this.first = first;
        this.rest = rest;
    }

    // Return size with no recursion
    public int iterativeSize(IntList p){
        int totalSize = 0;
        while(p != null){
            totalSize += 1;
            p = p.rest;
        }
        return totalSize;
    }

    // Return size with recuision
    public int iterativeSizeWithRecursion(IntList p){
        if(p.rest == null){
            return 1;
        }
        return 1 + iterativeSizeWithRecursion(p.rest);
    }

    // How can i get the value of list by index?
    // With recursion
    public int getValuebyIndWithRecur(IntList p, int index){
        if(index == 0){
            return p.first;
        }
        return getValuebyIndWithRecur(p.rest, index - 1);
    }

    // Without Recuision
    public int getValueByIndWithoutRecuision(IntList p, int index){
        for(;index != 0; index--){
            p = p.rest;
        }
        return p.first;
    }



    public static void main(String[] args) {
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);
        L = new IntList(1, L);

        System.out.println(L.iterativeSize(L));
        System.out.println(L.iterativeSizeWithRecursion(L));
        System.out.println(L.getValuebyIndWithRecur(L, 3));
        System.out.println(L.getValueByIndWithoutRecuision(L, 3));
    }

}
