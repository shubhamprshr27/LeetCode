package StudyPlans.Algo1.Day1;

public class BinarySearch {

    public static int binarySearch(int[] nums, int left, int right, int target){
        if(left<=right){
            int mid = left+(left-right)/2; //prevents overflow.
            if(nums[mid] == target) return mid;
            else if (nums[mid]<target) return binarySearch(nums, mid+1, right, target);
            return binarySearch(nums, left, mid-1, target);
        }
        return -1;
    }

    public static int search(int[] nums, int target) {
       return binarySearch(nums, 0, nums.length-1, target);         
    }
    
    public static void main(String[] args) {
        int[] a = {-1};
        System.out.println(search(a, -1));
    }
}
