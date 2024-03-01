package org.example;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    public static int[] search(List<Integer>[] graph, int startVertex) throws IllegalArgumentException {
        if (graph == null || startVertex < 0 || startVertex >= graph.length) {
            throw new IllegalArgumentException("Invalid graph or start vertex.");
        }

        boolean[] visited = new boolean[graph.length];
        List<Integer> result = new ArrayList<>();
        searchUtil(graph, startVertex, visited, result);
        return result.stream().mapToInt(i -> i).toArray();
    }

    private static void searchUtil(List<Integer>[] graph, int vertex, boolean[] visited, List<Integer> result) {
        visited[vertex] = true;
        result.add(vertex);

        for (int neighbor : graph[vertex]) {
            if (!visited[neighbor]) {
                searchUtil(graph, neighbor, visited, result);
            }
        }
    }
}
