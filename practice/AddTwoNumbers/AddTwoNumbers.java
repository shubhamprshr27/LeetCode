package AddTwoNumbers;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class AddTwoNumbers {

    public static void printList (ListNode node){
        while (node!=null){
            System.out.print(node.val);
            node = node.next;
        }
        System.out.println();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1.val==0 && l2.val==0)
            return new ListNode(0);
        ListNode ans = new ListNode((l1.val+l2.val)%10);
        int carry=(l1.val+l2.val)/10;
        l1=l1.next;
        l2=l2.next;
        ListNode ansPointer = ans;
        while(l1!=null && l2!=null){
            int num = (l1.val+l2.val+carry)%10;
            carry = (l1.val+l2.val+carry)/10;
            l1= l1.next;
            l2= l2.next;
            ans.next = new ListNode(num);
            ans=ans.next;
        }
        while (l1!=null){
            ans.next = new ListNode((l1.val+carry)%10);
            carry = (carry+l1.val)/10;
            l1= l1.next;
            ans= ans.next;
        }
        while (l2!=null){
            ans.next = new ListNode((l2.val+carry)%10);
            carry = (carry+l2.val)/10;
            l2= l2.next;
            ans= ans.next;
        }
        if( carry>0 ) ans.next = new ListNode(1);
        //printList(ansPointer);
        return ansPointer;    
    }

    public static void main(String[] args) {
        ListNode h1 = new ListNode(2);
        ListNode h12 = new ListNode(4);
        ListNode h124 = new ListNode(3);
        h1.next = h12;
        h12.next = h124;

        ListNode h21 = new ListNode(5);
        ListNode h213 = new ListNode(6);
        ListNode h2134 = new ListNode(4); 
        h21.next = h213;
        h213.next = h2134;
        AddTwoNumbers.addTwoNumbers(h1, h21);
    }
}
