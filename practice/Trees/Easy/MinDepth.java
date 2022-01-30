package Trees.Easy;

import utils.TreeNode;

public class MinDepth {
    //if conditions can be simplified.
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        else if(root.left==null && root.right==null) return 1;
        int leftDepth=0,rightDepth=0;
        if(root.left!=null)leftDepth = minDepth(root.left)+1;
        if(root.right!=null)rightDepth = minDepth(root.right)+1;
        
        if(leftDepth==0) return rightDepth;
        else if(rightDepth==0) return leftDepth;
        return Math.min(leftDepth,rightDepth);
    }
}
