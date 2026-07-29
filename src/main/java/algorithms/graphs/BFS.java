package algorithms.graphs;

import java.util.*;
import java.util.logging.*;

/*

    https://www.geeksforgeeks.org/dsa/breadth-first-search-or-bfs-for-a-graph/

 * BFS (Breadth-First Search): Traverses a graph level by level using a Queue
 * Useful for finding the shortest path in unweighted graphs, social networks (friends of friends), minimum hop routes, etc...
 * Complexity: O(V + E) — Vertices plus Edges

*/

public class BFS {

    private static final Logger LOGGER = Logger.getLogger(BFS.class.getName());

    // BFS traversal of a graph starting from a given node
    public static List<String> traverse(Map<String, List<String>> graph, String startNode) {
        if (graph == null || startNode == null || !graph.containsKey(startNode)) {
            return List.of();
        }

        // Initialize data structures for BFS
        List<String> visitedOrder = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();

        queue.add(startNode);
        visited.add(startNode);

        // While there are nodes to process in the queue, continue the BFS traversal
        while (!queue.isEmpty()) {
            String current = queue.poll();
            visitedOrder.add(current);

            for (String neighbor : graph.getOrDefault(current, List.of())) {
                if (visited.add(neighbor)) {
                    queue.add(neighbor);
                }
            }
        }
        return visitedOrder;
    }

    public static void main() {

        // Undirected graph represented as an adjacency list
        Map<String, List<String>> graph = Map.of(
                "A", List.of("B", "C"),
                "B", List.of("A", "D", "E"),
                "C", List.of("A", "F"),
                "D", List.of("B"),
                "E", List.of("B", "F"),
                "F", List.of("C", "E")
        );

        // Perform BFS traversal starting from node "A"
        List<String> result = traverse(graph, "A");
        LOGGER.log(Level.INFO, "BFS Traversal starting from ''A'': {0}", result);
    }
}