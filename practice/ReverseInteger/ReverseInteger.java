package ReverseInteger;

public class ReverseInteger {
    
    public static int reverse(int x) {
        if(x/10==0) return x;
        int ans = 0;
        while(x!=0){
            if((ans>0 && Integer.MAX_VALUE/ans<10) || (ans<-1 && Integer.MIN_VALUE/ans<10)){
                System.out.println(Integer.MIN_VALUE/ans);
                return 0;
            }
            ans = ans*10 + x%10;
            x = x/10;
        }
        return ans;
    }

    public static void main(String[] args) {
        int x= -100000;
        System.out.println(ReverseInteger.reverse(x));
        int y =2147483647;
        //System.out.println(y);  
    }
}
