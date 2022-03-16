package lc0304.suanfarumen.digui;

import lc0304.suanfarumen.ListNode;

public class _21_mergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val <= list2.val) {
            list1 = mergeTwoLists(list1.next, list2); // list1 小于 list2的值，则递归list1.next 和 list2
            return list1;
        } else {
            list2 = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        ListNode tmp = new ListNode(-101);
        ListNode first = tmp;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                first.next = list1;
                list1 = list1.next;
            } else {
                first.next = list2;
                list2 = list2.next;
            }
            first = first.next;
        }

        if(list1 == null) {
            first.next = list2;
        } else if(list2 == null) {
            first.next = list1;
        }
        return tmp.next;
    }
}
