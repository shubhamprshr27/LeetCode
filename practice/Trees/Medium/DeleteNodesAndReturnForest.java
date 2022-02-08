package Trees.Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import utils.TreeNode;

/**
 * Question: https://leetcode.com/problems/delete-nodes-and-return-forest/
 * Solved: 6th Feb 2022.
 * Comments: Needed slight fix in implementation, would have solved with slight hints.
 */
public class DeleteNodesAndReturnForest {
    List<TreeNode> ans;
    HashSet<Integer> deleted; //avoid duplicate traversals.

    public TreeNode deleteAndAdd(TreeNode root, TreeNode parent){
        if(root==null) return null;
        Boolean isDeleted = deleted.contains(root.val);
        if(!deleted.contains(root.val) && parent==null) ans.add(root); //parent deleted add tree to forest
        parent = isDeleted ? null: root;
        root.left = deleteAndAdd(root.left, parent); // update child nodes.
        root.right = deleteAndAdd(root.right, parent); 
        return parent; //parent has been updated above.
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        ans = new ArrayList<>();
        deleted = new HashSet<>();
        for(int val: to_delete) {
            deleted.add(val); //will avoid duplicate traversals.
        }
        deleteAndAdd(root,null);
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root =  new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        int [] to_delete = {3,5};
        new DeleteNodesAndReturnForest().delNodes(root, to_delete);
    }
}
