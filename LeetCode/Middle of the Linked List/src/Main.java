class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Main {
    // Inspired from Palindrome Linked List Solution
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
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
        ListNode head = main.arrayToLinkedList(new int[]{1, 2, 3, 4, 5, 6});
        System.out.println(main.middleNode(head).val);
    }
}
