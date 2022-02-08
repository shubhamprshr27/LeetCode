package Trees.Medium;

import utils.TreeNode;

public class DistributeCoinsInTree {
    int moves = 0;
    public int postOrderTrav(TreeNode root){
        if(root==null) return 0;
        int left = postOrderTrav(root.left);
        int right = postOrderTrav(root.right);
        moves += Math.abs(left)+Math.abs(right);
        return left+right+root.val-1;
    }

    public int distributeCoins(TreeNode root) {
        postOrderTrav(root);
        return moves;
    }
}
