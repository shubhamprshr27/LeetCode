package StudyPlans.DS1.Day6;

public class FirstUniqueChar {
    
    public int firstUniqChar(String s) {
        int [] map = new int [26];
        for(int i=0;i<s.length();i++) map[s.charAt(i)-'a']++;
        for(int i=0;i<s.length();i++) if(map[s.charAt(i)-'a'] ==1) return i;
        return -1;
    }

    public static void main(String[] args) {
        FirstUniqueChar firstUniqueChar = new FirstUniqueChar();
        System.out.println(firstUniqueChar.firstUniqChar("aabb"));
    }
}
