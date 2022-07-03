public class Main {

    // This solution is inspired from other seen solutions
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode node = null;
        while (slow != null){
            ListNode next = slow.next;
            slow.next = node;
            node = slow;
            slow = next;
        }
        while (node != null){
            if (node.val != head.val) return false;
            node = node.next;
            head = head.next;
        }
        return true;
    }

    void printLinkedList(ListNode head){
        ListNode current = head;
        while (current != null){
            System.out.print(current.val + ", ");
            current = current.next;
        }
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
        ListNode head = main.arrayToLinkedList(new int[]{1, 2, 3, 4, 4, 6, 5, 4, 3, 2, 1});
        System.out.println(main.isPalindrome(head));
    }
}
