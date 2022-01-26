package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeNode{

    private void inorderUtil(TreeNode node, List<Integer> ans){
        if (node == null) return;
        if (node.left!=null) inorderUtil(node.left, ans);
        ans.add(node.val);
        if(node.right!=null) inorderUtil(node.right, ans);
    }

    public int val;
    public TreeNode left;
    public TreeNode right;
    //Useful for traversals.
    public List<Integer> nodeValueList; 
    public TreeNode () {};
    public TreeNode(int val){ this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public void preorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        this.nodeValueList = new ArrayList<>();
        while(!s.isEmpty()){
            TreeNode node= s.pop();
            if(node.right!=null) s.push(node.right);
            if(node.left!=null) s.push(node.left);
            this.nodeValueList.add(node.val);
        }
    }
    public void postorderTraversal(TreeNode root){
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        if(root.right!=null)s.push(root.right);
        if(root.left!=null)s.push(root.left);
        this.nodeValueList = new ArrayList<>();
        TreeNode node;
        while(!s.isEmpty()){
            node = s.peek();
            //System.out.println(ans.isEmpty());
            if((node.left == null && node.right == null)||
            (!this.nodeValueList.isEmpty() && ((node.right!=null && this.nodeValueList.get(this.nodeValueList.size()-1) == node.right.val) || (node.left!=null && this.nodeValueList.get(this.nodeValueList.size()-1) == node.left.val)))) {
                this.nodeValueList.add(s.pop().val);
                continue;
            }
            if(node.right!=null) s.push(node.right);
            if(node.left!=null) s.push(node.left); 
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorderUtil(root, ans);
        return ans;
    }
}