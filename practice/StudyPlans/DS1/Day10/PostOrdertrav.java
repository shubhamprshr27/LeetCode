package StudyPlans.DS1.Day10;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import utils.TreeNode;

public class PostOrdertrav {
    /*
        Doing stack implementations for ease of re-use later.
    */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        if(root.right!=null)s.push(root.right);
        if(root.left!=null)s.push(root.left);
        TreeNode node;
        while(!s.isEmpty()){
            node = s.peek();
            //System.out.println(ans.isEmpty());
            if((node.left == null && node.right == null)||
            (!ans.isEmpty() && ((node.right!=null && ans.get(ans.size()-1) == node.right.val) || (node.left!=null && ans.get(ans.size()-1) == node.left.val)))) {
                ans.add(s.pop().val);
                continue;
            }
            if(node.right!=null) s.push(node.right);
            if(node.left!=null) s.push(node.left); 
        }
        return ans;
    }

    public static void main(String[] args) {
        PostOrdertrav trav = new PostOrdertrav();
        TreeNode head = new TreeNode(1,null, new TreeNode(2, new TreeNode(3),  null));
        trav.postorderTraversal(head);  
    }
}
