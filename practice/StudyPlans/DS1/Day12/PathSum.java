package StudyPlans.DS1.Day12;

import utils.TreeNode;

public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null||Math.abs(targetSum-root.val)<0) return false;
        else if(targetSum-root.val==0 && root.left==null && root.right==null) return true;
        return hasPathSum(root.left, targetSum-root.val) || hasPathSum(root.right, targetSum-root.val); 
    }
}
