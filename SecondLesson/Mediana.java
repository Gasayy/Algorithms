package SecondLesson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstLine = reader.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int L = Integer.parseInt(firstLine[1]);

        int[][] sequences = new int[N][L];
        for (int i = 0; i < N; i++) {
            String[] sequence = reader.readLine().split(" ");
            for (int j = 0; j < L; j++) {
                sequences[i][j] = Integer.parseInt(sequence[j]);
            }
        }

        ArrayList<Integer> medians = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int[] merged = new int[2 * L];
                System.arraycopy(sequences[i], 0, merged, 0, L);
                System.arraycopy(sequences[j], 0, merged, L, L);
                Arrays.sort(merged);
                medians.add(merged[L - 1]);
            }
        }

        for (int median : medians) {
            writer.write(String.valueOf(median));
            writer.newLine();
        }

        writer.flush();
        writer.close();
        reader.close();
    }
}