package Trees.Easy;

import utils.TreeNode;

public class BinaryTreeTilt {
    //The catch was to use post-order traversal for tilt calculation.
    int tilt = 0;
    public int findTiltUtil(TreeNode root) {
        if(root==null) return 0;
        int lsum = findTiltUtil(root.left);
        int rsum = findTiltUtil(root.right);
        tilt+=Math.abs(lsum-rsum);
        return root.val+lsum+rsum;
    }   

    public int findTilt(TreeNode root){
        findTiltUtil(root);
        return tilt;
    }
}
