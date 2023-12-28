import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        long min = (long) Integer.MAX_VALUE, max = (long) Integer.MIN_VALUE;
        long sum = 0;
        // Sum of the elements
        // Find the min and max of in the array
        for (int i = 0; i < arr.size(); i++) {
            if (min > arr.get(i)) {
                min = arr.get(i);
            }
            if (max < arr.get(i)) {
                max = arr.get(i);
            }
            sum = arr.get(i) + sum;
        }
        System.out.println((sum - max) + " " + (sum - min));
    }

}

public class MinMaxSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
