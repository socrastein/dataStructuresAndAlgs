import java.util.Arrays;

public class BinarySearchTree {
    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }


    private Node buildTree(int[] array, int start, int end) {
        // Base case
        if (start > end){
            return null;
        }

        int middleIndex = (start + end) / 2;
        Node node = new Node(array[middleIndex]);

        node.left = buildTree(array, start, middleIndex - 1);
        node.right = buildTree(array, middleIndex + 1, end);

        return node;
    }

    private Node root;

    public BinarySearchTree(int[] data) {
        Arrays.sort(data);
        System.out.println(Arrays.toString(data));
        this.root = buildTree(data, 0, data.length - 1);
    }

    private void prettyPrint(Node node, String prefix, Boolean isLeft){
        if (node == null) {
            return;
        }

        if (node.right != null) {
            prettyPrint(node.right, prefix + (isLeft ? "|   " : "    "), false);
        }
        System.out.println(prefix + (isLeft ? "└── " : "┌── ") + node.value);
        if (node.left != null) {
            prettyPrint(node.left, prefix + (isLeft ? "    " : "|   "), true);
        }
    }

    private void prettyPrint(Node node){
        prettyPrint(node, "", true);
    }

    public static void main(String[] args) {
        int[] sampleData = {0, 23, 4, 18, 274, 33, 40, 8, 11, 105};
        BinarySearchTree tree = new BinarySearchTree(sampleData);
        tree.prettyPrint(tree.root);
    }
}
