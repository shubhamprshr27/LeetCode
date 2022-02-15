package Trees.Medium;

import utils.ListNode;
import utils.TreeNode;

/** 
 * Comments: Missed one corner case where equality has started but, some gets skipped.
 * Restart would be needed in that case.
*/
public class LinkedListInBinaryTree {
    public boolean findSubPath(ListNode head, TreeNode root){
        if(head ==null) return true;
        if(root == null) return false;
        return head.val == root.val && (findSubPath(head.next, root.left) || findSubPath(head.next, root.right));
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        if(head ==null) return true;
        if(root == null) return false;
        return findSubPath(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }
}
