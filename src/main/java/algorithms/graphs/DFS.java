package algorithms.graphs;

import java.util.*;
import java.util.logging.*;

/*

    https://www.geeksforgeeks.org/dsa/depth-first-search-or-dfs-for-a-graph/

 * DFS (Depth-First Search): Traverses a graph by exploring as far as possible along each branch before backtracking
 * Can be implemented recursively or iteratively using an explicit Stack
 * Useful for: cycle detection, topological sorting, connected components, mazes.
 * Complexity: O(V + E) — Vertices plus Edges

*/

public class DFS {

    private static final Logger LOGGER = Logger.getLogger(DFS.class.getName());

    // Public wrapper for recursive traversal
    public static List<String> traverseRecursive(Map<String, List<String>> graph, String startNode) {

        // If the graph is null, the start node is null, or the start node is not in the graph, return an empty list
        if (graph == null || startNode == null || !graph.containsKey(startNode)) {
            return List.of();
        }

        // Initialize data structures for DFS
        List<String> visitedOrder = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        dfsRecursive(graph, startNode, visited, visitedOrder);
        return visitedOrder;
    }

    // Helper method for recursive DFS
    private static void dfsRecursive(Map<String, List<String>> graph, String current, Set<String> visited, List<String> visitedOrder) {

        // Mark the current node as visited and add it to the visited order
        visited.add(current);
        visitedOrder.add(current);

        // Recursively visit all unvisited neighbors of the current node
        for (String neighbor : graph.getOrDefault(current, List.of())) {
            if (!visited.contains(neighbor)) {
                dfsRecursive(graph, neighbor, visited, visitedOrder);
            }
        }
    }

    // Iterative version using an explicit stack (prevents call stack overflow)
    public static List<String> traverseIterative(Map<String, List<String>> graph, String startNode) {

        // If the graph is null, the start node is null, or the start node is not in the graph, return an empty list
        if (graph == null || startNode == null || !graph.containsKey(startNode)) {
            return List.of();
        }

        List<String> visitedOrder = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Deque<String> stack = new ArrayDeque<>();

        // Start the DFS traversal by pushing the start node onto the stack
        stack.push(startNode);

        // While there are nodes to process in the stack, continue the DFS traversal
        while (!stack.isEmpty()) {
            String current = stack.pop();
            if (visited.contains(current)) {
                continue;
            }

            // Mark the current node as visited and add it to the visited order
            visited.add(current);
            visitedOrder.add(current);

            // Get the neighbors of the current node, defaulting to an empty list if none exist
            List<String> neighbors = graph.getOrDefault(current, List.of());

            // Iterated in reverse to maintain "natural" left-to-right order with a stack
            for (int i = neighbors.size() - 1; i >= 0; i--) {
                if (!visited.contains(neighbors.get(i))) {
                    stack.push(neighbors.get(i));
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

        // Perform DFS traversal starting from node "A" using the recursive method
        List<String> recursiveOrder = traverseRecursive(graph, "A");
        LOGGER.log(Level.INFO, "Recursive DFS Traversal starting from ''A'': {0}", recursiveOrder);

        // Perform DFS traversal starting from node "A" using the iterative method
        List<String> iterativeOrder = traverseIterative(graph, "A");
        LOGGER.log(Level.INFO, "Iterative DFS Traversal starting from ''A'': {0}", iterativeOrder);
    }
}