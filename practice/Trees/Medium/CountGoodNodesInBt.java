package Trees.Medium;

import utils.TreeNode;

public class CountGoodNodesInBt {
    int good = 0;
    public void goodNodesUtil(TreeNode root, int maxVal) {
        if(root==null) return;
        int maxCurr = Math.max(root.val,maxVal);
        good = good + (maxCurr==root.val ? 1 : 0);
        goodNodesUtil(root.left, maxCurr);
        goodNodesUtil(root.right, maxCurr);
    }

    public int goodNodes(TreeNode root) {
        goodNodesUtil(root, root.val);
        return good;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(1, new TreeNode(3), null),new TreeNode(4, new TreeNode(1), new TreeNode(5)));
        new CountGoodNodesInBt().goodNodes(root);
    }   
}
