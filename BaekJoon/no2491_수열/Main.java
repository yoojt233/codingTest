package BaekJoon.no2491_수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] number = new int[N];
		int answer = 1;
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++)
			number[i] = Integer.parseInt(st.nextToken());

		int asc = 1, desc = 1;

		// 오름차순
		for (int i = 0; i < N - 1; i++) {
			if (number[i + 1] >= number[i])
				asc++;
			else
				asc = 1;

			answer = Math.max(answer, asc);
		}

		// 내림차순
		for (int i = 0; i < N - 1; i++) {
			if (number[i + 1] <= number[i])
				desc++;
			else
				desc = 1;

			answer = Math.max(answer, desc);
		}

		System.out.print(answer);
		br.close();
	}
}
