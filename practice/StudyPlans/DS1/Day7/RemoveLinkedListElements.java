package StudyPlans.DS1.Day7;

import utils.ListNode;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            if(curr.val==val){
                if(prev!=null) prev.next = curr.next;
                else//head is getting replaced
                    head = head.next;
                curr = curr.next;
                continue;
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(7, new ListNode(7)));
        ListNode.print(new RemoveLinkedListElements().removeElements(head, 1));
    }
}
