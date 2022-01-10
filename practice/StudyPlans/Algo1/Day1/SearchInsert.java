package StudyPlans.Algo1.Day1;

public class SearchInsert {
    
    //This can be solved by just using Arrays.binarySearch()
    public static int binarySearch (int [] nums, int left, int right, int target){
        int mid = left+(right-left)/2;
        if(nums[mid] == target) return mid;
        if(nums[mid]<target){
            if(nums[mid+1]>target) return mid+1;
            return binarySearch(nums, mid+1, right, target);
        }
        return binarySearch(nums, left, mid-1, target);
    } 

    public static int searchInsert(int []nums, int target){
        if(nums[0]>target) return 0;
        else if(nums[nums.length-1]<target) return nums.length;
        return binarySearch(nums, 0, nums.length-1, target);
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 7;
        System.out.println(searchInsert(nums, target));
    }
}
