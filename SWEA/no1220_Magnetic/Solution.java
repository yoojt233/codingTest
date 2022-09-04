package SWEA.no1220_Magnetic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int ans, N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = 10;
		for (int t = 1; t <= tc; t++) {
			ans = 0;
			N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}

			for (int j = 0; j < N; j++) {
				boolean flag = false;
				for (int i = 0; i < N; i++) {
					if (map[i][j] == 1) {
						flag = true;
					} else if (map[i][j] == 2) {
						if (flag == true) {
							ans++;
							flag = false;
						}
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ").append(ans).append("\n");
			System.out.print(sb);
		}
		br.close();
	}
}
