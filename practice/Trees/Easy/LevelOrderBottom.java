package Trees.Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import utils.TreeNode;


public class LevelOrderBottom {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int sz = q.size();
            List<Integer> levelValues = new ArrayList<>();
            for(int i=0;i<sz;i++){
                TreeNode node = q.poll();
                levelValues.add(node.val);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            ans.add(levelValues);
        }
        List<Integer> temp;
        for(int i=0;i<ans.size()/2;i++){
            temp = ans.get(i);
            ans.set(i, ans.get(ans.size()-i-1));
            ans.set(ans.size()-i-1, temp);
        }
        return ans;
    }
}
