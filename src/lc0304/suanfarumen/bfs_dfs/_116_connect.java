package lc0304.suanfarumen.bfs_dfs;

import lc0304.Node;
import lc0304.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _116_connect {
    public Node connect(Node root) { // 层序遍历
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node treeNode = queue.poll(); // 第一个拿出来
                if (i < size - 1) { //每一层进行连接
                    treeNode.next = queue.peek();
                }
                if (treeNode != null && treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode != null && treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
        }
        return root;
    }
}
