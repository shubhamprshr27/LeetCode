package Trees.Medium;

import java.util.HashMap;

import utils.TreeNode;

public class ConstructBinaryTreeFromPreOrderAndPostOrder {
    int n;
    HashMap<Integer,Integer> preOrderSearch;
    HashMap<Integer,Integer> postOrderSearch;

    public TreeNode constructTree(int[] preorder, int[] postorder, int start, int end){
        if(start>end) return null; //base case
        TreeNode node = new TreeNode(preorder[start]);
        if(start==end) return node; //leaf node.
        //Searching idea was great, the issue happened 
        //when you forgot that the value will keep changing
        //and not be controlled via simple increments/decrements.
        //index_pre.get(post[index_post.get(pre[start])-1]);
        int middle = preOrderSearch.get(postorder[postOrderSearch.get(preorder[start])-1]); 
        node.left = constructTree(preorder, postorder, start+1, middle-1);
        node.right = constructTree(preorder, postorder, middle, end);
        return node;
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        n =postorder.length;
        postOrderSearch = new HashMap<>();
        preOrderSearch = new HashMap<>();
        for(int i=0;i<n;i++){
            postOrderSearch.put(postorder[i],i);
            preOrderSearch.put(preorder[i], i);
        }
        return constructTree(preorder, postorder, 0, n-1);
    }
    public static void main(String[] args) {
        int [] preorder={1,2,4,5,3,6,7};
        int [] postorder = {4,5,2,6,7,3,1};
        new ConstructBinaryTreeFromPreOrderAndPostOrder().constructFromPrePost(preorder,postorder);
    }
}
