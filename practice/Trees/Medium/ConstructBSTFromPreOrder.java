package Trees.Medium;

import utils.TreeNode;

/**
 * Date: 1st Feb 2022.
 * Difficulty: Medium.
 * Attempts: 2
 */

public class ConstructBSTFromPreOrder {
    int idx= 0;

    public TreeNode makeTree(int max, int [] preorder){
        int rootValue = preorder[idx++];
        TreeNode root = new TreeNode(rootValue);
        if(idx==preorder.length) return new TreeNode(rootValue);
        
        if(idx<preorder.length && preorder[idx]<rootValue)
            root.left = makeTree(rootValue, preorder);
        if(idx<preorder.length && preorder[idx]>rootValue && preorder[idx]<max)
            root.right = makeTree(max, preorder);
        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return makeTree(1001, preorder);
    }

    public static void main(String[] args) {
        int [] preorder = {8,5,1,7,10,12};
        new ConstructBSTFromPreOrder().bstFromPreorder(preorder);
    }
}
