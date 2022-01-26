package StudyPlans.DS1.Day14;

import utils.TreeNode;

public class LowestCommonAncestor {

    public TreeNode lcaUtil(TreeNode root, TreeNode low, TreeNode high){
        if(root.val>=low.val && root.val<=high.val) return root;
        else if(root.val<low.val && root.val<high.val) return lcaUtil(root.right, low, high);
        return lcaUtil(root.left, low, high);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val<q.val) return lcaUtil(root, p, q);
        return lcaUtil(root, q, p);
    }
}
