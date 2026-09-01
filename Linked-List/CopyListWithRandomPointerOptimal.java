/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // Optimal Solution
        Node temp = head;
        // Create copy nodes and insert in between the nodes
        while(temp!=null) {
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }
        // Assign the random pointers
        temp = head;
        while(temp!=null) {
            temp.next.random = (temp.random!=null)?temp.random.next:null;
            temp = temp.next.next;
        }
        // Assign the next pointers and detach the copy from original
        temp = head;
        Node dummy = new Node(-1);
        Node res = dummy;
        while(temp!=null) {
            res.next = temp.next;
            temp.next = temp.next.next;
            res = res.next;
            temp = temp.next;
        }
        return dummy.next;
    }
}