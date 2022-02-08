package Stacks;

import java.util.Stack;

/**
 * Solved: 5th Feb 2022.
 * Optimization: By thinking it of like PostOrder traversal. 
 * 
 */
public class ScoreOfParenthesis {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0); //handles the base level case.
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) =='(') stack.push(0);
            else {
                int curr = stack.pop(); //curr level score.
                stack.push(stack.pop()+Math.max(2*curr, 1)); // update prev level score.
            }
        }
        return stack.pop();
    }

    public int scoreOfParenthesesOptimized(String s){
        int ans =0, depth = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') depth++; //Increase depth on each Open Paranthesis
            else {
                depth --; //Closing of bracked should decrement the depth.
                if(s.charAt(i)==')' && s.charAt(i-1)=='(') //Reached deepest core value in this branch
                    ans+=1<<depth; //Multiply by 2 according to depth of this pair.
            }
        }
        return ans;
    }
    
    public static void main(String [] args){
        new ScoreOfParenthesis().scoreOfParentheses("(()(()))");
    }
}
