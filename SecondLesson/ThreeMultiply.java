package SecondLesson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        // Чтение входных данных
        String[] parts = reader.readLine().split(" ");
        int n = parts.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }
        Arrays.sort(nums);

        long candidate1 = (long) nums[n - 1] * nums[n - 2] * nums[n - 3];
        long candidate2 = (long) nums[0] * nums[1] * nums[n - 1];

        if (candidate1 > candidate2) {
            writer.write(nums[n - 1] + " " + nums[n - 2] + " " + nums[n - 3]);
        } else {
            writer.write(nums[0] + " " + nums[1] + " " + nums[n - 1]);
        }
        writer.newLine();
        reader.close();
        writer.close();
    }
}