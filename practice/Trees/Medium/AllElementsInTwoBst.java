package Trees.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import utils.TreeNode;

/**
 * Solved: 1 Feb 2022.
 * Question: https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
 * Comments: Was able to solve by translation to arrays. Stack approach was in mind but
 *           had gaps in implementation.
 */
public class AllElementsInTwoBst {
    
    //try with 2 stacks.
    // Can use Collections.sort as well. Java and Python use timSort to sort and merge
    // 2 already sorted arrays.
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        while(root1!=null||root2!=null||!s1.isEmpty()||!s2.isEmpty()){
            while(root1!=null){
                s1.push(root1);
                root1 = root1.left;
            }
            while(root2!=null){
                s2.push(root2);
                root2 = root2.left;
            }
            if(s2.isEmpty()||(!s1.isEmpty() && s1.peek().val<=s2.peek().val)){
                root1 = s1.pop();
                ans.add(root1.val);
                root1 = root1.right;
            } else {
                root2 = s2.pop();
                ans.add(root2.val);
                root2 = root2.right;
            }
        }
        return ans;
    }
}
