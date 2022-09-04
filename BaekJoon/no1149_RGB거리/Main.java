package BaekJoon.no1149_RGB거리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] color = new int[n + 1][3];
		StringTokenizer st;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++)
				color[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= n; i++) {
			color[i][0] += Math.min(color[i - 1][1], color[i - 1][2]);
			color[i][1] += Math.min(color[i - 1][0], color[i - 1][2]);
			color[i][2] += Math.min(color[i - 1][0], color[i - 1][1]);
		}

		System.out.println(Arrays.stream(color[n]).min().getAsInt());
		br.close();
	}
}
