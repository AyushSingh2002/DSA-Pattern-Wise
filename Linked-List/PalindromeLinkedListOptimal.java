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

    // Method to reverse a linked list
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;
        while(temp!=null) {
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        // Optimal Solution
        // Edge Case
        if(head == null || head.next==null) return true;
        // Find middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Slow Pointer will be at middle for odd length list
        // In case of even length list - slow is m1 and slow.next is the m2
        // In either case the list will be reversed from m2 to end
        ListNode head2 = reverse(slow.next);
        // Compare the 2 halves of the list
        ListNode first = head;
        ListNode second = head2;
        while(second!=null) {
            if(first.val!=second.val) { // If the values at the nodes are not equal
                reverse(head2); // Revert the structural change to the linked list
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverse(head2); // Revert the structural change to the linked list
        return true;
    }
}
// Topics -> Linked List, Two Pointers, LC-234