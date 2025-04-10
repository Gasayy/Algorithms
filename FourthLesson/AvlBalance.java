import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    int height;

    TreeNode(int value) {
        this.value = value;
        this.height = 1;
    }
}

class AVLTree {
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
        } else {
            return node;
        }

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        return balance(node);
    }

    private TreeNode balance(TreeNode node) {
        int balanceFactor = getBalance(node);

        if (balanceFactor > 1) {
            if (getBalance(node.left) < 0) {
                node.left = rotateLeft(node.left);
            }
            return rotateRight(node);
        }

        if (balanceFactor < -1) {
            if (getBalance(node.right) > 0) {
                node.right = rotateRight(node.right);
            }
            return rotateLeft(node);
        }

        return node;
    }

    private int getBalance(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    private int getHeight(TreeNode node) {
        return node == null ? 0 : node.height;
    }

    private TreeNode rotateRight(TreeNode y) {
        TreeNode x = y.left;
        TreeNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    private TreeNode rotateLeft(TreeNode x) {
        TreeNode y = x.right;
        TreeNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

        return y;
    }

    public boolean isBalanced() {
        return isBalancedRec(root);
    }

    private boolean isBalancedRec(TreeNode node) {
        if (node == null) {
            return true;
        }

        int balanceFactor = getBalance(node);
        return Math.abs(balanceFactor) <= 1 && isBalancedRec(node.left) && isBalancedRec(node.right);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        AVLTree tree = new AVLTree();
        String line;
        line = reader.readLine();
        String[] numbers = line.trim().split("\\s+");

        for (String num : numbers) {
            int number = Integer.parseInt(num);
            if (number == 0) {
                break;
            }
            tree.insert(number);
        }


        if (tree.isBalanced()) {
            writer.write("YES");
        } else {
            writer.write("NO");
        }

        writer.newLine();
        writer.flush();
        reader.close();
        writer.close();
    }
}