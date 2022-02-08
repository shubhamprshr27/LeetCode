package Trees.Medium;

import utils.TreeNode;

/**
 * Link: https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 * Question solved: 31st Jan 2022.
 * Attempts: 1
 * Comments: 1) Needed optimization from editorial soln
 *           2) Same as: https://leetcode.com/problems/convert-bst-to-greater-tree/ 
 */
public class BinarySearchTreeToGreaterSumTree {
    int allSum = 0;
    
    //inOrder is also good, but traversing from right to left does it in one traversal.
    public TreeNode bstToGst(TreeNode root) {
        if(root!=null){
            bstToGst(root.right);
            allSum+=root.val;
            root.val = allSum;
            bstToGst(root.left);
        }
        return root;
    }

    public TreeNode convertBST(TreeNode root) {
        if(root!=null){
            convertBST(root.right);
            allSum+=root.val;
            root.val = allSum;
            convertBST(root.left);
        }
        return root;
    }
}
