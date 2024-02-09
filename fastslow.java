class ListNode{
    int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
}
public class fastslow {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
    public static void main(String[] args){
        fastslow f = new fastslow();
        ListNode l = new ListNode(3);
        l.next = new ListNode(2);
        l.next.next = new ListNode(0);
        l.next.next.next = new ListNode(-4);
        l.next.next.next.next = l.next;
        boolean a = f.hasCycle(l);
    }
}