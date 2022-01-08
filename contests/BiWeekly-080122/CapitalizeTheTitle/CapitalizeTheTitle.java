package CapitalizeTheTitle;

public class CapitalizeTheTitle {
    
    public static String capitalizeTitle(String title){
        String[] tokens = title.split(" ");
        StringBuilder result = new StringBuilder("");
        for(String token: tokens){
            if(token.length()<3) result.append(token.toLowerCase()+" ");
            else{
                String lowerString = token.substring(1).toLowerCase();
                result.append(Character.toUpperCase(token.charAt(0))+lowerString+" ");
            }
        }
        return result.toString().substring(0,result.length()-1);
    }

    public static void main(String[] args) {
        String s = "First leTTeR of EACH Word";
        System.out.println(capitalizeTitle(s));
    }
}
