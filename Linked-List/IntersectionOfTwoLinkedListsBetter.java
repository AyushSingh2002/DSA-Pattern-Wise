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
    // Function to find the collision point - List 1 is a bigger linked list
    public ListNode findCollisionNode(ListNode list1, ListNode list2, int d) {
        ListNode temp1 = list1;
        while(d>0) {
            d--;
            temp1 = temp1.next;
        }
        ListNode temp2 = list2;
        while(temp1!=temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp1;
    }
    // Function to find length
    public int findLength(ListNode head) {
        ListNode temp = head;
        int n = 0;
        while(temp!=null) {
            n++;
            temp = temp.next;
        }
        return n;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Better Solution - No extra space
        int n1 = findLength(headA);
        int n2 = findLength(headB);
        ListNode collisionPoint;
        if(n1<n2) {
            collisionPoint = findCollisionNode(headB, headA, (n2-n1));
        } else {
            collisionPoint = findCollisionNode(headA, headB, (n1-n2));
        }
        return collisionPoint;
    }
}
// Topics -> Two pointers, Linked List, LC-160