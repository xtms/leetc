package bfs.topsorting;

public class Notice {

    // 拓扑排序（Topological Sorting）是一种应用在「有向无环图（DAG，Directed Acyclic Graph）」上，给出结点输出先后顺序的算法。
    // 拓扑排序不是给出大小关系的排序，而是给出先后顺序的一种算法

    // 用「深度优先遍历」得到拓扑序，须要在遍历的过程中检测有向图是否存在环；
    // 而应用「广度优先遍历」，我们只需要在有向图中执行一次广度优先遍历，在结束以后，就能够得到这个有向图是不是存在环，在不存在环的时候，输出拓扑排序的结果。也就是说，广度优先遍历还可以帮助我们检测有向图是否存在环。

    // https://leetcode.cn/problems/sort-items-by-groups-respecting-dependencies/solution/1203-xiang-mu-guan-li-by-leetcode-t63b/
}
