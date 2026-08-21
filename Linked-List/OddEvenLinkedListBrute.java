import java.util.ArrayList;
import java.util.List;

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
    public ListNode oddEvenList(ListNode head) {
        // Brute Force
        // Edge Case
        if(head==null || head.next==null) return head;
        ListNode temp = head;
        List<Integer> array = new ArrayList<>();
        // Grouping odd nodes
        while(temp!=null && temp.next!=null) {
            array.add(temp.val);
            temp = temp.next.next;
        }
        if(temp!=null) array.add(temp.val);
        // Grouping even nodes
        temp = head.next;
        while(temp!=null && temp.next!=null) {
            array.add(temp.val);
            temp = temp.next.next;
        }
        if(temp!=null) array.add(temp.val);
        // Writing back to the Linked List
        temp = head;
        int i=0;
        while(temp!=null) {
            temp.val = array.get(i++);
            temp = temp.next;
        }
        return head;
    }
}