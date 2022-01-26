package StudyPlans.DS1.Day11;
import utils.TreeNode;

public class SymmetricTree {
    public boolean isSymmetricUtil(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left!=null && right!=null && left.val==right.val) return isSymmetricUtil(left.left, right.right) && isSymmetricUtil(left.right, right.left);
        return false;
    }
    
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricUtil(root.left, root.right);
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1, new TreeNode(2, new TreeNode(2), null), new TreeNode(2, new TreeNode(2), null));
        System.out.println((new SymmetricTree().isSymmetric(head)));
    }
}
