LeetCodeLink :- https://leetcode.com/problems/linked-list-cycle-ii
//Time Complexity O(n) | Space Complexity O(1)
//n = no of nodes in the linked list
/**
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
    public ListNode detectCycle(ListNode head) 
    {
        
        if(head == null || head.next == null || head.next.next == null)
        {
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        
        while(fast != slow )
        {
            if(fast == null || slow == null)
            {
                return null;
            }
            if(fast.next == null || slow.next == null)
            {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while(fast != slow)
        {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
        
    }
}
