package FifthLesson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    private static int[][] graph;
    private static boolean[] visited;
    private static int[] parent;
    private static int n;
    private static int cycleStart = -1; // Начало цикла

    private static boolean dfs(int v) {
        visited[v] = true;

        for (int u = 0; u < n; u++) {
            if (graph[v][u] == 1) {
                if (!visited[u]) {
                    parent[u] = v;
                    if (dfs(u)) {
                        return true;
                    }
                } else if (u != parent[v]) {
                    cycleStart = u;
                    parent[u] = v;
                    return true;
                }
            }
        }
        return false;
    }

    private static void printCycle(int start) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder cycle = new StringBuilder();
        int current = start;

        do {
            cycle.append((current + 1)).append(" ");
            current = parent[current];
        } while (current != start && current != -1);

        cycle.append((start + 1));

        writer.write("YES\n");
        writer.write(String.valueOf(cycle.toString().trim().split(" ").length) + "\n");
        writer.write(cycle.toString().trim() + "\n");
        writer.flush();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        graph = new int[n][n];
        visited = new boolean[n];
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(line[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (dfs(i)) {
                    printCycle(cycleStart);
                    reader.close();
                    writer.close();
                    return;
                }
            }
        }

        writer.write("NO\n");
        writer.flush();

        reader.close();
        writer.close();
    }
}