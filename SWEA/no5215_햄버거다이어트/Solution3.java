package SWEA.no5215_햄버거다이어트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());

			int[][] thing = new int[N + 1][2];

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				thing[i][0] = Integer.parseInt(st.nextToken());
				thing[i][1] = Integer.parseInt(st.nextToken());
			}

			int[] ks = new int[L + 1];
			for (int i = 1; i <= N; i++) {
				for (int j = L; j >= thing[i][1]; j--) {
					ks[j] = Math.max(ks[j], ks[j - thing[i][1]] + thing[i][0]);
				}
			}

			sb.append("#").append(t).append(" ").append(ks[L]).append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}
}
