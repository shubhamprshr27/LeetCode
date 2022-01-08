package LongestPalindromeConcatenation;

import java.util.HashMap;

public class LongestPalindromConcat {
    
    //Use removals because Java is dope.
    public static int longestPalindrome(String[] words) {
        int maxLength = 0;
        HashMap<String, Integer> map =  new HashMap<>();
        for(String s: words){
            String rev = ""+s.charAt(1)+s.charAt(0);
            if(map.containsKey(rev)){
                maxLength+=4;
                map.put(rev, map.get(rev)-1);
                if(map.get(rev)==0) map.remove(rev);
                //Continue to avoid the duplication
                continue;
            }
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        for(String s: map.keySet()){
            String rev = ""+s.charAt(1)+s.charAt(0);
            if(map.get(s)==1 && (rev.equals(s))){
                maxLength+=2;
                //break because even if there are alot, just one addition should suffice.
                break;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String [] words = {"lc","cl","gg"};
        System.out.println(longestPalindrome(words));
    }
}
