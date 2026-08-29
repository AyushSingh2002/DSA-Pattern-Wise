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
    // Function to merge two sorted Linked Lists
    public ListNode mergeTwoLists(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(left!=null && right!=null) {
            if(left.val < right.val) {
                temp.next = left;
                temp = left;
                left = left.next;
            } else {
                temp.next = right;
                temp = right;
                right = right.next;
            }
        }
        if(left!=null) temp.next = left;
        else temp.next = right;
        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        ListNode sorted = lists[0];
        for(int i=1; i<lists.length; i++) {
            sorted = mergeTwoLists(sorted, lists[i]);
        }
        return sorted;
    }
}
// Topics -> Linked List, Merge Sort, LC-23