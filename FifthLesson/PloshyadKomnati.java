package FifthLesson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static char[][] labyrinth;
    static boolean[][] visited;
    static int N;
    static int area = 0;

    public static void dfs(int x, int y) {

        if (x < 0 || x >= N || y < 0 || y >= N || visited[x][y] || labyrinth[x][y] == '*') {
            return;
        }
        visited[x][y] = true;
        area++;

        dfs(x - 1, y);
        dfs(x + 1, y);
        dfs(x, y - 1);
        dfs(x, y + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(reader.readLine());
        labyrinth = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            labyrinth[i] = reader.readLine().toCharArray();
        }

        String[] coords = reader.readLine().split(" ");
        int startX = Integer.parseInt(coords[0]) - 1; // 1-based to 0-based
        int startY = Integer.parseInt(coords[1]) - 1; // 1-based to 0-based

        dfs(startX, startY);

        writer.write(String.valueOf(area) + "\n");

        writer.flush();
        reader.close();
        writer.close();
    }
}