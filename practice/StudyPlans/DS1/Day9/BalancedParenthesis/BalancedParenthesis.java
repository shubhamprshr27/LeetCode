package StudyPlans.DS1.Day9.BalancedParenthesis;

import java.util.Stack;

public class BalancedParenthesis {
    public static boolean isValid(String s){
        Stack<Character> parenthesisStack = new Stack<>();
        for (int i=0; i< s.length(); i++){
            if( !parenthesisStack.isEmpty() && (
                (parenthesisStack.peek() == '{' && s.charAt(i) == '}') ||
                (parenthesisStack.peek() == '(' && s.charAt(i) == ')') ||
                (parenthesisStack.peek() == '[' && s.charAt(i) == ']') )
            )
                parenthesisStack.pop();
            else{
                parenthesisStack.push(s.charAt(i));
            }    
        }
        return parenthesisStack.isEmpty();
    }  
    public static void main(String[] args) {
        System.out.println(BalancedParenthesis.isValid("({})"));
    }
}
