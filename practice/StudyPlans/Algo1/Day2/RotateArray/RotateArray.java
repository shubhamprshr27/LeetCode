package StudyPlans.Algo1.Day2.RotateArray;

public class RotateArray {
    //Although there is a solution where I can rotate an array in Space of o(n), it can be done in O(1)
    public static void swap(int [] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void reverse(int [] nums, int end){
        for(int i=0;i<(end)/2;i++) swap(nums,i,end-i-1);
    }
    
    public static void rotate(int[] nums, int k) {
        int size = nums.length;
        k=k%size;
        if(k!=0){
            //1. reverse first half.
            reverse(nums,(size-k));
            //2. reverse whole to make life easy
            reverse(nums, size);
            //3. reverse new first half.
            reverse(nums, k);
        }
        //System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = {-1,-100,3,99};
        rotate(nums, 1);
    }
}
