package Trees.Easy;

import utils.TreeNode;

public class CheckBalanceTree {
    boolean ans; // Optimized from 2 traversals to one.
    public int calcHeight(TreeNode root){
        if(root==null) return 0;
        int leftDepth = calcHeight(root.left)+1;
        int rightDepth = calcHeight(root.right)+1;
        if(Math.abs(rightDepth-leftDepth)>1) ans = false;
        return Math.max(leftDepth,rightDepth);
    }
    
    public boolean isBalanced(TreeNode root) {
        ans = true;
        calcHeight(root);
        return ans;
    }
}
