package Stacks.MonotonicStack;

import java.util.Stack;
/**
 * Question: https://leetcode.com/problems/next-greater-element-ii/
 * Level: Medium
 * Solved: 3rd Feb 2022
 */
public class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s = new Stack<>();
       int [] ans = new int[nums.length];
       int sz = nums.length; //storing indexes is better because it will use less memory.
       for(int i=2*sz-1; i>-1;i--){
           while(!s.empty() && (s.peek()<=nums[i%sz])) s.pop();
           ans[i%sz] = s.empty() ? -1 : s.peek();
           s.push(nums[i%sz]); 
       }
       return ans; 
    }
}
