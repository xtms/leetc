package bfs.topsorting;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class _1136_minimumSemesters {
    public int minimumSemesters(int n, int[][] relations) {
        int step = 0;
        Set<Integer>[] adjRelation = new HashSet[n+1];
        Queue<Integer> queue = new LinkedList<>();
        for (int i= 0; i < adjRelation.length; i++){
            adjRelation[i] = new HashSet<>();
        }
        int [] adj = new int[n+1];
        for (int [] relat : relations){
            adj[relat[1]]++; // 记录入度
            adjRelation[relat[0]].add(relat[1]); // 记录依赖关系
        }

        for (int i = 1; i < adj.length; i++){
            if (adj[i] == 0){
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer crr = queue.poll();
                Set<Integer> childSet = adjRelation[crr];
                for (int child : childSet) {
                    if (--adj[child] == 0) {
                        queue.offer(child);
                    }
                }
            }
            step++;
        }
        for (int i = 1; i < adj.length; i++) {
            if (adj[i] > 0) { // 说明有环
                return -1;
            }
        }
        return step;
    }
}
