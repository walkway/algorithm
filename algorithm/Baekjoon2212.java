import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/2212
 *
 * 센서
 */
public class Baekjoon2212 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());
        String[] input = reader.readLine().split(" ");

        int[] location = new int[n];
        for(int i = 0; i < n; i++) {
            location[i] = Integer.parseInt(input[i]);
        }

        if (k >= n) {
            System.out.println(0);

            return;
        }

        Arrays.sort(location);

        List<Integer> sensorDistance = new ArrayList<>();
        for (int i = 0; i < n-1; i++) {
            int distance = location[i+1] - location[i];
            sensorDistance.add(distance);
        }

        sensorDistance.sort(Comparator.naturalOrder());

        int result = 0;
        for (int i = 0; i < n - k; i++) {
            result += sensorDistance.get(i);
        }

        System.out.println(result);
    }
}