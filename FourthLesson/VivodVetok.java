package FourthLesson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
    }
}

class BinarySearchTree {
    private TreeNode root;

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private TreeNode insertRec(TreeNode node, int value) {
        if (node == null) {
            return new TreeNode(value);
        }

        if (value < node.value) {
            node.left = insertRec(node.left, value);
        } else if (value > node.value) {
            node.right = insertRec(node.right, value);
        }

        return node;
    }

    public List<Integer> getNodesWithOneChild() {
        List<Integer> result = new ArrayList<>();
        findNodesWithOneChild(root, result);
        return result;
    }

    private void findNodesWithOneChild(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        if ((node.left == null && node.right != null) || (node.left != null && node.right == null)) {
            result.add(node.value);
        }

        findNodesWithOneChild(node.left, result);
        findNodesWithOneChild(node.right, result);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        BinarySearchTree bst = new BinarySearchTree();


        String line = reader.readLine();
        String[] numbers = line.split(" ");

        // Обработка чисел
        for (String numberStr : numbers) {
            int number = Integer.parseInt(numberStr);
            if (number == 0) break;
            bst.insert(number);
        }


        List<Integer> nodesWithOneChild = bst.getNodesWithOneChild();
        Collections.sort(nodesWithOneChild);


        for (Integer value : nodesWithOneChild) {
            writer.write(value + "\n");
        }

        writer.flush();
        reader.close();
        writer.close();
    }
}
