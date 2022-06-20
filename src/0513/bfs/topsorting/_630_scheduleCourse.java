package bfs.topsorting;

import java.util.Arrays;
import java.util.PrimitiveIterator;
import java.util.PriorityQueue;

public class _630_scheduleCourse {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]); // 先排序
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        int total = 0;

        for (int [] coure : courses){
            int ti = coure[0];
            int di = coure[1];

            //

            if (ti + total <= di){ // 如果开始的时间加上持续的事件，在完成线之前，则是满足的，则修改时间线的起点，同时把持续时间放到队里中
                total += ti;
                queue.offer(ti);
            } else if (!queue.isEmpty() && queue.peek() > ti){ // 如果 total + ti 超过了di，那就是当前的课程不满足了。 如果队列中还有比ti大的，就换出来。
                total -= queue.poll() - ti;
                queue.offer(ti);

            }
        }
        return queue.size(); // 遍历完后，存在队列中的就是可以同时选的课程，且不互斥
    }

}
