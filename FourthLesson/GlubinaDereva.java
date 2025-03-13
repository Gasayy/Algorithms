package FourthLesson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class TreeNode {
    int value;
    TreeNode left, right;

    TreeNode(int value) {
        this.value = value;
        left = right = null;
    }
}

public class Main {
    private static TreeNode root;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        while ((line = reader.readLine()) != null) {
            String[] numbers = line.split("\\s+");
            for (String numStr : numbers) {
                int num = Integer.parseInt(numStr);
                if (num == 0) break;
                int depth = insert(num);
                if (depth != -1) {
                    writer.write(String.valueOf(depth));
                    writer.newLine();
                }
            }
            if (line.contains("0")) break;
        }

        reader.close();
        writer.close();
    }

    private static int insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
            return 1;
        }
        return insertRec(root, value, 1);
    }

    private static int insertRec(TreeNode current, int value, int depth) {
        if (value == current.value) {
            return -1;
        }
        if (value < current.value) {
            if (current.left == null) {
                current.left = new TreeNode(value);
                return depth + 1;
            }
            return insertRec(current.left, value, depth + 1);
        } else {
            if (current.right == null) {
                current.right = new TreeNode(value);
                return depth + 1;
            }
            return insertRec(current.right, value, depth + 1);
        }
    }
}