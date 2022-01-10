package TopicTwoPointers.ReverseWordsInString.WithLib;

public class WithLib {
    
    public static String reverseWords(String s) {
        String [] tokens = s.split("\\s+");
        String ans ="";
        for( String token: tokens) ans=token+' '+ans;  
        return ans.strip();  
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
    }
}
