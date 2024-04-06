package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();

        correct.addLast(5);
        correct.addLast(10);
        correct.addLast(15);

        broken.addLast(5);
        broken.addLast(10);
        broken.addLast(15);

        assertEquals(correct.size(), broken.size());

        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
    }

    @Test
    public void randomizedFunctionCalls() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> Lb = new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                Lb.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int sizeLb = Lb.size();
                System.out.println("size: " + size + "sizeLb:" + sizeLb);
            } else if(operationNumber == 2 && L.size() > 0){
                System.out.println(L.getLast());
                System.out.println(Lb.getLast());
            }else if(operationNumber == 3 && L.size() > 0){
                int Lremove = L.removeLast();
                int Lbr = Lb.removeLast();
                System.out.println("Lr:" + Lremove + "Lbr" + Lbr);
            }

        }
    }


}
