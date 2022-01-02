package MergeSortedLinkedLists;

class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeSortedLinkedLists {

    public static void printList (ListNode node){
        while (node!=null){
            System.out.print(node.val);
            node = node.next;
        }
        System.out.println();
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }
        else if(list2 == null){
            return list1;
        }
        ListNode headCopy;
        if(list1.val>list2.val){
            headCopy = list2;
            list2 = list2.next;
        } else{
            headCopy = list1;
            list1= list1.next;
        }
        ListNode ans = headCopy;
        //printList(list1);
        //printList(list2);
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                headCopy.next= list1;
                list1 = list1.next;
            } else{
                headCopy.next= list2;
                list2 = list2.next;
            }
            headCopy = headCopy.next;
        }
        while (list1!=null){
            headCopy.next = list1;
            headCopy = headCopy.next;
            list1= list1.next;
        }
        while (list2!=null){
            headCopy.next = list2;
            headCopy = headCopy.next;
            list2= list2.next;
        }
        printList(ans);
        return ans;    
    }
    
    public static void main(String[] args) {
        ListNode h1 = new ListNode(-9);
        ListNode h12 = new ListNode(3);
        //ListNode h124 = new ListNode(4);
        h1.next = h12;
        //h12.next = h124;

        ListNode h21 = new ListNode(5);
        ListNode h213 = new ListNode(7);
        //ListNode h2134 = new ListNode(4); 
        h21.next = h213;
        //h213.next = h2134;
        mergeTwoLists(h1, h21);
    }
}
