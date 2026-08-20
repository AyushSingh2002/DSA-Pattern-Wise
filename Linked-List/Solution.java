import java.util.HashMap;
import java.util.Map;

/*
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // Brute Force
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode temp = head;
        while(temp!=null) {
            if(map.get(temp)!=null) return temp;
            map.put(temp, 1);
            temp = temp.next;
        }
        return null;
    }
}