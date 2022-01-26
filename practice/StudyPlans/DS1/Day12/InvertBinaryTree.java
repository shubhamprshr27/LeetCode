package StudyPlans.DS1.Day12;

import utils.TreeNode;

public class InvertBinaryTree {

    public void invert(TreeNode root){
        if(root==null) return;
        invert(root.left);
        invert(root.right);
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
    }

    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        invert(root);
        return root;
    }
}
