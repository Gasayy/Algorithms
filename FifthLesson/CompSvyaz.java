package FifthLesson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static List<Integer>[] graph;
    static boolean[] visited;
    static List<List<Integer>> components;

    public static void bfs(int start) {
        List<Integer> component = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            component.add(node);
            for (int neighbor : graph[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        components.add(component);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstLine = reader.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);

        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[n + 1];
        components = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] edge = reader.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                bfs(i);
            }
        }

        writer.write(components.size() + "\n");
        for (List<Integer> component : components) {
            writer.write(component.size() + "\n");
            for (int vertex : component) {
                writer.write(vertex + " ");
            }
            writer.newLine();
        }

        writer.flush();
        reader.close();
        writer.close();
    }
}