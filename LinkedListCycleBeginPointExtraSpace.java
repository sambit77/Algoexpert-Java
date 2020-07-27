LeetCode link:- https://leetcode.com/problems/linked-list-cycle-ii
//Time Complexity O(n) | Space Complexity O(n)
//extra space (HashMap) is used
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
        HashMap<ListNode,Boolean> map = new HashMap<ListNode,Boolean>();
        while(head != null)
        {
            if(map.containsKey(head))
            {
                return head;
            }
            else
            {
                map.put(head,true);
            }
            head = head.next;
        }
        return null;
        
    }
}
