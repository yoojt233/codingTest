package SWEA.no3234_준환이의양팔저울;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");
			answer = 0;
			int N = Integer.parseInt(br.readLine());

			int[] weight = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}

			On(N, 0, 0, 0, weight, new boolean[N]);
			sb.append(answer).append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}

	private static void On(int N, int left, int right, int count, int[] weight, boolean[] bs) {
		if (count == N) {
			answer++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (bs[i])
				continue;
			bs[i] = true;
			On(N, left + weight[i], right, count + 1, weight, bs);
			if (left >= right + weight[i])
				On(N, left, right + weight[i], count + 1, weight, bs);
			bs[i] = false;
		}
	}
}
