package TopicTwoPointers.TwoSum;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class TwoSum
{

    int [] twoSum(Integer target, ArrayList<Integer> nums){
        //System.out.println("Hello World");
        HashMap<Integer,Integer> map = new HashMap<>();
        int [] ans = new int [2];
        for(int i=0;i<nums.size();i++){
            if(!map.containsKey(nums.get(i))){
                map.put(target-nums.get(i),i);
            } else{
                // Can be used with index as well.
                ans[0] = i;
                ans[1] = map.get(nums.get(i));
                break;
            }
        }
        return ans;
    }
    public static void main (String args[]){
        TwoSum objSum = new TwoSum();
        System.out.println(objSum.twoSum(6,new ArrayList<>(List.of(3,3))));
    }
}