//LeetCode Link :- https://leetcode.com/problems/reverse-linked-list
//Time Complexity O(n) | Space Compelxity O(n) (due to recursion)
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
        return reverseListHelper(head,null,head,null);
        
    }
    public ListNode reverseListHelper(ListNode head,ListNode p1,ListNode p2,ListNode p3)
    {
        if(p2==null)
        {
            return p1;
        }
        p3 = p2.next ;
        p2.next = p1;
        return reverseListHelper(head,p2,p3,p3);
        
    }
}
