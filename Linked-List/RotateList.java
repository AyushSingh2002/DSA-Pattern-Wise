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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        ListNode tail = head;
        int len = 1;
        while(tail.next!=null) {
            len++;
            tail = tail.next;
        }
        k = k%len;
        if(k==0) return head;
        int cnt = len-k-1;
        ListNode temp = head;
        while(cnt>0) {
            temp = temp.next;
            cnt--;
        }
        tail.next = head;
        head = temp.next;
        temp.next = null;
        return head;
    }
}