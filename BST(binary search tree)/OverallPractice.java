import java.sql.RowId;
import java.util.*;

public class OverallPractice {
    static class node {
        int data;
        node left;
        node right;

        public node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static node insert(node root, int val) {
        if (root == null) {
            root = new node(val);
            return root;
        }
        if (root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static void inorder(node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void printInRage(node root, int k1, int k2) {
        if (root == null) {
            return;
        }
        printInRage(root.left, k1, k2);
        if (root.data >= k1 && root.data <= k2) {
            System.out.print(root.data + " ");
        }
        printInRage(root.right, k1, k2);
    }

    public static void printInRage2(node root, int k1, int k2) {
        if (root == null) {
            return;

        }
        if (root.data >= k1 && root.data <= k2) {
            printInRage2(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRage2(root.right, k1, k2);
        } else if (root.data < k1) {
            printInRage2(root.right, k1, k2);
        } else {
            printInRage2(root.left, k1, k2);
        }

    }

    public static boolean valid(node root, node min, node max) {
        if (root == null) {
            return true;
        }
        if (min != null && min.data >= root.data) {
            return false;
        }
        if (max != null && max.data <= root.data) {
            return false;
        }

        return valid(root.left, min, root) && valid(root.right, root, max);

    }

    static class Info {
        boolean isvalid;
        int size;
        int min;
        int max;

        public Info(boolean isvalid, int size, int min, int max) {
            this.isvalid = isvalid;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxLength = 0;

    public static Info calculateMAXIMUMBST(node root) {
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Info left = calculateMAXIMUMBST(root.left);
        Info right = calculateMAXIMUMBST(root.right);
        int size = left.size + right.size + 1;
        int min = Math.min(left.min, Math.min(right.min, root.data));
        int max = Math.max(root.data, Math.max(left.max, right.max));

        if (root.data <= left.max || right.min <= root.data) {
            return new Info(false, size, min, max);
        }
        if (left.isvalid && right.isvalid) {
            maxLength = Math.max(size, maxLength);
            // System.out.println(maxLength);
            return new Info(true, size, min, max);
        }

        return new Info(false, size, min, max);
    }

    public static void main(String[] args) {
        int arr[] = { 6, 2, 1, 4, 3, 5, 8, 7, 9 };
        node root = null;
        for (int i = 0; i < arr.length; i++) {
            root = insert(root, arr[i]);
        }
        inorder(root);
        System.out.println();
        printInRage(root, 3, 8);
        System.out.println();
        System.out.println();
        printInRage2(root, 3, 8);
        System.out.println("check is it valid bst or not");
        System.out.println(valid(root, null, null));
        // shall we calculate size of the maximum BST in BT
        System.out.println("maximu length");
        calculateMAXIMUMBST(root);
        System.out.println(maxLength);
     HashMap<Integer,Integer> map=new HashMap<>();
    }

}
