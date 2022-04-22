package solved.easy;
/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        while(head!=null && head.val == val) head=head.next;
        if(head == null) return null;
        ListNode newHead = new ListNode(head.val); head = head.next;
        ListNode copy = newHead;
        while(head!=null){
            if(head.val != val){
                newHead.next = new ListNode(head.val);
                newHead = newHead.next;
            }
            head = head.next;
        }
        return copy;
    }
}