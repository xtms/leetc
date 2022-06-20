package dfs;

import lc0304.TreeNode;

/**
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/solution/236-er-cha-shu-de-zui-jin-gong-gong-zu-xian-hou-xu/
 *
 p 和 q 在 root 的子树中，且分列 root 的 异侧（即分别在左、右子树中）；
 p = root ，且 q 在 root 的左或右子树中；
 q = root ，且 p 在 root 的左或右子树中；
 */
public class _236_lowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }

}
