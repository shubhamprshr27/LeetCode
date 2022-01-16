package StudyPlans.DS1.Day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArrays {

    public static int[] intersect(int[] nums1, int[] nums2) {
        int [] map1 = new int [1001];
        int [] map2 = new int [1001];
        List<Integer> ans = new ArrayList<>();
        for(int num: nums1) map1[num]++;
        for(int num: nums2) map2[num]++;
        for(int i=0;i<1001;i++){
            if(map1[i]>0 && map2[i]>0){
                int toBeAdded = Math.min(map1[i],map2[i]);
                while(toBeAdded-- >0) ans.add(i);
            } 
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public static void main(String[] args) {
        int [] nums1 = {4,9,5};
        int [] nums2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }
}
