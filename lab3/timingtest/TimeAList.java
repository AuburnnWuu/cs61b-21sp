package timingtest;
import edu.princeton.cs.algs4.Stopwatch;
/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        // An array used to do operations
        AList<Integer> N = new AList<>();
        // times of operation
        AList<Integer> Ns = new AList<>();
        // time
        AList<Double> time = new AList<>();
        AList<Integer> opCnt = new AList<>();
        int mileStoneCnt = 0;
        Stopwatch sw = new Stopwatch();
        for(int i = 0; i <= 1024000; i++) {
            N.addLast(i);
            if(N.size() == Math.pow(2,mileStoneCnt) * 1000){
                time.addLast(sw.elapsedTime());
                Ns.addLast(i);
                opCnt.addLast(i);
                mileStoneCnt += 1;
            }
        }
        printTimingTable(Ns,time,opCnt);
    }
}
