package StudyPlans.DS1.Day8;

import utils.ListNode;

public class ReverseLinkedList {
    
    public static ListNode reverseList(ListNode head) {
        ListNode temp = head;
        ListNode next;
        ListNode prev = null;
        while(temp!=null){
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;   
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode.print(ReverseLinkedList.reverseList(head));
    }
}
