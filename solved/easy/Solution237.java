package solved.easy;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution237 {
    public void deleteNode(ListNode node) {
        ListNode prev = node;
        prev.val = node.next.val;
        node = node.next;
        while(node.next !=null){
            node.val = node.next.val;
            node = node.next;
            prev = prev.next;
        }
        prev.next=null;
    }
}