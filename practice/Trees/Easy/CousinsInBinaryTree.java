package Trees.Easy;

import java.util.ArrayList;
import java.util.List;

import utils.TreeNode;
//Can be implemented with BFS as well, but will take up space.
public class CousinsInBinaryTree {
    List<Integer> depths;
    List<Integer> parents;

    public void findCousins(TreeNode root, int parentValue ,int x, int y, int depth){
        if(root==null) return;
        if(root.val==x||root.val==y){
            depths.add(depth);
            parents.add(parentValue);
        }
        findCousins(root.left, root.val,x, y, depth+1);
        findCousins(root.right, root.val ,x, y, depth+1);
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        depths = new ArrayList<>(2);
        parents = new ArrayList<>(2);
        findCousins(root,root.val ,x, y, 0);
        return depths.get(0)==depths.get(1) && parents.get(0)!=parents.get(1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5))));
        new CousinsInBinaryTree().isCousins(root, 2, 3);
    }
}
