package Trees.Hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import utils.TreeNode;

/**
 * Algo part was correct.
 * Priority Queue can also be used.
 * But here Java Collections are needed to play around.
 * Approach was faster than 99.5%
 * Comments: Need to brush up java streams.
 */
class Pair {
    TreeNode treeNode;
    int x;
    int y;
    Pair (TreeNode treeNode, int x, int y){
        this.treeNode = treeNode;
        this.x = x;
        this.y = y;
    }
}

public class VerticalTraversalTree {
    HashMap<Integer,List<Pair>> map;
    int minX = 0, maxX = 0;
    public void bfs(TreeNode root){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0,0));
        while(!q.isEmpty()){
            Pair node = q.poll();
            int x = node.x;
            int y = node.y;
            List<Pair> val = map.getOrDefault(x, new ArrayList<>());
            val.add(node);
            map.put(x, val);

            minX = Math.min(minX, node.x);
            maxX = Math.max(maxX, node.x);

            if(node.treeNode.left!=null) q.add(new Pair(node.treeNode.left,x-1,y+1));
            if(node.treeNode.right!=null) q.add(new Pair(node.treeNode.right, x+1,y+1));
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
       map = new HashMap<>();
       List<List<Integer>> ans = new ArrayList<>();
       bfs(root);
       for(int i=minX;i<=maxX;i++){
           Collections.sort(map.get(i), new Comparator<Pair>() {
               public int compare(Pair e1, Pair e2){
                   if(e1.y==e2.y) return e1.treeNode.val-e2.treeNode.val;
                   return 0;
               }
           });
           List<Integer> verticalOrder = new ArrayList<>();
           for(int j=0;j<map.get(i).size();j++) verticalOrder.add(map.get(i).get(j).treeNode.val);
           ans.add(verticalOrder);
       }
       return ans;
    }

    public static void main(String[] args) {
        
    }
}
