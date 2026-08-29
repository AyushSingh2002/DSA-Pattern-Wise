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

    public ListNode findMiddle(ListNode head) {
        // Find middle node of a linked list using the tortoise and hare algo
        ListNode slow = head;
        ListNode fast = head.next.next;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode mergeLists(ListNode left, ListNode right) {
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

    public ListNode mergeSort(ListNode head) {
        // Edge Case
        if(head == null || head.next==null) return head;
        ListNode middle = findMiddle(head);
        ListNode leftHead = head;
        ListNode rightHead = middle.next;
        middle.next = null; // Detach the two linked lists

        leftHead = mergeSort(leftHead);
        rightHead = mergeSort(rightHead);

        return mergeLists(leftHead, rightHead);
    }

    public ListNode sortList(ListNode head) {
        // Optimal Solution -> Using Merge Sort directly on the Linked List
        ListNode sortedHead = mergeSort(head);
        return sortedHead;
    }
}
// Topics -> Linked List, Merge Sort, LC-148