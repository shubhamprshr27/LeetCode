package ImplementStrStr;

//Used subString -> substring[i,j) -> i inclusive and j exclusive
public class StrStr {
    
    public static int strStr(String haystack, String needle) {
        if(needle.equals("")||needle.equals(haystack)) return 0;
        else if(haystack.length()<needle.length()) return -1;
        for(int i=0;i<=haystack.length()-needle.length();i++){
            if(needle.equals(haystack.substring(i,i+needle.length()))) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("abc", "c"));
    }
}
