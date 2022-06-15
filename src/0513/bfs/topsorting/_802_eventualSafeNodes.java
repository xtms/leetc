package bfs.topsorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/find-eventual-safe-states/
 * 解题思路：
 * 1. 使用出度，查询出终端节点
 * 2. 记录每个节点的被依赖节点，进行bfs
 * 3. 最后根据出度是否为 0, 记录对应的节点。
 *
 * 为什么出度为0就是所求得节点：根据题意，每个节点不管怎么走都会到终端节点，称为安全节点。
 * 则在BFS过程中进行减去操作的时候，把所有此节点依赖的边全部去除，经过此节点无环存在，则此节点满足要求。
 */
public class _802_eventualSafeNodes {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int [] outDgree = new int[n]; //每个节点的出度，找到终端节点
        List<Integer> [] nodeByDepenc = new ArrayList[n];

        for (int i = 0; i < n; i++){
            nodeByDepenc[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++){
            for (int y : graph[i]){
                nodeByDepenc[y].add(i);
            }
            outDgree[i] = graph[i].length;
        }
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < outDgree.length; i++){
            if (outDgree[i] == 0){
                queue.offer(i);
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()){
            int crr = queue.poll();
            for (int child : nodeByDepenc[crr]){ // 遍历所有上游节点，去除上游节点的出度边
                if (--outDgree[child] == 0){
                    queue.offer(child);
                }
            }
        }

        for (int i = 0; i < n; i++){
            if (outDgree[i] == 0){
                ans.add(i);
            }
        }
        return ans;
    }

}
