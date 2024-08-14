/*
public class Interval {
    int start, end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

*/

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Arrays;
import java.util.Collections;

public class intervals{

    static Comparator<Interval> ascIntervalComp = new Comparator<Interval>(){
        @Override
        public int compare(Interval i1, Interval i2){
            if (i1.start != i2.start) return i1.start - i2.start;
            else return i1.end - i2.end;
        }
    };

    public intervals(){}

    public static List<Interval> mergeIntervals(List<Interval> intervals){
        List<Interval> result = new ArrayList<Interval>();
        Collections.sort(intervals, ascIntervalComp);
        int n = intervals.size();

        for(int i = 0; i < n; i++){
            Interval curr = intervals.get(i);
            int L = curr.start;
            int R = curr.end;

            if (i == 0) result.add(curr);
            else if (result.get(result.size() - 1).end < L ) result.add(curr);
            else result.get(result.size() - 1).end = Math.max(result.get(result.size() - 1).end, R );
        

        }
        return result;
    }

    public static void main(String[] args){
        intervals sol = new intervals();

        List<Interval> test1 = new ArrayList<Interval>();

        test1.add(new Interval(15,18));
        test1.add(new Interval(1,3));
        test1.add(new Interval(2,6));
        test1.add(new Interval(8,10));
        
        printIntervals(test1);
        List<Interval> res1 = sol.mergeIntervals(test1);
        System.out.println("Merged\n");
        printIntervals(res1); // [[1,6],[8,10],[15,18]]

        List<Interval> test2 = new ArrayList<Interval>();

        test2.add(new Interval(4,5));
        test2.add(new Interval(1,4));
        
        printIntervals(test2);
        List<Interval> res2 = sol.mergeIntervals(test2);
        System.out.println("Merged\n");
        printIntervals(res2); // [[1,5]]

        
        System.out.println("Insert then Merge");
        List<Interval> test3 = new ArrayList<Interval>();
        test3.add(new Interval(6,9));
        test3.add(new Interval(1,3));
        test3.add(new Interval(2,5));
        List<Interval> res3 = sol.mergeIntervals(test3);
        System.out.println("Merged");
        printIntervals(res3); //  [[1,5],[6,9]]

    }

    public static void printIntervals(List<Interval> arr){
        System.out.println();
        for(Interval i: arr) i.printInterval();
    }

}

/*
    Interval Class
*/

    class Interval {
            public int start, end;
            public Interval(int start, int end) {
                this.start = start;
                this.end = end;
            }
            void printInterval(){ System.out.println("Start: " + this.start + "  End: " + this.end); }
    }