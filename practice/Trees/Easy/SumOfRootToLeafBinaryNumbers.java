package Trees.Easy;

import utils.TreeNode;

public class SumOfRootToLeafBinaryNumbers {
    int ans = 0;
    public void binarySum(TreeNode root, int sum){
        if(root==null) return;
        int val = sum*2+root.val;
        if(root.left==null && root.right==null){
            ans = ans+val;
            return;
        } 
        binarySum(root.left, val); 
        binarySum(root.right, val);
    }

    public int sumRootToLeaf(TreeNode root) {
        binarySum(root, 0);
        return ans;
    }
}
