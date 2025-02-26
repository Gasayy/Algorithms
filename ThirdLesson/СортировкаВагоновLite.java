package ThirdLesson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine().trim());
        String[] inputCars = reader.readLine().trim().split(" ");
        int[] cars = new int[N];

        for (int i = 0; i < N; i++) {
            cars[i] = Integer.parseInt(inputCars[i]);
        }

        if (canArrangeCars(N, cars)) {
            writer.write("YES");
        } else {
            writer.write("NO");
        }
        writer.newLine();

        reader.close();
        writer.close();
    }

    private static boolean canArrangeCars(int N, int[] cars) {
        Stack<Integer> stack = new Stack<>();
        int expected = 1;

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && stack.peek() == expected) {
                stack.pop();
                expected++;
            }
            if (cars[i] == expected) {
                expected++;
            } else {
                stack.push(cars[i]);
            }
        }

        while (!stack.isEmpty() && stack.peek() == expected) {
            stack.pop();
            expected++;
        }

        return expected == N + 1;
    }
}