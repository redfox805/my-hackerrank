import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
    // Write your code here
        char[] path_char = path.toCharArray();

        int counter = 0;
        List<Integer> step_counter = new ArrayList<>();
        step_counter.add(counter);
        for (char each_char: path_char) {
            if (each_char == 'U') counter += 1;
            else counter -= 1;
            step_counter.add(counter);
        }

        boolean in_valley = false;
        int valley_counter = 0;
        for (int i = 1; i < step_counter.size(); i++) {
            Integer before = step_counter.get(i - 1);
            Integer current = step_counter.get(i);
            if (before == 0 && current < 0) in_valley = true;
            if (current == 0 && in_valley) {
                valley_counter += 1;
                in_valley = false;
            }
        }
        
        return valley_counter;
    }

}

public class number_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
