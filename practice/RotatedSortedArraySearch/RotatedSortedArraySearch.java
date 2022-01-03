package RotatedSortedArraySearch;

public class RotatedSortedArraySearch {

    public static int findPivot(int [] nums, int left, int right){
        //This part is non-rotated, hence return -1.
        if(nums[left]<nums[right] || left==right) return -1;
        int mid = (left + right)/2;
        int leftPivot = findPivot(nums, left, mid);
        int rightPivot = findPivot(nums, mid+1,right);
        //pivot is the point where both sub-arrays are sorted.
        if(rightPivot == -1 && leftPivot ==-1)
            return mid;
        else if(leftPivot ==-1)
            return rightPivot;
        return leftPivot;
    }

    public static int binarySearch (int []nums, int left, int right, int target){
        if( left > right || (left == right && nums[left]!=target)) return -1;
        if(left == right && nums[left]==target) 
            return left;   
        int mid = (left + right)/2;
        if(nums[mid] == target) return mid;
        if(nums[mid] < target) return binarySearch(nums, mid+1, right, target);
        return binarySearch(nums, left, mid, target);
    }
    
    public static int search(int[] nums, int target) {
        int pivot = findPivot(nums, 0, nums.length-1);
        if(pivot ==-1) 
            return binarySearch(nums, 0, nums.length-1, target);
        else if(target < nums[0])
            return binarySearch(nums, pivot+1, nums.length-1, target);
        return binarySearch(nums, 0, pivot, target);        
    }

    public static void main(String[] args) {
        int[] nums = {1};//2,4,5,6,7,0,1
        int target = 0;
        System.out.println(search(nums, target));
    }
}
