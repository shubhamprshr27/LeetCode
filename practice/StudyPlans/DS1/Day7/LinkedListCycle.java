package StudyPlans.DS1.Day7;

import utils.ListNode;

public class LinkedListCycle {
    /**
     * Mutliple Methods to solve this problem.
     * Here we use Floyd's method. (https://www.geeksforgeeks.org/how-does-floyds-slow-and-fast-pointers-approach-work/)
     * This is the quickest method to do so.
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(slow!=null && fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }

    /**
     * Has Cycle using another approach.
     * @param args
     */
    public boolean hasCycle2(ListNode head){
        ListNode temp  =  new ListNode();
        while(head!=null){

            if(head.next==temp) return true;

            ListNode temp2 = head.next;
            head.next = temp;
            head = temp2;
        }
        return false;
    }

    public static void main(String[] args) {
        
    }
}
