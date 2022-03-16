package lc0304.suanfajichu.shuangzhizhen;

import lc0304.TreeNode;
import lc0304.suanfarumen.ListNode;

import java.util.*;

public class _82_deleteDuplicates {
    public static ListNode deleteDuplicates(ListNode head) {

        ListNode tmp = head;
        Map<Integer, List<ListNode>> map = new HashMap<>();
        while(tmp != null){
            List<ListNode> listNode =  map.getOrDefault(tmp.val, new ArrayList<>());
            listNode.add(new ListNode(tmp.val));
            map.put(tmp.val, listNode);
            tmp = tmp.next;
        }

        List<ListNode> allList = new ArrayList<>();

        for(Map.Entry<Integer, List<ListNode>> en : map.entrySet()) {
            if (en.getValue().size() == 1) {
                allList.addAll(en.getValue());
            }
        }

        Collections.sort(allList, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        ListNode newNode = new ListNode(-101);
        ListNode tmpNode = newNode;
        for(ListNode listNode : allList){
            System.out.println(" lll "+ listNode.val);
            tmpNode.next = listNode;
            tmpNode = tmpNode.next;
        }
        return newNode.next;
    }

    public static void main(String[] args) {
        //[1,2,3,3,4,4,5]
        ListNode root = new ListNode(1);
        ListNode Node2 = new ListNode(2);
        ListNode Node31 = new ListNode(2);
//        ListNode Node32 = new ListNode(3);
//        ListNode Node41 = new ListNode(4);
//        ListNode Node42 = new ListNode(4);
//        ListNode Node5= new ListNode(5);
//        Node42.next = Node5;
//        Node41.next = Node42;
//        Node32.next = Node41;
//        Node31.next = Node32;
        Node2.next = Node31;
        root.next = Node2;
        deleteDuplicates(root);
    }
}
