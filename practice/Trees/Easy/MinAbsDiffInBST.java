package Trees.Easy;

import utils.TreeNode;

public class MinAbsDiffInBST {
    //Same as Minimum Distance Between BST Nodes
    int minDiff = 100001;
    public void getMinDiff(TreeNode root, int min, int max){
        if(root==null) return;
        minDiff = Math.min(minDiff,Math.min(root.val-min,max-root.val));
        getMinDiff(root.left, min, root.val);
        getMinDiff(root.right, root.val, max);
    }

    public int getMinimumDifference(TreeNode root) {
        getMinDiff(root, -100001, 100001);
        return minDiff;
    }

    public int minDiffInBST(TreeNode root) {
        getMinDiff(root,-100001, 100001);
        return minDiff;
    }
}
