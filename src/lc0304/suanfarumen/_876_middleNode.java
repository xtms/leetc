package lc0304.suanfarumen;

public class _876_middleNode {
    public static ListNode middleNode(ListNode head) {
        ListNode firstNode = head;
        ListNode lastNode = head;
        ListNode ans = null;
        int count = 0;
        while(lastNode.next != null){
            lastNode = lastNode.next;
            count++;
        }
        count++;
        System.out.println(count);
        int flag = 0;
        if(count == 1){
            ans = head;
        }
        while(firstNode.next  != null){
            firstNode = firstNode.next;
            flag++;
            if(count/2 == flag) {
                ans = firstNode;
                break ;
                }
            }
        return ans;
    }


    public static ListNode middleNode1(ListNode head) {
        ListNode ans;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5= new ListNode(5);
        listNode5.next = null;
//        listNode4.next = listNode5;
//        listNode3.next = listNode4;
//        listNode2.next = listNode3;
//        listNode1.next = listNode2;
       ListNode ans =  middleNode(listNode5);
        System.out.println("result --->"+ans.val);
    }
}
