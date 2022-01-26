package StudyPlans.DS1.Day13;

import utils.TreeNode;

public class InsertInBst {

    public void insert(TreeNode root, int val){
        if(root==null) return;
        if(root.val<val){
            if(root.right!=null) insert(root.right, val);
            else {
                root.right = new TreeNode(val);
                return;
            }
        }
        else if(root.val>val){
            if(root.left!=null) insert(root.left, val);
            else {
                root.left= new TreeNode(val);
                return;
            }
        } 
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        insert(root, val);
        return root;
    }
}
