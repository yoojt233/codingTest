package SWEA.no7964_부먹왕국의차원관문;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int[] city = new int[N];
			int ans = 0;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				city[i] = Integer.parseInt(st.nextToken());

			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (city[i] == 1)
					cnt = 0;
				else {
					cnt++;
					if (cnt >= d) {
						ans++;
						cnt = 0;
					}
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
}
