package BaekJoon.no25707_팔찌만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		String[] input = br.readLine().split(" ");
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; ++i) {
			int cur = Integer.parseInt(input[i]);
			if (cur < min)
				min = cur;
			if (cur > max)
				max = cur;
		}

		System.out.print(2 * (max - min));
		br.close();
	}
}
