package StudyPlans.Algo1.Day3;

import java.util.Arrays;

public class TwoSum2 {

    public static int[] twoSum(int[] numbers, int target) {
        int s= 0;
        int e=numbers.length-1;
        int [] ans =  new int [2];
        while(s<e){
            if(numbers[s]+numbers[e]==target){
                ans[0]=s+1;
                ans[1]=e+1;
                break;
            } else if(numbers[s]+numbers[e]<target){
                while(numbers[s]==numbers[s+1])s++;
                s++;
            } else{
                while(numbers[e]==numbers[e-1]) e--;
                e--;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int [] numbers = {-1,-1,0,3};
        int target = 3;
        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }
}
