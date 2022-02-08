package utils;

public class StringUtils {
    static String reverseString(String input){
        if (input == null) {
            return null;
        }
    
        StringBuilder output = new StringBuilder(input).reverse();
        return output.toString();
    }

    static String reverseString(String input, int start, int end){
        if (input == null) {
            return null;
        }
        String res="";
        for(int i=start;i<end;i++){
            res = input.charAt(i)+res;
        }
        return res;
    }
}
