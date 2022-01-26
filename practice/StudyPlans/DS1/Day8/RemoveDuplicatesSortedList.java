package StudyPlans.DS1.Day8;

import utils.ListNode;

public class RemoveDuplicatesSortedList {
    
    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;
        ListNode temp = head;
        int val = head.val;
        ListNode prev = temp;
        temp = temp.next;
        while(temp!=null){
            if(temp.val == val){
                prev.next = temp.next;
                temp = temp.next;
                continue;
            } 
            else val = temp.val;
            temp = temp.next;
            prev = prev.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        ListNode.print(deleteDuplicates(head));
    }
}
