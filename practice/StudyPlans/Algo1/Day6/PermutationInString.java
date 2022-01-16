package StudyPlans.Algo1.Day6;

public class PermutationInString {

    public static boolean mapEqual(int [] map1, int [] map2){
        for(int i=0;i<26;i++){
            if(map1[i]!=map2[i]) return false;
        }
        return true;
    }

    public static boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int [] map1 = new int[26];
        for(int i=0;i<s1.length();i++) map1[s1.charAt(i) - 'a']++;
        for(int i=0;i<=s2.length()-s1.length();i++){
            int [] map2 = new int[26];
            for(int j=0;j< s1.length();j++) map2[s2.charAt(j+i)-'a']++;
            if(mapEqual(map1, map2)) return true;
        }
        return false;
    }

    //Sliding window approach
    //Most optimized one as extra loops and memory is saved.
    public static boolean checkInclusionOpti(String s1, String s2){
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (mapEqual(s1map, s2map))
                return true;
            s2map[s2.charAt(i + s1.length()) - 'a']++;
            s2map[s2.charAt(i) - 'a']--;
        }
        return mapEqual(s1map, s2map);
    }
    public static void main(String[] args) {
        String s1= "adc";
        String s2 = "dcda";
        System.out.println(checkInclusion(s1, s2));
    }
}
