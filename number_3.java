import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
    // Write your code here
        
        int result = 0;
        
        Set<Integer> ar_set = new HashSet(ar);
        
        Map<Integer, Integer> ar_map = new HashMap();
        
        for (Integer each_ar_set: ar_set) {
            int count = 0;
            for (Integer each_ar: ar) {
                if (each_ar == each_ar_set) {
                    count++;
                }
            }
            ar_map.put(each_ar_set, count);
        }
        
        for (Map.Entry<Integer, Integer> entry : ar_map.entrySet()) {
            int divided_by_2_result = entry.getValue() / 2;
            result += divided_by_2_result;
        }
        
        return result;
    }

}

public class number_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
