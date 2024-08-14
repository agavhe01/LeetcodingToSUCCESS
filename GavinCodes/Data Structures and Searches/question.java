import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Iterator;


public class question{

    public PriorityQueue<Integer> pq;

    Comparator<Integer> descIntComp = new Comparator<Integer>(){
        @Override
        public int compare(Integer n1, Integer n2){ return n2 - n1; }
    };

    public question(){ pq = new PriorityQueue<Integer>(descIntComp); }

    public void addNum(int n){ pq.add(n); }

    public void printPQ(){
        System.out.println("\nPrinting PQ: ");
        Iterator<Integer> pqIt = pq.iterator();
        while (pqIt.hasNext()){
            Integer val = pqIt.next();
            System.out.print(val + "  ");
        }
        System.out.println("\n");
    }

    public static void main(String[] args){
        question sol = new question();

        sol.addNum(1);
        sol.addNum(2);
        sol.addNum(3);
        sol.addNum(3);

        sol.printPQ();

        System.out.println(sol.pq);

        

    }
}