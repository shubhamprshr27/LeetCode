package TopicTwoPointers.ReverseWordsInString.WithoutLib;

public class WithoutLib {
    
    public static String reverseWords(String s) {
        s=s.strip();
        StringBuilder sb =  new StringBuilder();
        //System.out.println(s);
        String ans = "";
        for(int i=0;i<=s.length()-1;i++){
            if(s.charAt(i)!=' '){
                sb.append(s.charAt(i));
                if(i==s.length()-1||s.charAt(i+1)==' '){
                    ans = sb.toString()+" "+ans;
                    sb.setLength(0);
                } 
            } 
        }
        return ans.toString().strip();
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
    }
}
