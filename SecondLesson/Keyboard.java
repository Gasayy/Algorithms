package SecondLesson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[] durability = new int[n];

        String[] durabilityInput = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            durability[i] = Integer.parseInt(durabilityInput[i]);
        }

        int k = Integer.parseInt(reader.readLine());
        int[] pressCount = new int[n];

        String[] pressInput = reader.readLine().split(" ");
        for (int i = 0; i < k; i++) {
            int key = Integer.parseInt(pressInput[i]);
            pressCount[key - 1]++;
        }

        for (int i = 0; i < n; i++) {
            if (pressCount[i] > durability[i]) {
                writer.write("YES");
            } else {
                writer.write("NO");
            }
            writer.newLine();
        }

        reader.close();
        writer.close();
    }
}
