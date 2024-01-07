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
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
        int count = 0;
        boolean flag = false;
        for(int i=q.size()-1;i>=0;i--) {
          if(q.get(i)!=i+1) {
              if(q.get(i-1)==(i+1)){
                  int swap1 = q.get(i);
                  int swap2 = q.get(i-1);
                  q.set(i, swap2);
                  q.set(i-1, swap1);
                  count++;
              } else if(q.get(i-2)==(i+1)) {
                  int swap1 = q.get(i);
                  int swap2 = q.get(i-1);
                  int swap3 = q.get(i-2);
                  q.set(i, swap3);
                  q.set(i-1, swap1);
                  q.set(i-2, swap2);
                 count+=2;
              } else {
                  System.out.println("Too chaotic");
                  return;
              }
            } 
          }  
        System.out.println(count);
    }

}

public class NewYearChaos {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                Result.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
