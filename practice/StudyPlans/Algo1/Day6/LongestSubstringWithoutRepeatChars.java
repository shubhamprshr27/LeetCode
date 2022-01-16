package StudyPlans.Algo1.Day6;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatChars {

    public static int lengthOfLongestSubstring(String s) {
        //if(s.length()==1) return 1;
        int maxLength = 0;
        HashSet<Character> hset = new HashSet<>();
        int strt=0,end=0;
        while(strt<s.length() && end<s.length()){
            if(hset.contains(s.charAt(end))){
                hset.remove(s.charAt(strt));
                maxLength = Math.max(maxLength, end-strt);
                strt++;
                continue;
            }
            hset.add(s.charAt(end));
            end++;
        }//all unique case, and everything else hopefully.
        return Math.max(maxLength, end-strt);
    }
    
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
