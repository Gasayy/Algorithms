package FourthLesson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<Integer> set = new TreeSet<>();
        String line;

        while ((line = reader.readLine()) != null) {
            String[] numbers = line.split(" ");
            for (String number : numbers) {
                var num = Integer.parseInt(number);
                if (num == 0) break;
                set.add(num);
            }
            if (numbers[numbers.length - 1].equals("0")) break;
        }

        for (var number : set) {
            writer.write(number + "\n");
        }

        writer.flush();
        writer.close();
        reader.close();
    }
}