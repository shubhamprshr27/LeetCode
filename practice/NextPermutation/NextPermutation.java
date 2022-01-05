package NextPermutation;

import java.util.Arrays;

public class NextPermutation {
    
    public static void nextPermutation(int[] nums) {
        boolean descending = true;
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]<nums[i+1]){
                descending = false;
                break;
            } 
        }
        if(descending) Arrays.sort(nums);
        else{
            int pivot = -1;
            int pivotVal = -1;
            for(int i=nums.length-1;i>0;i--){
                if(nums[i]>nums[i-1]){
                    pivot = i-1;
                    pivotVal = nums[i-1];
                    break;
                }
            }
            int diff = Integer.MAX_VALUE;
            int swappedVal = nums[pivot+1];
            int swappedIdx = pivot+1;
            for(int i=pivot+1;i<nums.length;i++){
                if(nums[i]-pivotVal>0 && (nums[i]-pivotVal<diff)){
                    swappedVal = nums[i];
                    swappedIdx = i;
                    diff = nums[i] - pivotVal;
                }
            }
            int temp = nums[pivot];
            nums[pivot] = swappedVal;
            nums[swappedIdx] = temp;
            Arrays.sort(nums,pivot+1,nums.length);
            System.out.println(Arrays.toString(nums));
        }
    }

    public static void main(String[] args) {
        int [] nums = {6,7,5,3,5,6,2,9,1,2,7,0,9};
        nextPermutation(nums);
    }
}
