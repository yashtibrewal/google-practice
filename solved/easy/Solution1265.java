package solved.easy;
import java.util.ArrayList;

/**
 * // This is the ImmutableListNode's API interface.
 * // You should not implement it, or speculate about its implementation. */
interface ImmutableListNode {
    public void printValue(); // print the value of this node.
    public ImmutableListNode getNext(); // return the next node.
};
 
class Solution1265{
    
    public void printLinkedListInReverse(ImmutableListNode head) {
        ArrayList<ImmutableListNode> list = new ArrayList<ImmutableListNode>();
        int counter = 0;
        while(head!=null){
            list.add(head);
            head = head.getNext();
            counter++;
        }
        while(counter>0){
            list.get(--counter).printValue();
        }
    }
}