package Trees.Medium;

import utils.TreeNode;

public class MaxDiffBtwNodeAndAncestor {

    public int maxAncestorDiffUtil(TreeNode root, int max, int min, int maxDiff){
        if(root==null) return maxDiff;
        if(maxDiff<Math.abs(root.val-min)){
            maxDiff = Math.abs(root.val-min);
            min = Math.min(root.val,min);
            max = Math.max(root.val,max);
        }
        if(maxDiff<Math.abs(max-root.val)){
            maxDiff = Math.abs(root.val-max);
            min = Math.min(root.val, min);
            max = Math.max(root.val, max);
        }
        int leftDiff = maxAncestorDiffUtil(root.left,max,min,maxDiff);
        int rightDiff = maxAncestorDiffUtil(root.right,max,min,maxDiff);
        return Math.max(leftDiff, rightDiff);
    }

    public int maxAncestorDiff(TreeNode root) {
        return maxAncestorDiffUtil(root, root.val, root.val, 0);    
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8, new TreeNode(3, new TreeNode(1), new TreeNode(6, new TreeNode(4), new TreeNode(7))), new TreeNode(10, null, new TreeNode(14, new TreeNode(13), null)));
        new MaxDiffBtwNodeAndAncestor().maxAncestorDiff(root);
    }
}
