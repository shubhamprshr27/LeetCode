package StudyPlans.Algo1.Day4;

public class ReverseWordsInString3 {
    public static String reverseWords(String s) {
        String[] tokens =  s.split(" ");
        String ans = "";
        for(String token: tokens){
            String reverse = "";
            for(int i =0;i<token.length();i++) reverse=token.charAt(i)+reverse;
            ans=ans+reverse+' ';
        }
        return ans.trim();    
    }
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(5/2);
        System.out.println(reverseWords(s));
    }
}
