package Trees.Medium;

import utils.TreeNode;

public class TrimBst {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null) return null;
        if(root.val>=low && root.val<=high){
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        } else if(root.val < low) root = trimBST(root.right, low, high);
        else root = trimBST(root.left, low, high);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(0, null, new TreeNode(2, new TreeNode(1), null)), new TreeNode(4));
        new TrimBst().trimBST(root, 1, 3);
        TreeNode.printTree(root);
    }
}
