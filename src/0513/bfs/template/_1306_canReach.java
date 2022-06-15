package bfs.template;

import java.util.LinkedList;
import java.util.Queue;

public class _1306_canReach {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList<>();
        int n = arr.length;
        boolean[] visited = new boolean[n];
        if (arr[start] == 0) {
            return true;
        }
        queue.offer(start);
        while (!queue.isEmpty()) {
            Integer crr = queue.poll();
            if (crr + arr[crr] < n && !visited[crr + arr[crr]]) {
                if (arr[crr + arr[crr]] == 0) {
                    return true;
                }
                queue.offer(crr + arr[crr]);
                visited[crr + arr[crr]] = true;
            }

            if (crr - arr[crr] >= 0 && !visited[crr - arr[crr]]) {
                if (arr[crr - arr[crr]] == 0) {
                    return true;
                }
                queue.offer(crr - arr[crr]);
                visited[crr - arr[crr]] = true;
            }
        }
        return false;
    }
}
