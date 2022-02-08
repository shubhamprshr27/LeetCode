package Stacks;

import java.util.Stack;

/**
 * Difficulty: Medium.
 * Solved: 3rd Feb 2022.
 */
public class MakeParanthesisValid {

    //Using stack
    public int minAddToMakeValidUsingStack(String s) {
        //int left = 0, right = 0, total =0;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(!stack.empty() && stack.peek()=='(' && s.charAt(i)==')'){
                stack.pop();
                continue;
            }
            stack.add(s.charAt(i));  
        }
        return stack.size();
    }

    //Using simple O(1) space
    public int minAddToMakeValid(String s) {
        int open = 0, close = 0;
        //Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') close++; //found open brace, need close to balance.
            else if(close>0) close--; //found close brace, decrement required close braces.
            else open++; // found open brace, decrement required open bracees.
        }
        return open+close;
    }
}
