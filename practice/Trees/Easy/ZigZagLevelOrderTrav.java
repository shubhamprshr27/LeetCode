package Trees.Easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import utils.TreeNode;

public class ZigZagLevelOrderTrav {
    boolean ltr = true;

    public TreeNode remove(Deque<TreeNode> dq){
        if(ltr) return dq.pollFirst();
        return dq.pollLast();
    }

    public void enqueue(Deque<TreeNode> q, TreeNode node){
        if(ltr){
            if(node.left!=null) q.addLast(node.left);
            if(node.right!=null) q.addLast(node.right);            
        } else {
            if(node.right!=null) q.addFirst(node.right);
            if(node.left!=null) q.addFirst(node.left);
        } 
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);
        while(!dq.isEmpty()){
            int sz = dq.size();
            List<Integer> levelValues = new ArrayList<>();
            for(int i=0;i<sz;i++){
                TreeNode node = remove(dq);
                levelValues.add(node.val);
                enqueue(dq, node);
            }
            ans.add(levelValues);
            ltr=!ltr;
        }
        return ans;
    }
}
