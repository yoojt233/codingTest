package BaekJoon.no2012_등수매기기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] people = new int[N];
		for (int i = 0; i < N; ++i)
			people[i] = Integer.parseInt(br.readLine());

		Arrays.sort(people);

		long ans = 0;
		for (int i = 0; i < N; ++i)
			ans += Math.abs(people[i] - i - 1);

		System.out.print(ans);
		br.close();
	}
}
