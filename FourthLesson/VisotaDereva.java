package FourthLesson;

package FourthLesson;

import javax.swing.tree.TreeNode;

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
            String[] numbers = line.split(" ");
            for (String numStr : numbers) {
                int num = Integer.parseInt(numStr);
                if (num == 0) break;
                insert(num);
            }
            if (line.contains("0")) break;
        }

        int height = getHeight(root);
        writer.write(String.valueOf(height));
        writer.newLine();

        reader.close();
        writer.close();
    }

    private static void insert(int value) {
        root = insertRec(root, value);
    }

    private static TreeNode insertRec(TreeNode current, int value) {
        if (current == null) {
            return new TreeNode(value);
        }

        if (value < current.value) {
            current.left = insertRec(current.left, value);
        } else if (value > current.value) {
            current.right = insertRec(current.right, value);
        }
        return current;
    }

    private static int getHeight(TreeNode node) {
        if (node == null) {
            return -1;
        }
        var leftHeight = getHeight(node.left);
        var rightHeight = getHeight(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}