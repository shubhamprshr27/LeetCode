package ZigZagConversion;

import java.util.Arrays;

// This can be solved in O (nlogn) using matrix positioning as well.
// Below approach is simple and in O(n)
public class ZigZagConversion {
    
    public static String convert(String s, int numRows) {
        if(numRows ==1) return s;
        String[] rows = new String[numRows];
        Arrays.fill(rows, "");
        int direction = 0; //0 is down and 1 is up.
        int row = 0;
        for(int i=0;i<s.length();i++){
            rows[row] = rows[row]+s.charAt(i);
            if(row == 0) direction = 0;
            else if(row == numRows-1) direction = 1;
            if(direction == 0) row++;
            else row--;
        }
        StringBuilder sb =  new StringBuilder();
        for(int i=0;i<numRows;i++){
            sb.append(rows[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println(convert(s, 4));
    }
}
