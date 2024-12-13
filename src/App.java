import java.io.File;
import java.io.FileNotFoundException;
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

        List<int[]> input = getInput(new File("input.txt"));
        List<int[]> operations = getOperations(new File("operations.txt"));

        System.out.println("Part 1: " + input);

    }

}
