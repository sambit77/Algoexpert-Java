//LeetCode Link:- https://leetcode.com/problems/merge-two-sorted-lists
//Time Complexity O(n) | Space Complexity O(1)
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        if(l1 == null)
        {
            return l2;
        }
        if(l2 == null)
        {
            return l1;
        }

        ListNode p1prev = null;
        ListNode p1 = l1;
        ListNode p2 = l2;
        
        
        while(p1 != null && p2 != null)
        {
          if(p1.val <= p2.val)
          {
              p1prev = p1;
              p1 = p1.next;
          }
            else
            {
                if(p1prev != null )
                {
                    p1prev.next = p2;
                }
                p1prev = p2;
                p2 = p2.next;
                p1prev.next = p1;
            }
        }
        if(p1 == null)
        {
            p1prev.next = p2;
        }
        
        
        
        return l1.val <= l2.val ? l1 : l2;
        
    }
}
