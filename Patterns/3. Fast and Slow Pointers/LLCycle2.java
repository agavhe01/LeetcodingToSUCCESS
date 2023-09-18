/**


Leetcode: 142. Linked List Cycle II

Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

Do not modify the linked list.


Hare and Tortoise

class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        ListNode * slow = head;
        bool cycle = false;
        ListNode * fast = head;
        
        while(fast && fast->next)
        {
            slow = slow->next;
            fast = fast->next->next;
            if(slow == fast)
            {
                cycle= true;
                break; 
            }
        }
        if(cycle==0){return NULL;}
        fast = head;


        //REMEMBER TO MAKE THE FAST MOVE BY 1, OTHERWISE IT WILL TAKE LONGER TO FIND THE NODE
        while(fast != slow)
        {
            slow = slow->next;
            fast = fast->next;
        }
        return fast;

    }
};

 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> visited_nodes = new HashSet<>();
        ListNode current_node = head;
        while (current_node != null) {
            if (visited_nodes.contains(current_node)) {
                return current_node;
            }
            visited_nodes.add(current_node);
            current_node = current_node.next;
        }
        return null;
        
    }
}