package StudyPlans.Algo1.Day5;

import utils.ListNode;

public class MiddleOfLinkedList {

    public static ListNode middleNode(ListNode head) {
        int size = 0;
        ListNode temp = head;
        while(temp!=null){
            size++;
            temp=temp.next;
        } 
        int ctr = 0;
        ListNode mid = head;
        while(ctr<size/2){
            mid=mid.next;
            ctr++;
        }
        return mid;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3,new ListNode(4))));
        ListNode.print(middleNode(head));
    }
}
