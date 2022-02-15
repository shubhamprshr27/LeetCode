package Trees.Medium;

import utils.TreeNode;

public class KthSmallestElement {
    int smallest = -1;
    int kThSmallest;
    int k;
    public void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);
        if(root.left==null && smallest==-1) smallest = root.val;
        if(--k==0){ 
            kThSmallest = root.val;
            return;
        }
        if(k>0)inOrder(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inOrder(root);
        //System.out.println(this.kThSmallest);
        return this.kThSmallest;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
        new KthSmallestElement().kthSmallest(root, 3);
    }
}
