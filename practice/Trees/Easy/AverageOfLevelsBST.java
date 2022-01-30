package Trees.Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import utils.TreeNode;

public class AverageOfLevelsBST {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Double> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int sz= q.size();
            Double sum = 0.0;
            for(int i=0;i<sz;i++){
                TreeNode node = q.poll();
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
                sum+=node.val;
            }
            ans.add(sum/(double)sz);
        }
        return ans;
    }
}
