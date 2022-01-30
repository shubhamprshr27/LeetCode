package Trees.Easy;

import utils.TreeNode;

public class SortedArrayToBST {

    public TreeNode BSTUtil(int [] nums, int start, int end){
        if(start>end) return null;
        if(start==end) return new TreeNode(nums[start]);

        int mid = start + (end-start)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = BSTUtil(nums, start, mid-1);
        node.right = BSTUtil(nums, mid+1, end);
        return node;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return BSTUtil(nums, 0, nums.length-1);
    }
    
    public static void main(String[] args) {
        
    }
}
