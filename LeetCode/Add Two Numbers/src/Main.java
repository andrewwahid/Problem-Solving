import org.w3c.dom.Node;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Main {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode current = result;
        int carry = 0;
        while (l1 != null || l2 != null){
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            //
            int sum = x + y + carry;
            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;
            current.next = node;
            current = node;
            //
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0){
            current.next = new ListNode(carry);
        }
        return result.next;
    }

    ListNode arrayToLinkedList(int[] array){
        ListNode head = new ListNode();
        ListNode current = null;
        for (int x : array) {
            if (current == null){
                current = head;
                current.val = x;
            }else{
                ListNode node = new ListNode();
                node.val = x;
                current.next = node;
                current = node;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Main main = new Main();
        ListNode l1 = main.arrayToLinkedList(new int[]{9});
        ListNode l2 = main.arrayToLinkedList(new int[]{1, 9, 9, 9, 9, 9, 9, 9, 9, 9});
        ListNode result = main.addTwoNumbers(l1, l2);
    }
}
