package Stacks.MonotonicStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpanner {
    List<Integer> prices;
    List<Integer> span;
    public StockSpanner() {
        prices = new ArrayList<>();
        span = new ArrayList<>();
    }

    public int next(int price){
        prices.add(price);
        span.add(0);
        int i=prices.size()-1;
        int days =1;
        while(i-days>-1 &&(prices.get(i-days)<=prices.get(i))){
            days =days+ span.get(i-days);
        } 
        span.set(i, days);
        return span.get(span.size()-1);
    }

    Stack<int[]> stack = new Stack<>();
    public int nextOpti(int price) { //This is a lil bit better?
        int res = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price)
            res += stack.pop()[1];
        stack.push(new int[]{price, res});
        return res;
    }

    public static void main(String [] args){
        StockSpanner s = new StockSpanner();
        int [] arr = {1,2,4,5,3};
        for(int i : arr){
            System.out.println(s.nextOpti(i));
        }
    }
}
