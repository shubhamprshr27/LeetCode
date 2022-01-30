package Trees.Easy;

import utils.TreeNode;

public class UniValuedBinaryTree {

    public boolean isUniValUtil(TreeNode root, int val){
        if(root==null) return true;
        if(root.val!=val) return false;
        return isUniValUtil(root.left, val) && isUniValUtil(root.right, val);
    }

    public boolean isUnivalTree(TreeNode root) {
        return isUniValUtil(root, root.val);
    }
}
