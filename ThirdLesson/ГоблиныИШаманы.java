package ThirdLesson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine().trim());
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String[] parts = reader.readLine().trim().split(" ");
            char command = parts[0].charAt(0);

            switch (command) {
                case '+':
                    int goblinNumber = Integer.parseInt(parts[1]);
                    queue.add(goblinNumber);
                    break;
                case '*':
                    goblinNumber = Integer.parseInt(parts[1]);
                    int midIndex = (queue.size() % 2 == 0) ? queue.size() / 2 : (queue.size() / 2) + 1;
                    queue.add(midIndex, goblinNumber);
                    break;
                case '-':
                    int goblinToLeave = queue.poll();
                    writer.write(goblinToLeave + "\n");
                    break;
            }
        }

        reader.close();
        writer.close();
    }
}