package Trees.Easy;

import java.util.HashMap;

import utils.TreeNode;

public class ConstructBinaryTreeFromPostOrderAndInOrder {
    public HashMap<Integer,Integer> map;
    public int postOrderIdx;

    public TreeNode buildTreeUtil(int [] postOrder, int[] inOrder,int inOrderStart, int inOrderEnd){
        if(inOrderStart>inOrderEnd) return null;
        int val = postOrder[postOrderIdx];
        TreeNode node = new TreeNode(val);
        postOrderIdx--;
        if(inOrderStart == inOrderEnd) return node;

        int inOrderIdx = map.get(val);
        node.right = buildTreeUtil(postOrder, inOrder, inOrderIdx+1, inOrderEnd);
        node.left = buildTreeUtil(postOrder, inOrder, inOrderStart, inOrderIdx-1);
        return node;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        int size = inorder.length;
        postOrderIdx = size-1;
        for(int i=0;i<size;i++) map.put(inorder[i],i);
        return buildTreeUtil(postorder, inorder, 0, size-1);
    }
}
