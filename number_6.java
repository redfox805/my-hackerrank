import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */
     
    static long result = 0;

    public static long repeatedString(String s, long n) {
    // Write your code here
        int total_a_occur = 0;
        List<Integer> occur_index = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                total_a_occur++;
                occur_index.add(i);
            }
        }
        
        long hasil_bagi = n / s.length();
        long modulus = n % s.length();
        result = total_a_occur * hasil_bagi;
        occur_index.forEach((index) -> {
            if (index <= modulus - 1) result++;
        });
        
        return result;
    }

}

public class number_6 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result.repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
