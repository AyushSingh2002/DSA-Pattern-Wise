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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Optimal Solution
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        ListNode t1 = l1;
        ListNode t2 = l2;
        int carry = 0;
        while(t1!=null || t2!=null) {
            int n1 = (t1==null)?0:t1.val;
            int n2 = (t2==null)?0:t2.val;
            int sum = n1+n2+carry;
            carry = sum/10;
            ListNode node = new ListNode(sum%10);
            temp.next = node;
            temp = node;
            t1 = (t1==null)?t1:t1.next;
            t2 = (t2==null)?t2:t2.next;
        }
        while(carry>0) {
            int digit = carry%10;
            ListNode node = new ListNode(digit);
            temp.next=node;
            temp = node;
            carry /= 10;
        }
        return dummy.next;
    }
}
// Topics -> Linked List, Math, LC-2