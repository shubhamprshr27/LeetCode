package Stacks;

//import java.util.Stack;

/**
 * Solved: 4th Feb 2022
 * Difficulty: Medium.
 * QUestion: https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/
 */
public class MinNumberOfSwaps {
    public int minSwaps(String s) {
        //caring only about stack size, so we can use it with a simple variable.
        int stackSize = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='[') stackSize++;
            else {
                if(stackSize>0) stackSize--;
                stackSize++;
            }
        }
        return (stackSize+1)/2/*(int) Math.ceil((double)st.size()/ (double) 4)*/;
    }
}
