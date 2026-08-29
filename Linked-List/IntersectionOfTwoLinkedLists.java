import java.util.HashMap;
import java.util.Map;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Brute Force - Using Hashing
        Map<ListNode, Integer> hashmap = new HashMap<>();
        ListNode temp = headA;
        while(temp!=null) {
            hashmap.put(temp, hashmap.getOrDefault(temp, 0)+1);
            temp = temp.next;
        }
        temp = headB;
        while(temp!= null) {
            if(hashmap.containsKey(temp)) break;
            temp = temp.next;
        }
        return temp;
    }
}
// Topics -> Hashing, Linked List, LC-160