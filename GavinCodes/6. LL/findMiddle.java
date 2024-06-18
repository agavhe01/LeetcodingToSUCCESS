public class Solution{

    public ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // ListNode slow2 = head;
        // while(slow2.next != null && slow2 != slow){
        //     slow2 = slow2.next;
        // }
        // return slow2;
        return slow;
    }

}