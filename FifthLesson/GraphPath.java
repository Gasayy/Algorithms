package FifthLesson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static class Node {
        int vertex;
        Node parent;

        Node(int vertex, Node parent) {
            this.vertex = vertex;
            this.parent = parent;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine());
        int[][] adjMatrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] line = reader.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                adjMatrix[i][j] = Integer.parseInt(line[j]);
            }
        }

        String[] endpoints = reader.readLine().split(" ");
        int start = Integer.parseInt(endpoints[0]) - 1; // 1-based to 0-based
        int end = Integer.parseInt(endpoints[1]) - 1;   // 1-based to 0-based

        int pathLength = findShortestPath(adjMatrix, N, start, end, writer);

        writer.flush();
        reader.close();
        writer.close();
    }

    static int findShortestPath(int[][] adjMatrix, int N, int start, int end, BufferedWriter writer) throws IOException {
        boolean[] visited = new boolean[N];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, null));
        visited[start] = true;

        Node lastNode = null;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.vertex == end) {
                lastNode = current;
                break;
            }
            for (int i = 0; i < N; i++) {
                if (adjMatrix[current.vertex][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(new Node(i, current));
                }
            }
        }

        if (lastNode == null) {
            writer.write("-1\n");
            return -1;
        }

        StringBuilder path = new StringBuilder();
        int length = 0;
        for (Node node = lastNode; node != null; node = node.parent) {
            path.insert(0, (node.vertex + 1) + " "); // 1-based
            length++;
        }

        writer.write((length - 1) + "\n" + path.toString().trim() + "\n");
        return length - 1;
    }
}