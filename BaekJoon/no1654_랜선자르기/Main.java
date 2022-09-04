package BaekJoon.no1654_랜선자르기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken()); // 가지고 있는 랜선 갯수
		int N = Integer.parseInt(st.nextToken()); // 필요한 랜선 갯수

		int[] input = new int[K]; // 가지고 있는 랜선 길이
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < K; i++) {
			input[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, input[i]);
		}

		long left = 1;
		long right = max;
		long mid = 0;

		while (left <= right) {
			long total = 0;

			mid = (left + right) / 2;
			for (int i = 0; i < K; i++)
				total += (input[i] / mid);

			if (total >= N)
				left = mid + 1;
			else
				right = mid - 1;
		}

		System.out.println(right);
		br.close();
	}
}
