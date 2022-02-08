package Trees.Medium;

import utils.TreeNode;
/**
 * Solved: 8th Feb 2022.
 * Needed help.
 */
public class LowestCommonAncestorOfTree {
    int deepest=0;
    TreeNode ancestor=null;
    private int depthHelper(TreeNode root, int depth){
        deepest = Math.max(deepest, depth);
        if(root==null) return depth;
        int left = depthHelper(root.left, depth+1);
        int right = depthHelper(root.right, depth+1);
        if(left==right && left==deepest) ancestor = root;
        return Math.max(left, right);
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        depthHelper(root, 0);
        return ancestor;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))), new TreeNode(1, new TreeNode(0), new TreeNode(8)));
        new LowestCommonAncestorOfTree().lcaDeepestLeaves(root);
    }
}