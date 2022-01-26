package StudyPlans.DS1.Day11;

import utils.TreeNode;

public class MaxDepthOfTree {

    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int leftDepth = maxDepth(root.left)+1;
        int rightDepth = maxDepth(root.right)+1;
        return Math.max(leftDepth,rightDepth);
    }
}
