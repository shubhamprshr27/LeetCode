package Trees.Easy;

import utils.TreeNode;

public class DiameterOfBinaryTree {
    int diameter = -1;

    public int calcDiameter(TreeNode root){
        if(root==null) return -1;
        int leftDepth = 1+calcDiameter(root.left);
        int rightDepth = 1+calcDiameter(root.right);
        diameter = Math.max(leftDepth+rightDepth, diameter);
        return Math.max(leftDepth, rightDepth);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        calcDiameter(root);
        return diameter;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        new DiameterOfBinaryTree().diameterOfBinaryTree(root);
    }
}
