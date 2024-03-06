import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    /** bfs will take an Adjacency List as input and return an array containing the order of nodes traversed via a Breadth First Search.
     *
     * @param graph - an Adjacency List
     * @return - an array containing the order of nodes traversed via a Breadth First Search.
     */
    public static int[] bfs(int[][] graph) {

        // Create a Queue and add the first node (0) to it. Use your Queue class that you just created!
        Queue<Integer> queue = new LinkedList<>();
        // Create a visited array. This array will track whether we have visited a specific node.
        boolean[] visited = new boolean[graph.length];
        // Create a bfs path array and a bfs path index. This array will track the order that the nodes were visited.
        int[] path = new int[graph.length];
        int pathIndex = 0;
        // Add the first node (0) to the bfs array.
        queue.add(0);
        // Record the first node (0) as visited.
        visited[0] = true;
        // Time to traverse the graph! While the queue is not empty ...
        while(!queue.isEmpty()){
            int currentNode = queue.poll();
            visited[currentNode] = true;
            path[pathIndex++] = currentNode;
            int[] neighbors = graph[currentNode];
            for (int neighbor : neighbors) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return path;
    }
}
