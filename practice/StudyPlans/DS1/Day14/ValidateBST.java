package StudyPlans.DS1.Day14;

import utils.TreeNode;

public class ValidateBST {
    
    public boolean validBSTUtil(TreeNode root, int mini, int maxi){
        if(root==null) return true;
        if(root.val<mini || root.val>maxi) return false;
        return validBSTUtil(root.left, mini, root.val) && validBSTUtil(root.right, root.val, maxi);  
    }
    //Leetcode problem requires Long because the values can be greater or equal.
    public boolean isValidBST(TreeNode root) {
        return validBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);    
    }
}
