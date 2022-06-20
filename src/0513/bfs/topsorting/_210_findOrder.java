package bfs.topsorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _210_findOrder {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        int count = 0;
        int[] inDegree = new int[numCourses];
        List<Integer>[] adjRelatio = new ArrayList[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adjRelatio[i] = new ArrayList<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++; // 节点的入度,是被依赖节点的入度，被依赖节点才能评估是否进行下一轮搜索
            adjRelatio[prerequisites[i][1]].add(prerequisites[i][0]); // 节点的下游节点
        }

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int crr = queue.poll();
            ans[count++] = crr; // 放到结果数组中
            for (int v : adjRelatio[crr]) {
                if (--inDegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        if (count == numCourses)  { // 判断是否有环
            return ans;
        }
        return new int[0];
    }
}
