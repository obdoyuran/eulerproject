import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EulerProblem67 {

    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader("resources/p067_triangle.txt"));
            String line;
            List<List<Integer>> listOfList = new ArrayList<>();
            while ((line = in.readLine()) != null) {
                listOfList.add(Arrays.stream(line.split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
            }
            Integer temp;
            long start = System.nanoTime();
            for (int i = listOfList.size() - 1; i > 0; i--) { //start from bottom
                for (int j = 0; j < listOfList.get(i).size() - 1; j++) { //decide the higher value among both node and add it to upper node
                    temp = listOfList.get(i - 1).get(j) + returnHigher(listOfList.get(i).get(j), listOfList.get(i).get(j + 1));
                    listOfList.get(i - 1).set(j, temp);
                }
            }
            in.close();
            System.out.println("Max total is " + listOfList.get(0).get(0));
            System.out.println("Total computation time in nanoseconds: " + (System.nanoTime() - start));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Integer returnHigher(Integer i, Integer j) {
        return i > j ? i : j;
    }
}
