package KthLargestElement;

import java.util.Arrays;

public class KthLargestElement {

    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length-k;
        return nums[n];
    }
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        System.out.println(findKthLargest(nums, 2));
    }
}
