package Trees.Easy;

import utils.ListNode;
import utils.TreeNode;

public class SortedLinkedListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        ListNode single = head, prev= head, doubleIter = head;
        /*
            Here the double will go next twice.
            Thus we will come to the mid.
        */
       while(doubleIter!=null && doubleIter.next!=null){
           prev = single;
           single=single.next;
           doubleIter = doubleIter.next.next;
       }
       TreeNode node = new TreeNode(single.val);
       /*
            This is one of the boundary conditions.
            which means we have arrived at the first element.
            Which will be the leaf node on the left-side of BST.
       */
       if(single==head) return node;
       prev.next=null; // This guy ensures that we will limit the left-side of the linked-list.
       node.left = sortedListToBST(head);
       node.right = sortedListToBST(single.next);

       return node;
    }
}
