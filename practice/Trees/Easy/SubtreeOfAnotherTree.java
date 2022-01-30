package Trees.Easy;

import utils.TreeNode;

//Worst case is O(m*n) -> m,n are number of nodes in respective trees. USING DFS/BFS here using DFS.
//Read KMP algorithm, although that algo can give best performance, it is not really the tree way of solving the question.
//
public class SubtreeOfAnotherTree {
    /*
        Do DFS and check till leaf nodes.
        That way we can verify complete equality.
        In other words, this will ensure that the subroot has been completely checked.
    */
    public boolean dfs(TreeNode root, TreeNode subroot){
        if(root==null && subroot==null) return true;
        else if(root==null || subroot==null) return false; // quick minification of root==null && subroot!=null
        else if(root.val!=subroot.val) return false;
        return dfs(root.left,subroot.left) && dfs(root.right,subroot.right); // Implies one level of equality, need to check for subsequent subtrees.
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null) return false;
        if(dfs(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);//if the dfs gave us false, check for further nodes.
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4,new TreeNode(1, new TreeNode(1, new TreeNode(6), new TreeNode(7)), null),null);
        TreeNode subRoot = new TreeNode(4,new TreeNode(1, new TreeNode(6), new TreeNode(7)),null);
        new SubtreeOfAnotherTree().isSubtree(root, subRoot);
    }
}
