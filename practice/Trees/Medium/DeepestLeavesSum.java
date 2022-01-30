package Trees.Medium;

import utils.TreeNode;

/**
 * Question solved: 31st Jan 2022.
 * Attempts: 1
 */
public class DeepestLeavesSum {
    int maxDepth=-1;
    int sum=0;
    public void findDeepestSum(TreeNode root, int depth){
        if(root==null) return;
        if(root.left==null && root.right==null){
            if(depth>maxDepth){
                sum=root.val;
                maxDepth=depth;
            } else if (depth==maxDepth) sum+=root.val;
        }
        findDeepestSum(root.left, depth+1);
        findDeepestSum(root.right, depth+1);
    }

    public int deepestLeavesSum(TreeNode root) {
        findDeepestSum(root, 0);
        return sum;
    } 
}
