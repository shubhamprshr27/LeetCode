package StudyPlans.DS1.Day10;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import utils.TreeNode;

public class PreOrderTrav {
    //Iterative solution
    /*
        Here exploring the iterative solution.
        For the others recursion will be the way.
    */
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        List<Integer> ans = new ArrayList<>();
        while(!s.isEmpty()){
            TreeNode node= s.pop();
            if(node.right!=null) s.push(node.right);
            if(node.left!=null) s.push(node.left);
            ans.add(node.val);
        }
        return ans;
    }
}
