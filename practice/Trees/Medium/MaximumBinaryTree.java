package Trees.Medium;

import java.util.Deque;
import java.util.LinkedList;

import utils.TreeNode;

/**
 * Solved: 1st Feb 2022.
 * Was able to solve in less optimum way.
 * My soln: O(n2)
 * Best case: O(n) using monotonic stack.
 */
public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> stack = new LinkedList<>(); // Can be used for both stack and queue ops.
        for(int i=0;i<nums.length;i++){ //This monotonic stack is a decreasing value stack.
            TreeNode node = new TreeNode(nums[i]);
            while(!stack.isEmpty() && node.val>stack.peek().val) node.left = stack.pop();
            if(!stack.isEmpty())
                stack.peek().right = node; //If you found another maximum. then this nodes lies on the right.
            stack.push(node);
        }
        if(stack.isEmpty()) return null;
        return stack.removeLast(); //Will point to the max valued node. Which would be the root of the tree.
    }
}
