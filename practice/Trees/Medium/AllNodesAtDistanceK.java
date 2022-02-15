package Trees.Medium;

import java.util.ArrayList;
import java.util.List;

import utils.TreeNode;

public class AllNodesAtDistanceK {
    List<Integer> ans;

    public void add(TreeNode root,int k, int depth){
        if(root==null || k <0) return;
        if(k == depth) ans.add(root.val);
        else {
            add(root.left, k,depth+1); //once finding node, keep decrementing until 0, i.e depth==k
            add(root.right, k, depth+1);
        }
    }

    public int search(TreeNode root, TreeNode target, int k){
        if(root==null) return -1;
        if(root == target) {
            add(root, k,0);
            return 1;
        } else{
            int left = search(root.left, target, k);
            int right = search(root.right, target, k);
            if(left!=-1){
                if(left==k) ans.add(root.val);
                else add(root.right, k,left+1);
                return left+1;
            } else if(right!=-1){
                if(right==k) ans.add(root.val);
                else add(root.left, k,right+1);
                return right+1;
            } else return -1;
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ans = new ArrayList<>();
        search(root, target, k);
        return ans;        
    }
}
