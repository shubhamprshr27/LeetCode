package RemoveNthNode;
import utils.ListNode;

public class RemoveNthNode {
    
    public static ListNode removeNthFromEnd(ListNode head, int n)  {
        ListNode headCopy = head;
        ListNode prev = head;
        ListNode ans = head;
        int prev_ctr = n+1;
        while(head!=null){
            if(n>0) n--;
            else ans = ans.next;
            if(prev_ctr>0) prev_ctr--;
            else prev = prev.next;
            head = head.next;
        }
        //if prev_ctr==1 then means you at the beginning.
        if(prev_ctr==1) return prev.next;
        prev.next = ans.next;
        return headCopy;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode.print(removeNthFromEnd(head, 5));
    }
}
