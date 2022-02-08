package Trees.Medium;

import java.util.ArrayList;
import java.util.List;

import utils.TreeNode;
/**
 * Question: https://leetcode.com/problems/balance-a-binary-search-tree/
 * Solved: 1st Feb 2022
 */
public class BalanceABST {
    List<Integer> inOrder;

    public void inOrder(TreeNode root){
        if(root==null) return;
        inOrder(root.left);
        inOrder.add(root.val);
        inOrder(root.right);
    }

    public TreeNode makeTree(int s, int e){
        if(s>e) return null;
        int mid = s+ (e-s)/2;
        TreeNode node = new TreeNode(inOrder.get(mid));
        node.left=makeTree(s, mid-1);
        node.right = makeTree(mid+1, e);
        return node;
    }

    public TreeNode balanceBST(TreeNode root) {
        inOrder = new ArrayList<>();
        inOrder(root);
        return makeTree(0, inOrder.size()-1);
    }
}
