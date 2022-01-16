package StudyPlans.DS1.Day2;

//Do double pointer questions.
public class MergeSortedArrays {
    
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1,j=n-1;
        int last = m+n-1;
        while(i>-1 && j>-1){
            if(nums1[i]<=nums2[j]) nums1[last] = nums2[j--];
            else nums1[last]=nums1[i--];
            last--;
        }
        while(j>-1 && last>-1){
            nums1[last] = nums2[j];
            j--;
            last--;
        }
        //System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        int [] nums1 = {1,2,3,0,0,0}, nums2 = {2,5,6};
        merge(nums1, 3, nums2, 3);
    }
}
