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
    public ListNode deleteMiddle(ListNode head) {
        int n=0;
        ListNode temp = head;
        while(temp!=null) {
            n++;
            temp = temp.next;
        }
        if(n==1) return null;
        if(n==2) {
            head.next = null;
            return head;
        }
        int mid = n/2;
        temp = head;
        for(int i=0; i<mid-1; i++) temp = temp.next;
        temp.next = temp.next.next;
        return head;
    }
}
// Topics -> Linked List, Two Pointers, LC-2095