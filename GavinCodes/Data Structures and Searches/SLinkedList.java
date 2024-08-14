import java.util.PriorityQueue;
import java.util.Comparator;


public class SLinkedList{

    public class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {}
        public ListNode(int val) { this.val = val; this.next = null; }
        public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        public void printNode(){ System.out.println("Node:" + this.val); }
    }

    // Member Variable
    public ListNode theHead;
    public ListNode getHead(){ return this.theHead; }

    // Constructors
    public SLinkedList(){ theHead = null; }

    public SLinkedList(int[] values){
        ListNode newHead = new ListNode(values[0]);
        this.theHead = newHead;
        for (int i = 1; i < values.length; i++){
            ListNode newNode = new ListNode(values[i]);
            newHead.next = newNode;
            newHead = newHead.next;
        }
    }

    // Methods 

    /*
        FIND MIDDLE
        T(C): O(n)
        S(C): O(1)
    */

        public ListNode findMiddle(ListNode head){
            ListNode slow = head;
            ListNode fast = head.next;

            while (fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;  
            }
            return slow;
        }

    
    /*
        DETECT CYCLE
        T(C): O(n)
        S(C): O(1)
    */

        // Makes a cycle from the end of the LL to the node at index n 
        // n is 1 - referenced
        public void makeCycle(int n){
            ListNode head = this.theHead;
            ListNode cycleHere = null;

            int count = 1;
            while (head != null && count <= n){
                cycleHere = head;
                head = head.next;
                count++;
            }

            head = this.theHead;

            while (head != null && head.next != null ){
                head = head.next;
            }

            head.next = cycleHere;

        }


        public ListNode detectCycle(ListNode head){

            ListNode slow = head;
            ListNode fast = head;
            boolean hasCycle = false;

            while(fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;

                if (fast == slow) {
                    hasCycle = true;
                    break;
                }
            }

            if (!hasCycle) return null;

            fast = head;
            while (fast != slow){
                fast = fast.next;
                slow = slow.next;
            }
            return fast;

        }
    /*
        REVERSE LIST
        T(C): O(n)
        S(C): O(n)
    */

    public void reverseThisListRecursion(){ this.theHead = reverseListRecurse(this.theHead); }
    public void reverseThisListIteration() { this.theHead = reverseListIterate(this.theHead); }

    //    Recursive Reverse
    public ListNode reverseListRecurse(ListNode head){
        if (head == null) return null;
        return reverse(head, null);
    }

    public ListNode reverse(ListNode head, ListNode newHead){
        if (head == null) return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverse(next, head);
    }


    //     Iterative Reverse
    public ListNode reverseListIterate(ListNode head){
        if (head == null) return null;
        ListNode prev = null;
        ListNode current = head;
        while (current != null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

   
   /*
        REMOVE Nth NODE FROM END
        T(C): O(n)
        S(C): O(1)

   */

        public void removeNthFromEnd(int n) { this.theHead = removeNthEnd(this.theHead, n); }
       
        public ListNode removeNthEnd(ListNode head, int n){
            if (n <= 0) return head;
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            dfsRemoveEnd(dummy, n + 1);
            return dummy.next;
        }

        public int dfsRemoveEnd(ListNode node, int k){
           if (node == null) return 0;
           int index = 1 + dfsRemoveEnd(node.next, k);
           if (index == k)  node.next = node.next.next;
           return index;
        }

    /*
        REMOVE Nth NODE FROM START
        T(C): O(n)
        S(C): O(1)

   */
        public void removeNthFromStart(int n) { this.theHead = removeNthStart(this.theHead, n); }

        public ListNode removeNthStart(ListNode head, int n){
            if (n <= 0) return head;
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            int size = dfsCount(dummy.next);

            if (n > size) { System.out.println("Invalid n > size"); return dummy.next; }

            dfsRemoveStart(dummy, n - 1, size);
            return dummy.next;
        }

        public int dfsCount(ListNode head){
            ListNode curr = head;
            int res = 0;
            while (curr != null){
                res++;
                curr = curr.next;
            }
            return res;
            
        }
         public int dfsRemoveStart(ListNode node, int k, int size){
           if (node == null) return size + 1;
           int index = dfsRemoveStart(node.next, k, size) - 1;
           if (index == k)  node.next = node.next.next;
           return index;
        }

    /*
        REMOVE Nth NODE FROM BEGINNING
        T(C): O(N)
        S(C): O(1)

    */
        
        public void removeNthFromBeginning(int n) { this.theHead = removeNthBeg(this.theHead, n); }

        public ListNode removeNthBeg(ListNode head, int n){
            if (head == null || n <= 0) return head;
            if (n == 1) return head.next;

            ListNode prev = null;
            ListNode curr = head;
            int count = 1;

            while (curr != null && count < n){
                prev = curr;
                count++;
                curr = curr.next;
            }

            if (curr != null) prev.next = curr.next;
            return head;

        }

     /*
        MERGE TWO SORTED LISTS
        T(C): O(N)
        S(C): O(1)

    */

    public void mergeTheseTwoSorted(SLinkedList list1, SLinkedList list2){
        ListNode l1 = list1.getHead();
        ListNode l2 = list2.getHead();
        ListNode newHead = mergeTwoSorted(l1, l2);
        list1.theHead = newHead;
    }

    public ListNode mergeTwoSorted(ListNode head1, ListNode head2){
        ListNode newHead = new ListNode(-1);
        ListNode curr = newHead;

        while(head1 != null && head2 != null){
            if (head1.val < head2.val){
                curr.next = head1;
                head1 = head1.next;
            }
            else{
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }

        if (head1 != null) curr.next = head1;
        if (head2 != null) curr.next = head2;

        return newHead.next;
    }

    /*
        MERGE k SORTED LISTS
        T(C): O( n * log k)
        S(C): O( k )

    */

    public void mergeTheseK(SLinkedList[] lists){

        int n = lists.length;
        ListNode[] arr = new ListNode[n];

        for(int i = 0; i < n; i++) arr[i] = lists[i].getHead();

        ListNode newHead = mergeKSortedLists(arr);
        this.theHead = newHead;

    }


    Comparator<ListNode> ascListNodeComp = new Comparator<ListNode>(){
            @Override
            public int compare(ListNode l1, ListNode l2) { return l1.val - l2.val; }
    };

    public ListNode mergeKSortedLists(ListNode[] lists){
        if (lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(ascListNodeComp);

        for(ListNode curr : lists){
            if (curr != null) pq.add(curr);
        }

        ListNode newHead = new ListNode(-1);
        ListNode curr = newHead;

        while (! (pq.isEmpty()) ){
            ListNode temp = pq.poll();
            curr.next = temp;
            curr = curr.next;

            if (temp.next != null) pq.add(temp.next);
        }
        return newHead.next;
    }

    /*
        MAIN
    */

    public static void main(String[] args){
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] arr2 = {1, 3, 5, 7, 55, 65, 99};
        int[] arr3 = {0, 2, 4, 6, 11, 22, 34, 54, 56, 57, 60, 64, 66, 98, 100};
        int[] arr5 = {200, 203, 205, 300};
        int[] arr4 = {-1};

        SLinkedList list1 = new SLinkedList(arr1);
        list1.printList();
        list1.reverseThisListRecursion();
        list1.printList();
        list1.reverseThisListRecursion();
        //list1.reverseThisListIteration();
        //list1.printList();

        // list1.removeNthFromBeginning(5);
        // list1.printList();

        //list1.removeNthFromEnd(8);
        list1.printList();

        //ListNode copy = list1.findMiddle(list1.getHead());
        //copy.printNode();

        //list1.printList();

        //list1.makeCycle(8);

        //ListNode copy2 = list1.detectCycle(list1.getHead());

 //       if (copy2 != null) copy2.printNode();

   //     int âńêßü = 3;
     //   System.out.println(âńêßü);

    SLinkedList list2 = new SLinkedList(arr2);
    SLinkedList list3 = new SLinkedList(arr3);
    SLinkedList list4 = new SLinkedList(arr4);
    SLinkedList list5 = new SLinkedList(arr5);

    // list4.mergeTheseTwoSorted(list2, list3);
    // list2.printList();

    //  int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8};
    System.out.println("\nRemoving from Start Again with diff function \n");
    list1.printList();
    list1.removeNthFromStart(8);
    list1.printList();

    list1.removeNthFromStart(1);
    list1.printList();

    System.out.println("\nMerge K sorted lists\n");
    
    list2.printList();
    list3.printList();
    list5.printList();
    System.out.println();
    SLinkedList[] arr = new SLinkedList[3];
    arr[0] = list2;
    arr[1] = list3;
    arr[2] = list5;

    list2.mergeTheseK(arr);
    list2.printList();



    }

    public void printList(){
        ListNode head = this.theHead;
        while (head != null) { System.out.print(head.val + "  "); head = head.next; }
        System.out.println();

    }
}
