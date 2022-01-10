package TopicTwoPointers.SortColours;

import java.util.Arrays;

public class SortColours {
    
    public static void sortColours(int []nums){
        int one = 0, zero=0, two= 0;
        int ctr=0;
        for (int i=0;i<nums.length;i++){
            if(nums[i]==0) zero++;
            else if(nums[i]==1) one++;
            else two++;
        }
        while(zero-->0)nums[ctr++]=0;
        while(one-->0)nums[ctr++]=1;
        while(two-->0)nums[ctr++]=2;
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = {2,0,0,0,0,1,2,2};
        sortColours(nums);
    }
}
