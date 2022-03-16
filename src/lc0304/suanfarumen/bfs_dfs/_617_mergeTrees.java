package lc0304.suanfarumen.bfs_dfs;

import lc0304.TreeNode;

public class _617_mergeTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode root = new TreeNode(-1);

        if(root1 != null && root2 != null){
            root.val = root1.val + root2.val;
           root.left = mergeTrees(root1.left, root2.left);
           root.right = mergeTrees(root1.right, root2.right);
        }
        else  if(root1 != null && root2 == null){
            root.val = root1.val;
            root.left = mergeTrees(root1.left, null);
            root.right = mergeTrees(root1.right, null);
        }

        else  if(root1 == null && root2 != null){
            root.val = root2.val;
            root.left = mergeTrees(null, root2.left);
            root.right = mergeTrees(null, root2.right);
        } else {
            root = null;
        }
        return root;
    }
}
