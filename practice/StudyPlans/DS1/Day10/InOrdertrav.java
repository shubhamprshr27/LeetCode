package StudyPlans.DS1.Day10;

import java.util.ArrayList;
import java.util.List;

import utils.TreeNode;

public class InOrdertrav {
    
    private void inorderUtil(TreeNode node, List<Integer> ans){
        if (node == null) return;
        if (node.left!=null) inorderUtil(node.left, ans);
        ans.add(node.val);
        if(node.right!=null) inorderUtil(node.right, ans);
    }
    //Quicker and uses less memory.
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorderUtil(root, ans);
        return ans;
    }
}
