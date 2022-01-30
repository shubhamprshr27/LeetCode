package Trees.Easy;

import utils.TreeNode;

public class ConstructStringFromBST {
    String ans = "";

    public void makeString(TreeNode root){
        if(root==null) return;
        ans+=String.valueOf(root.val);
        if(root.left==null && root.right==null) return;
        ans+="(";
        makeString(root.left);
        ans+=")";
        if(root.right!=null){
            ans+="(";
            makeString(root.right);
            ans+=")";
        }
    }

    public String tree2str(TreeNode root) {
        makeString(root);
        return ans; 
    }
}
