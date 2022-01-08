package MaximuTwinSumLinkedList;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MaximumTwinSumLinkedList {
    
    public static int pairSum(ListNode head){
        int size = 0;
        ListNode headCopy = head;
        int [] arr = new int [100000];
        while(headCopy!=null) {
            arr[size]=headCopy.val;
            size++;
            headCopy=headCopy.next;
        }
        int result=0;
        for(int i=0;i<=size/2 -1; i++){
            if(result<arr[i]+arr[size-i-1])result=arr[i]+arr[size-i-1];
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode second =  new ListNode(2);
        ListNode third =  new ListNode(2);
        ListNode fourth =  new ListNode(3);
        //ListNode fifth = new ListNode(1);
        //ListNode sixths = new ListNode(3);*/
        head.next =  second;
        second.next = third;
        third.next=fourth;
        //fourth.next=fifth;
        //fifth.next=sixths;
        System.out.println(pairSum(head));
    }
}
