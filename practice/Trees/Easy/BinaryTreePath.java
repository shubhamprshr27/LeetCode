package Trees.Easy;

import java.util.ArrayList;
import java.util.List;

import utils.TreeNode;

public class BinaryTreePath {
    List<String> ans;

    public void findBinaryTreePaths(TreeNode root, String path){
        if(root==null) return;
        path+=String.valueOf(root.val);
        if(root.left==null && root.right==null) ans.add(path); //Quick hack to avoid the String.SubString();
        path+="->";
        findBinaryTreePaths(root.left, path);
        findBinaryTreePaths(root.right, path);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        ans = new ArrayList<>();
        findBinaryTreePaths(root, "");
        return ans;
    }
}
