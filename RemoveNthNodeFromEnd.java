//Solve this Problem in leet code platform 
//Link :- https://leetcode.com/problems/remove-nth-node-from-end-of-list/
//Time Complexity O(N) N = Number Of Nodes in LinkedList
//Space Complextiy O(1)
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        int counter = 1;
        if(head==null)
        {
            return head;
        }
        while(counter <= n)
        {
            second = second.next;
            counter++;
        }
        if(second == null)
        {
            head.val=head.next.val;
            head.next = head.next.next;
            return head;
        }
        while(second.next != null)
        {
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
        return head;
        
    }
}
