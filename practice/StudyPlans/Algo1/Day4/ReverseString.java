package StudyPlans.Algo1.Day4;

public class ReverseString {
    
    public static void reverseString(char[] s) {
        for(int i=0;i<(s.length/2);i++){
            char temp = s[i];
            s[i]=s[s.length-i-1];
            s[s.length-i-1]=temp;
        }
        //System.out.println(Arrays.toString(s));
    }

    public static void main(String[] args) {
        char [] s = {'h','e','l','l','o','s'};
        reverseString(s);
    }
}
