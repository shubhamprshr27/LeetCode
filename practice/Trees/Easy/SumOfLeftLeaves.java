package Trees.Easy;

import utils.TreeNode;

public class SumOfLeftLeaves {
    int sum=0;
    public void findSum(TreeNode root){
        if(root==null) return;
        //Left leave node.
        if(root.left!=null && root.left.left==null && root.left.right==null) sum+=root.left.val;
        findSum(root.left);
        findSum(root.right);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        findSum(root);
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        new SumOfLeftLeaves().sumOfLeftLeaves(root);
    }
}
