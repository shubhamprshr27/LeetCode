package TopicTwoPointers.ContainerWithMostWater;

public class ContainerWithMostWater {
    
    public static int maxArea(int[] height) {
        int l=0,r=height.length-1;
        int max = 0;
        while(l<r){
            if(height[l]<=height[r]){
                max= Math.max(max, (r-l)*height[l]);
                l++;
            } else{
                max=Math.max(max, (r-l)*height[r]);
                r--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int [] height = {1,1};
        System.out.println(maxArea(height));
    }
}
