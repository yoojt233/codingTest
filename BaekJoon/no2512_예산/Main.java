package BaekJoon.no2512_예산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] city;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 지방의 수

		int sum = 0; // 요청된 예산들의 합
		city = new int[N]; // 예산 요청을 저장할 배열
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			city[i] = Integer.parseInt(st.nextToken());
			sum += city[i];
		}
		int max = Integer.parseInt(br.readLine()); // 국가예산

		Arrays.sort(city);
		if (max >= sum) // 모두 줄 수 있을 때
			System.out.print(city[N - 1]);
		else // 못 줄 때
			System.out.print(calc(max));

		br.close();
	}

	private static int calc(int max) {
		for (int i = 0; i < N; i++) {
			if (max / (N - i) >= city[i])
				max -= city[i];
			else
				return max / (N - i);
		}

		return 0;
	}
}
