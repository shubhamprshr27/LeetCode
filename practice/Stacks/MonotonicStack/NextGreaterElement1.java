package Stacks.MonotonicStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Question: https://leetcode.com/problems/next-greater-element-i/
 * Comments: Could solve it using O(n^2)
 * Date: 2nd Feb 2022.
 * Difficulty: Easy
 * Optimization Strat: Monotonic Stack.
 */
public class NextGreaterElement1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();
        s.push(nums2[0]); //storing element indices will be a better solution.
        for(int ele: nums2){
            // Pop when greater and add to map. This array element would be the next greater element.
            while(!s.isEmpty() && s.peek()<ele) map.put(s.pop(),ele); 
            s.push(ele);// Push in order to find next greatest element for this guy.
        }
        int [] ans = new int[nums1.length];
        for(int i=0;i<nums1.length;i++) ans[i]=map.getOrDefault(nums1[i],-1); //Nice optimization, as everything else is -1.
        return ans;
    }
}
