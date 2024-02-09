class listds {
      int val;
      listds next;
      listds() {}
      listds(int val) { this.val = val; }
      listds(int val, listds next) { this.val = val; this.next = next; }
  }
public class reversek {
    /* 
    public listds reverseKGroup(listds head, int k) {
        listds cur = head;
        int count = 0;
        while (cur != null && count != k) {
            cur = cur.next;
            count++;
        }
        if (count == k) {
            cur = reverseKGroup(cur, k);
            while (count-- > 0) {
                listds temp = head.next;
                head.next = cur;
                cur = head;
                head = temp;
            }
            head = cur;
        }
        return head;
    }
    */
    public listds reverseKGroup(listds head, int k) {
        listds dummy = new listds(0, head);
        listds curr = head;
        listds prev = dummy;
        listds temp = null;

        int count = k;

        while (curr != null) {
            if (count > 1) {
                temp = prev.next;
                prev.next = curr.next;
                curr.next = curr.next.next;
                prev.next.next = temp;

                count--;
            } else {
                prev = curr;
                curr = curr.next;

                listds end = curr;

                for (int i = 0; i < k; ++i) {
                    if (end == null) {
                        return dummy.next;
                    }
                    end = end.next;
                }
                count = k;
            }
        }

        return dummy.next;
    }
    public static void main(String[] args) {
        reversek r = new reversek();
        listds l = new listds(1);
        l.next = new listds(2);
        l.next.next = new listds(3);
        l.next.next.next = new listds(4);
        l.next.next.next.next = new listds(5);
        listds n = r.reverseKGroup(l, 2);
    }
}
