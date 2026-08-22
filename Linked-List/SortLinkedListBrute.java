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
    public ListNode sortList(ListNode head) {
        // Brute Force
        if(head == null || head.next == null) return head;
        List<Integer> array = new ArrayList<>();
        ListNode temp = head;
        while(temp!=null) {
            array.add(temp.val);
            temp = temp.next;
        }
        array.sort(null);
        temp = head;
        for(Integer n: array) {
            temp.val = n;
            temp = temp.next;
        }
        return head;
    }
}
// Topics -> Linked List, Sorting, LC-148