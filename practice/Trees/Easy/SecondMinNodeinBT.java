package Trees.Easy;

import utils.TreeNode;

public class SecondMinNodeinBT {
    long secondMid =(long) Integer.MAX_VALUE+1;
    public void findSecondMid(TreeNode root, int rootVal){
        if(root==null) return;
        if(root.val<secondMid && root.val!=rootVal) secondMid = (long) root.val;
        findSecondMid(root.left, rootVal);
        findSecondMid(root.right, rootVal); 
    }

    public int findSecondMinimumValue(TreeNode root) {
        if(root==null) return -1;
        findSecondMid(root, root.val);
        if(secondMid == (long)Integer.MAX_VALUE+1) return -1;
        return Math.max(root.left.val, root.right.val);
    }
}
