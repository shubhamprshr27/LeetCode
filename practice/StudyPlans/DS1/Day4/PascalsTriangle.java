package StudyPlans.DS1.Day4;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans =  new ArrayList<>();
        for(int i=1;i<= numRows; i++){
            List<Integer> row = new ArrayList<>();
            int j=i;
            while(j>0){
                if(j==i || j==1) row.add(1);
                else {
                    row.add(ans.get(i-2).get(j-2)+ans.get(i-2).get(j-1)); 
                }
                j--;
            }
            ans.add(row);
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int numRows = 1;
        System.out.println(generate(numRows));
    }
}
