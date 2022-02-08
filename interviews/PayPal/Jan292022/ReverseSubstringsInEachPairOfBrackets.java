package PayPal.Jan292022;


import java.util.Stack;

/**
 * Date: 1st Feb 2022
 * Submissions: multiple
 */
public class ReverseSubstringsInEachPairOfBrackets {
    public void reverseString(String input, int reverseStart, int end){
        if (input == null) {
            return;
        }
        String res="";
        for(int i=reverseStart;i<end;i++){
            res = input.charAt(i)+res;
        }
        input=input.substring(0,reverseStart)+res;
    }
    //Worst case results in O(n2), because of highly unoptimized reversal.
    //DFS based as well. Can be optimized using 
    public String reverseParenthesesN2(String s) {
        Stack<Integer> stack = new Stack<>();
        String result="";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(') stack.push(result.length());
            else if (s.charAt(i) == ')'){
                reverseString(result, stack.pop(), result.length());
            } else result=result+s.charAt(i);
        }
        return result;
    }
    //Much much simpler DFS being performed.
    //Optimized the runtime.
    /**
     * 
     * In this solution, 
     * even levels will be reversed even number of times back to its original form, 
     * so they do not need to be reversed, and we can omit reversing 
     * these levels by adding them directly to odd levels between the reversed head and tail. 
     * Thus reversal wil be reduced to minimum, and time complexity 
     * wil be on average O(n) (constant time append 
     * and at most one constant time swap for each character other than brackets).
     */
    public String reverseParentheses(String s){
        Stack<StringBuilder> levelsQueue = new Stack<>();
        levelsQueue.add(new StringBuilder());
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(')levelsQueue.push(new StringBuilder());
            else if(s.charAt(i) == ')'){
                StringBuilder reversedDeeperLevel = levelsQueue.pop().reverse();
                levelsQueue.peek().append(reversedDeeperLevel);
            } 
            else levelsQueue.peek().append(s.charAt(i));
        }
        return levelsQueue.peek().toString();
    }

    public static void main(String[] args) {
        new ReverseSubstringsInEachPairOfBrackets().reverseParenthesesN2("(ed(et(oc))el)");
    }
}
