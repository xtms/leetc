package bfs.template;

import lc0304.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree_template {
    // 树的层序遍历
    public List<List<Integer>> levelOrder(TreeNode treeNode) {
        List<List<Integer>> ans = new ArrayList<>();
        if (treeNode == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(treeNode);
        while (!queue.isEmpty()) {
            int currt = queue.size();
            List<Integer> crLevelList = new ArrayList<>();
            for (int i = 0; i < currt; i++) {
                TreeNode front = queue.poll();
                crLevelList.add(front.val);
                if (front.left != null) {
                    queue.offer(front.left);
                }
                if (front.right != null) {
                    queue.offer(front.right);
                }
            }
            ans.add(crLevelList);
        }
        return ans;
    }
}
