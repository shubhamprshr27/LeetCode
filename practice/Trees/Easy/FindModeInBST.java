package Trees.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import utils.TreeNode;

public class FindModeInBST {
    HashMap<Integer,Integer> map;

    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        map.put(root.val, map.getOrDefault(root.val, 0)+1);
        inorder(root.right);
    }

    public int[] findMode(TreeNode root) {
        map = new HashMap<>();
        Integer maxCount = 0;
        inorder(root);
        for(Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue()>maxCount) maxCount=entry.getValue();
        }       
        ArrayList<Integer> ans = new ArrayList<>();
        for(Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue().equals(maxCount)) ans.add(entry.getKey());
        }
        int [] finalAns = new int[ans.size()];
        for(int i=0;i<ans.size();i++) finalAns[i]=ans.get(i);
        return finalAns;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,null, new TreeNode(2,null, new TreeNode(2)));
        new FindModeInBST().findMode(root);
    }
}
