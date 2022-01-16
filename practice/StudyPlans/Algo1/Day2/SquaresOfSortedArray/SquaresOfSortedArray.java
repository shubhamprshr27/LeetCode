package StudyPlans.Algo1.Day2.SquaresOfSortedArray;

import java.lang.Math;
import java.util.Arrays;

public class SquaresOfSortedArray {
    
    public static int[] sortedSquares(int[] nums) {
        int [] ans = new int[nums.length];
        int i=0;
        int j=nums.length-1;
        int ctr=nums.length-1;
        while(i<=j){
            if(Math.abs(nums[i])>Math.abs(nums[j])) {
                ans[ctr--]= nums[i]*nums[i];
                i++;
            }
            else {
                ans[ctr--]= nums[j]*nums[j];
                j--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] nums = {-7,-3,2,11};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }
}
