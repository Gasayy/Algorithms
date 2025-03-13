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

        int secondLargest = findSecondLargest(root);
        writer.write(String.valueOf(secondLargest));
        writer.newLine();

        writer.flush();
        writer.close();
        reader.close();
    }

    private static void insert(int value) {
        root = insertRec(root, value);
    }

    private static TreeNode insertRec(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else {
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    private static int findSecondLargest(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException("Дерево пусто");
        }

        TreeNode current = root;
        TreeNode parent = null;

        while (current.right != null) {
            parent = current;
            current = current.right;
        }

        if (current.left != null) {
            current = current.left;
            while (current.right != null) {
                current = current.right;
            }
            return current.value;
        }

        return parent.value;
    }
}