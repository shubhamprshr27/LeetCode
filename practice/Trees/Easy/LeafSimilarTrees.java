package Trees.Easy;

import java.util.ArrayList;
import java.util.List;

import utils.TreeNode;

public class LeafSimilarTrees {
    List<Integer> leafSeq1;
    List<Integer> leafSeq2;
    public void inOrderUtil(TreeNode root, List<Integer> LeafSeq){
        if(root==null) return;
        inOrderUtil(root.left,LeafSeq);
        if(root.left==null && root.right==null) LeafSeq.add(root.val);
        inOrderUtil(root.right,LeafSeq);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        leafSeq1 = new ArrayList<>();
        leafSeq2 = new ArrayList<>();
        inOrderUtil(root1, leafSeq1);
        inOrderUtil(root2, leafSeq2);
        if(leafSeq1.size()!=leafSeq2.size()) return false;
        for(int i=0;i<leafSeq1.size();i++){
            if(leafSeq1.get(i)!=leafSeq2.get(i)) return false;
        }
        return true;
    }
}
