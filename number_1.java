import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arr) {
    // Write your code here
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            int index_i_1 = i;
            if (index_i_1 == 4) break;
            int index_i_2 = i + 1;
            int index_i_3 = i + 2;

            for (int j = 0; j < 6; j++) {
                if (j == 4) break;
                int temp_result = 0;
                for (int k = j; k < j + 3; k++) {
                    temp_result += arr.get(index_i_1).get(k) + arr.get(index_i_3).get(k);
                }
                temp_result += arr.get(index_i_2).get(j + 1);
                result.add(temp_result);
            }
        }

        int max = Collections.max(result);
        
        return max;
    }

}

public class number_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
