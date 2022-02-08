package Trees.Medium;


import utils.TreeNode;

/**
 * PostOrder where children need to be operated first.
 * Solved: 8th Feb 2022.
 * 
 */
public class BinaryTreePruning {

    public TreeNode pruneTree(TreeNode root) {
        if(root ==null) return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if(root.val==0 && root.left==null && root.right==null) return null;
        return root;
    }
}
