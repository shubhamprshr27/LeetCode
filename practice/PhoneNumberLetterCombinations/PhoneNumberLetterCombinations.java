package PhoneNumberLetterCombinations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//ToDo: Revisit after Graphs and traversals.
public class PhoneNumberLetterCombinations {
    
    public static List<String> letterCombinations(String digits) {
        if (digits=="") return new ArrayList<>();
        ArrayList<String> answer = new ArrayList<>();
        HashMap<Character,String> map =  new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        for(int i=0;i<digits.length();i++){
            String codeString = map.get(digits.charAt(i));
            if (i==0){
                for(int j=0;j<codeString.length();j++){
                    answer.add(""+codeString.charAt(j));
                }
            } else {
                for (int t=0; t<answer.size(); t++){
                    for(int j=0; j<codeString.length();j++){
                        if((i>0 && digits.charAt(i)==digits.charAt(i-1))||(!codeString.contains(""+answer.get(t).charAt(answer.get(t).length()-1)))){
                            String concatedString = answer.get(t) + codeString.charAt(j);
                            if(concatedString.length()<=digits.length()) answer.add(concatedString);
                        }/*
                        String concatedString = answer.get(t) + codeString.charAt(j);
                        if(concatedString.length()<=digits.length()) answer.add(concatedString);*/
                    }
                }
            }            
        }
        ArrayList<String> finalAnswer = new ArrayList<>();
        for(int i=0;i<answer.size();i++){
            if(answer.get(i).length()==digits.length()) finalAnswer.add(answer.get(i));
        }
        return finalAnswer;
    }

    public static void main(String[] args) {
        String digits = "22";
        System.out.println(letterCombinations(digits));
    }
}
