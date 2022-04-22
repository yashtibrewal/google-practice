package solved.medium;
import java.util.ArrayList;

//   Definition for singly-linked list.
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

class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode temp = head;
        // traversing
        int index = 0;
        while (index < left-1) {
            temp = temp.next;
            index++;
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ListNode startCopy = temp;
        while (temp != null && index < right) {
            arrayList.add(temp.val);
            temp = temp.next;
            index++;
        }
        int counter = right - left;
        while (counter >= 0) {
            if (startCopy != null) {
                startCopy.val = arrayList.get(counter--);
                startCopy = startCopy.next;
            }
        }
        return head;
    }
}

class Solution92Test{
    public static void main(String[] args){
        Solution92 solution92 = new Solution92();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        solution92.reverseBetween(head, 1, 3);
    }
}