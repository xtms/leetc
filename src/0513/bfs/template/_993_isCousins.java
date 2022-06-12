package bfs.template;

import lc0304.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _993_isCousins {
    TreeNode xParent;
    TreeNode yParent;
    int xDepath;
    int yDepath;
    int xValue;
    int yValue;
    boolean xFound = false;
    boolean yFound = false;
    public boolean isCousins(TreeNode root, int x, int y) {
        xValue = x;
        yValue = y;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> depthQueue = new LinkedList<>();
        updateValue(root, null, 0);
        depthQueue.offer(0);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode crr = queue.poll();
            int crrDepth = depthQueue.poll();
            if (crr.left != null) {
                queue.offer(crr.left);
                depthQueue.offer(crrDepth+1);
                updateValue(crr.left, crr, crrDepth + 1);
            }
            if (crr.right != null) {
                queue.offer(crr.right);
                depthQueue.offer(crrDepth+1);
                updateValue(crr.right, crr, crrDepth + 1);
            }
            if(xFound && yFound){
                break;
            }
        }
        if (xParent != yParent && xDepath == yDepath){
            return true;
        }
        // 查找x和y节点在树种的depth
        // 判断是否是同父节点
        return false;
    }

    public void updateValue(TreeNode crr, TreeNode parent, int depth) {
        if (crr.val == xValue) {
            xParent = parent;
            xDepath = depth;
            xFound = true;
        }
        if (crr.val == yValue) {
            yParent = parent;
            yDepath = depth;
            yFound = true;
        }
    }
}
