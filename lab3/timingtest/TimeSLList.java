package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
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
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        // times of operation
        SLList<Integer> sList = new SLList<>();
        AList<Integer> Ns = new AList<>();
        // time
        AList<Double> time = new AList<>();
        AList<Integer> opCnt = new AList<>();
        int mileStoneCnt = 0;
        int ops = 10000;
        for (int i = 0; i <= 102400; i++) {
            sList.addLast(i);
            if (sList.size() == Math.pow(2, mileStoneCnt) * 1000) {
                Stopwatch sw = new Stopwatch();
                for (int j = 0; j <= ops; j++) {
                    sList.getLast();
                }
                time.addLast(sw.elapsedTime());
                Ns.addLast(sList.size());
                opCnt.addLast(ops);
                mileStoneCnt++;
            }
        }
        printTimingTable(Ns, time, opCnt);
    }
}
