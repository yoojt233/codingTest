package SWEA.no1206_View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = 10;
		for (int t = 1; t <= tc; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] floor = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int answer = 0;

			for (int i = 0; i < N; i++)
				floor[i] = Integer.parseInt(st.nextToken());

			for (int i = 2; i < N - 2; i++) {
				int max = Math.max(Math.max(floor[i - 1], floor[i + 1]), Math.max(floor[i - 2], floor[i + 2]));

				if (max < floor[i])
					answer += (floor[i] - max);
			}

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ").append(answer).append("\n");
			System.out.print(sb.toString());
		}
		br.close();
	}
}
