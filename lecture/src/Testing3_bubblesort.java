import jdk.nashorn.internal.ir.debug.NashornTextifier;

import java.lang.reflect.Array;

public class Testing3_bubblesort {

    public static void main(String[] args) {
        int[] o = {8,7,6,5,4,3,2,1};
        int[] o1 = {1,2,3,4,5,6};
        int[] o2 = {1,2,3,4,7,6};
        int[] ints = bubbleSort(o2);
        for(int i = 0; i < ints.length; i++){
            System.out.println(ints[i]);
        }
    }

    public static int[] bubbleSort(int[] origin){
        int temp = 0;
        boolean exe = true;
        for(int i = 0; i < origin.length - 1; i++){
            for(int j = 0; j < origin.length - 1 - i; j++){
                if(origin[j] > origin[j + 1]){
                    temp = origin[j];
                    origin[j] = origin[j + 1];
                    origin[j + 1] = temp;
                    exe = false;
                }
            }
            if(exe){
                break;
            }
        }
        return origin;
    }

}
