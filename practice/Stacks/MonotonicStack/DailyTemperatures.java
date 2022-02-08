package Stacks.MonotonicStack;

import java.util.Stack;

/**
 * Solved: 3rd Feb 2022
 * Optimal soln: https://leetcode.com/problems/daily-temperatures/solution/
 * Comments memory can be optimized for this problem.
 * Can be applied to similar monotonic stack problems.
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack =  new Stack<>();
        int [] ans = new int[temperatures.length];
        for(int i=temperatures.length-1;i>-1;i--){
            while(!stack.empty() && (temperatures[stack.peek()]<temperatures[i])) stack.pop();
            ans[i] = stack.empty() ? 0 : stack.peek()-i;
            stack.push(i);
        }
        return ans;
    }
    //Absolutely brilliant editorial soln
    public int[] dailyTemperaturesOptimal(int[] temperatures){
        int [] ans = new int[temperatures.length];
        int currMax = 0;
        for(int i=temperatures.length-1;i>-1;i--){
            if(temperatures[i]>=currMax){
                currMax = temperatures[i]; //this will be the closest one for other temperatures to come.
                continue;
            }

            int days = 1; //least answer if value is lesser than max traversed uptil now.
            while(temperatures[i+days]<=temperatures[i]){
                days += ans[i+days];
            }
            ans[i] = days;
        }
        return ans;
    }
}

