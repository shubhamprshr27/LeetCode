package Trees.Medium;

import java.util.LinkedList;
import java.util.List;

//import utils.ListNode;

public class PathInZigZagLabeledTree {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> ans = new LinkedList<>();//use LinkedList here. to avoid reversal.
        int level = (int) (Math.log(label)/ Math.log(2));
        int levelVal = (int) Math.pow(2, level);
        int prev = levelVal-1;
        while(label>1){
            ans.add(0,label);
            label = prev - (label-levelVal)/2;
            prev=prev/2;
            levelVal=levelVal/2;
        }
        ans.add(0,1);
        return ans;
    }

    public static void main(String[] args) {
        new PathInZigZagLabeledTree().pathInZigZagTree(26);
    }
}
