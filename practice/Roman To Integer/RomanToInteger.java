public class RomanToInteger {

    public static int mapper (String key){
        if(key.equals("I"))
            return 1;
        else if(key.equals("IV"))
            return 4;
        else if(key.equals("V"))
            return 5;
        else if(key.equals("IX"))
            return 9;
        else if(key.equals("X"))
            return 10;
        else if(key.equals("XL"))
            return 40;
        else if(key.equals("L"))
            return 50;
        else if ( key.equals("XC"))
            return 90;
        else if ( key.equals("C"))
            return 100;
        else if ( key.equals("CD"))
            return 400;
        else if ( key.equals("D"))
            return 500;
        else if ( key.equals("CM"))
            return 900;
        else if ( key.equals("M"))
            return 1000;                                
        return -1;    
    }

    public static int convertRomanToInteger(String s){
        int number = 0;
        int i = 0;
        while(i < s.length()){
            char presentChar = s.charAt(i);
            String key = ""+ presentChar;
            if(i<s.length()-1){
                char nextChar = s.charAt(i+1);
                key = key+nextChar;
                if(mapper(key) > 0){
                    number = number + mapper(key);
                    i++;
                } else {
                    number = number+mapper("" + presentChar);
                }
            } else {
                number = number+mapper(key);
            }
            i++;
        }
        //System.out.println(number);
        return number;
    }

    public static void main(String[] args) {
        String romanString = "MCMXCIV";
        RomanToInteger.convertRomanToInteger(romanString);
    }
}
