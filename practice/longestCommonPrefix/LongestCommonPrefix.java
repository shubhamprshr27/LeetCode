package longestCommonPrefix;
public class LongestCommonPrefix {

    public static int getMinStringLength(String [] strs){
        int minLength = strs[0].length();
        for (int i=0;i<strs.length; i++){
            minLength = (minLength > strs[i].length()) ? strs[i].length() : minLength;
        }
        return minLength;
    }
    
    public static String longestCommonPrefix(String[] strs) {
        String longestCommonPref = "";
        int minLength = getMinStringLength(strs);
        for (int i=0;i<minLength; i++){
            String currString = strs[0];
            for (int j=1;j<strs.length; j++){
                if( strs[j].charAt(i)!= currString.charAt(i))
                    return longestCommonPref;
            }
            longestCommonPref = longestCommonPref+currString.charAt(i);
        }
        return longestCommonPref;
    }

    public static void main(String[] args) {
        String [] strs = {"dog","racecar","car"};
        System.out.println(LongestCommonPrefix.longestCommonPrefix(strs));
    }
}
