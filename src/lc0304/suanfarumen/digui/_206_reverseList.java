package lc0304.suanfarumen.digui;

import lc0304.suanfarumen.ListNode;

public class _206_reverseList {

    public ListNode reverseList(ListNode head) {
        ListNode tmp = new ListNode(-1);
        ListNode pre = tmp;
        ListNode huan = head;
        ListNode firt;
        while(huan != null){
            firt = pre.next;
            pre.next = huan;
            pre.next.next = firt;
            huan = huan.next;
        }
        return pre.next;
    }
}
