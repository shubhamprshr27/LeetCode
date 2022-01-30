package Trees.Easy;


import utils.TreeNode;

public class RecoverBinarySearchTree {
    
    public void swap(TreeNode node1, TreeNode node2){
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp; 
    }

    public boolean invalidBST(TreeNode root, long min, long max){
        return root.val<min || root.val>max;
    }

    public TreeNode recoverTreeUtil(TreeNode root,long min, long max){
        if(root==null) return null;
        if(invalidBST(root, min, max)) return root;

        TreeNode left = recoverTreeUtil(root.left, min, root.val);
        TreeNode right = recoverTreeUtil(root.right, root.val, max);

        if(left!=null && invalidBST(left, min, max)) return left;
        else if(right!=null && invalidBST(right, min, max)) return right;

        if((left!=null && left.val>root.val) && right!=null && right.val<root.val) swap(left,right);
        else if(left!=null && left.val>root.val) swap(root, left);
        else if(right!=null && right.val<root.val) swap(root,right);
        return root;
    }

    public void recoverTree(TreeNode root) {
        recoverTreeUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
        TreeNode.printTree(root);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,new TreeNode(1), new TreeNode(4, new TreeNode(2), null));
        new RecoverBinarySearchTree().recoverTree(root);
    }
}
