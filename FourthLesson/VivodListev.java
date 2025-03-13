package FourthLesson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

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
                insert(num);
            }
            if (line.contains("0")) break;
        }

        ArrayList<Integer> leaves = new ArrayList<>();
        findLeaves(root, leaves); // Поиск всех листьев

        Collections.sort(leaves);
        for (int leaf : leaves) {
            writer.write(String.valueOf(leaf));
            writer.newLine();
        }

        reader.close();
        writer.close();
    }

    private static void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
            return;
        }
        insertRec(root, value);
    }
    private static void insertRec(TreeNode current, int value) {
        if (value < current.value) {
            if (current.left == null) {
                current.left = new TreeNode(value);
            } else {
                insertRec(current.left, value);
            }
        } else if (value > current.value) {
            if (current.right == null) {
                current.right = new TreeNode(value);
            } else {
                insertRec(current.right, value);
            }
        }
    }

    private static void findLeaves(TreeNode node, ArrayList<Integer> leaves) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                leaves.add(node.value);
            }
            findLeaves(node.left, leaves);
            findLeaves(node.right, leaves);
        }
    }
}