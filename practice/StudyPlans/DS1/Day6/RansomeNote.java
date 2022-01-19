package StudyPlans.DS1.Day6;

public class RansomeNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length()>magazine.length()) return false;
        int [] map1 = new int[26];
        int [] map2 = new int[26];
        for(int i=0;i<ransomNote.length();i++) map1[ransomNote.charAt(i)-'a']++;
        for(int i=0;i<magazine.length();i++) map2[magazine.charAt(i)-'a']++;
        for(int i=0;i<26;i++){
            if(map1[i]>map2[i]) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        RansomeNote ransomeNote = new RansomeNote();
        String ransomNote = "aa";
        String magazine = "ab";
        System.out.println(ransomeNote.canConstruct(ransomNote, magazine));
    }
}
