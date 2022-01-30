package Trees.Easy;

import utils.TreeNode;

public class IncreasingOrderSearchTree {
    TreeNode prev = null;
    //By Flattening here, we aim to convert this tree to a linked list.
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        prev.left = null; // To flatten it down after backtracking to this node.
        prev.right = root; // If we set prev first, we will get an infinite loop.
        prev = root; // Set the prev value and proceed.
        inorder(root.right);
    }

    public TreeNode increasingBST(TreeNode root) {
        TreeNode node = new TreeNode(-1);
        prev = node;
        inorder(root);
        prev.left= null; // Flatten the last node. To avoid any missing pointers. 
        prev.right= null;
        return node.right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2,new TreeNode(1), new TreeNode(4, new TreeNode(3), null));
        new IncreasingOrderSearchTree().increasingBST(root);
    }
}
