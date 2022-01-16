package Weekly160122;

import java.util.Arrays;

public class DivideStringIntoKGroups {

    public static String[] divideString(String s, int k, char fill) {
        if(s.length()%k!=0){
            int iter = k-(s.length()%k);
            for(int i=0;i<iter;i++) s = s+fill;
        }
        String [] ans= new String[s.length()/k];
        int ctr = 0;
        for(int i=0;i<s.length();i+=k){
            ans[ctr]=s.substring(i, i+k);
            ctr++;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(divideString("abcdefghijk", 4, 'x')));
    }
}
