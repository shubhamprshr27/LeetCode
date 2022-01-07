package RemoveElement;

public class RemoveElement {
    //practice 2 pointers.
    public static int removeElement(int[] nums, int val) {
        int ans= 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[ans]=nums[i];
                ans++;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        
    }
}
