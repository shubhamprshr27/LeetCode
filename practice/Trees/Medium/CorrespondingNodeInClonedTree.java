package Trees.Medium;

import utils.TreeNode;
/**
 * Question solved: 31st Jan 2022.
 * Attempts: 1
 */
public class CorrespondingNodeInClonedTree {
    TreeNode node;
    public void findTarget(final TreeNode cloned, final TreeNode target){
        if(cloned==null) return;
        if(target.val==cloned.val){
            node = cloned;
            return;
        }
        findTarget(cloned.left, target);
        findTarget(cloned.right, target);
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        findTarget(cloned, target);
        return node;
    }
}
