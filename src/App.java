import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class App {

    // ---------- Utilities ----------

    public static List<int[]> getInput(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        List<int[]> arr = new ArrayList<>();
        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(" ");
            int[] intArr = new int[line.length];
            for (int i = 0; i < line.length; i++) {
                intArr[i] = Integer.parseInt(line[i]);
            }
            arr.add(intArr);
        }
        return arr;
    }

    public static List<int[]> getOperations(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        List<int[]> arr = new ArrayList<>();
        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split(" ");
            int[] intArr = new int[line.length];
            for (int i = 0; i < line.length; i++) {
                intArr[i] = Integer.parseInt(line[i]);
            }
            arr.add(intArr);
        }
        return arr;
    }

    public static void main(String[] args) throws Exception {

        File inputFile = new File("output.txt");
        FileWriter fw = new FileWriter(inputFile);
        PrintWriter pw = new PrintWriter(fw);

        List<int[]> input = getInput(new File("input.txt"));
        List<int[]> operations = getOperations(new File("operations.txt"));

        for (int i = 0; i < input.size(); i++) {
            BinaryTree tree = new BinaryTree();
            int[] data = input.get(i);

            pw.println("Processing dataset " + (i + 1));
            for (int value : data) {
                if (value == -999)
                    break;
                tree.insert(value);
            }

            pw.println("Inorder traversal:");
            tree.inorder(pw);
            pw.println("Preorder traversal:");
            tree.preorder(pw);
            pw.println("Postorder traversal:");
            tree.postorder(pw);
            pw.println("Node count: " + tree.count());
            tree.printChildren(pw);

            int[] ops = operations.get(i);
            for (int op : ops) {
                if (op > 0) {
                    tree.insert(op);
                } else {
                    tree.delete(-op);
                }
            }

            pw.println("===After operations===");
            pw.println("Inorder traversal:");
            tree.inorder(pw);
            pw.println("Preorder traversal:");
            tree.preorder(pw);
            pw.println("Postorder traversal:");
            tree.postorder(pw);
            pw.println("Node count: " + tree.count());
            tree.printChildren(pw);
            pw.println("=============================");
        }

        pw.close();
    }

}
