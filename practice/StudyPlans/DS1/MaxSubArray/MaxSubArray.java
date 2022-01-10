package StudyPlans.DS1.MaxSubArray;

public class MaxSubArray {
    
    public static int maxSubArray(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE;
        int sum = 0;
        for(int num: nums){
            sum +=num;
            if (sum>maxSoFar) maxSoFar = sum;
            if (sum<0) sum=0;
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int [] nums = {5,4,-1,7,8};
        System.out.println(maxSubArray(nums));
    }
}
