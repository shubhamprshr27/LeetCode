package Trees.Easy;

import utils.TreeNode;

public class RangeSumOfBST {
    int sum = 0;
    
    public void rangeSumBSTUtil(TreeNode root, int low, int high){
        if(root==null) return;
        if(low<=root.val && root.val<=high) sum=sum+root.val;
        rangeSumBSTUtil(root.left, low, high);
        rangeSumBSTUtil(root.right, low, high);
    }
    
    public int rangeSumBST(TreeNode root, int low, int high) {
        rangeSumBSTUtil(root, low, high);
        return sum;
    }
}
