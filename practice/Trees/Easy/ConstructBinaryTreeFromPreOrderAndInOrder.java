package Trees.Easy;


import java.util.HashMap;

import utils.TreeNode;

public class ConstructBinaryTreeFromPreOrderAndInOrder {
    public HashMap<Integer,Integer> map;
    public int preOrderIdx = 0;

    public TreeNode buildTreeUtil(int [] preOrder, int[] inOrder,int inOrderStart, int inOrderEnd){
        if(inOrderStart>inOrderEnd) return null;
        int val = preOrder[preOrderIdx];
        TreeNode node = new TreeNode(val);
        preOrderIdx++;
        if(inOrderStart == inOrderEnd) return node;

        int inOrderIdx = map.get(val);
        node.left = buildTreeUtil(preOrder, inOrder, inOrderStart, inOrderIdx-1);
        node.right = buildTreeUtil(preOrder, inOrder, inOrderIdx+1, inOrderEnd);
        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        int size = inorder.length;
        for(int i=0;i<size;i++) map.put(inorder[i],i);
        return buildTreeUtil(preorder, inorder, 0, size-1);
    }

    public static void main(String[] args) {
        int [] preorder = {3,9,20,15,7};
        int [] inorder = {9,3,15,20,7};
        new ConstructBinaryTreeFromPreOrderAndInOrder().buildTree(preorder, inorder);
    }
}
