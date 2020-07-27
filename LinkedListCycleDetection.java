//LeetCode link  https://leetcode.com/problems/linked-list-cycle
//Time Complexity O(n) | Space Complexity O(1)
// n = no of nodes in LinkedList
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
    public boolean hasCycle(ListNode head) 
    {
        if(head == null || head.next == null)
        {
            return false;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(fast != slow)
        {
            if(fast == null || slow == null)
            {
                return false;
            }
            if(fast.next == null || slow.next == null)
            {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
        
    }
}
