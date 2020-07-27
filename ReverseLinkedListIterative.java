//LeetCode Link :- https://leetcode.com/problems/reverse-linked-list
//Time Complexity O(n) | Space Complexity O(1)
// n = no of nodes in LinkedList
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head)
    {
        ListNode p2 = head ;
        ListNode p1 = null;
        
        while(p2 != null)
        {
           ListNode p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        return p1;
        
    }
}
