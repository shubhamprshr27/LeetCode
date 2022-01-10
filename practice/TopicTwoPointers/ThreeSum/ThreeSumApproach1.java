package TopicTwoPointers.ThreeSum;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashSet;

/**
 * This approach is the simplest one.
 * The window approach is quite efficient.
 * Other approach is to break into 2 sum problem.
 */
public class ThreeSumApproach1 {
    
    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums.length<3) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        //Other than HashSet you can just skip all the duplicates. -> 1105ms and 175.3MB
        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(set.contains(nums[i])) continue;    
            set.add(nums[i]);
            int left=i+1;
            int right=nums.length-1; 
            while(left<right){
                int x = nums[i]+nums[left]+nums[right];
                if(x>0)
                    right--;
                else if(x<0)
                    left++;
                else{
                    ArrayList<Integer> triplet = new ArrayList<>(Arrays.asList(nums[i],nums[left],nums[right]));
                    ans.add(triplet);
                    while (left<right && nums[left]==nums[left+1]) left++;
                    left++;
                    right--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
}
