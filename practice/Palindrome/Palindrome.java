public class Palindrome {

    public static boolean palindromeCheck(int x) {
        int reverse = 0;
        int copy = x;
        while(copy > 0){
            //123 -> 321
            reverse = (reverse*10) + (copy%10);
            copy = copy/10; 
        }
        //System.out.println(reverse);
        return reverse == x;
    }
    public static void main(String[] args) {
        int number = 121;
        System.out.println(Palindrome.palindromeCheck(number));
    }
}
