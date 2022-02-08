package Trees.Medium;

import utils.TreeNode;
/**
 * Question solved: 31st Jan 2022.
 * Attempts: 1
 */
public class SumOfNodesWithEvenValuedGrandParent {
    int sum=0;
    public void findSum(TreeNode node,Integer parent,Integer grandParent){
        if(node==null) return;
        if(grandParent!=null && grandParent%2==0)
            sum+=node.val;
        findSum(node.left, node.val, parent);
        findSum(node.right, node.val, parent);
    }

    public int sumEvenGrandparent(TreeNode root) {
        if(root==null) return 0;
        findSum(root.left, root.val, null);
        findSum(root.right, root.val, null);
        return sum;
    }
}
