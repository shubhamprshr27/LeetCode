package StudyPlans.DS1.Day14;

import utils.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class TwoSum4InputIsBST {
    //you can either convert into Two Sum problem by doing In-order traversal
    //or we can do BFS and use a hashmap for our purpose
    //Complexity and memory would be same in the worst case scenario.
    public boolean findTargetBfs(TreeNode node, int k, Set<Integer> set){
        if(node==null) return false;
        if(set.contains(node.val)) return true;
        else set.add(k-node.val);
        return findTargetBfs(node.left, k, set) || findTargetBfs(node.right, k, set);
    }

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return findTargetBfs(root, k, set);
    }
}
