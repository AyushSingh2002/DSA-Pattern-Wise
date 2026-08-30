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
    // Function to reverse a Linked List
    public ListNode reverseList(ListNode temp) {
        ListNode prevNode = null;
        while(temp!=null) {
            ListNode nextNode = temp.next;
            temp.next = prevNode;
            prevNode = temp;
            temp = nextNode;
        }
        return prevNode;
    }
    // Function to find the k-th node of the Linked List
    public ListNode findKthNode(ListNode node, int k) {
        k--;
        while(node!=null && k>0) {
            k--;
            node = node.next;
        }
        return node;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevLast = null;
        while(temp!=null) {
            ListNode kthNode = findKthNode(temp, k);
            if(kthNode==null) {
                if(prevLast!=null) prevLast.next = temp;
                break;
            } 
            ListNode nextNode = kthNode.next;
            kthNode.next = null;
            reverseList(temp);
            if(temp == head) {
                head = kthNode;
            } else {
                prevLast.next = kthNode;
            }
            prevLast = temp;
            temp = nextNode;
        }
        return head;
    }
}
// Topics -> Linked List, Two Pointers, LC-25