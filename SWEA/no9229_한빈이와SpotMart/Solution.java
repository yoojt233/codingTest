package SWEA.no9229_한빈이와SpotMart;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static int N, limit, max, weight;
	static int[] snack;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" "); // #t

			String str = br.readLine();
			StringTokenizer st1 = new StringTokenizer(str);
			N = Integer.parseInt(st1.nextToken()); // 과자 개수
			limit = Integer.parseInt(st1.nextToken()); // 무게 제한
			max = -1;
			weight = 0;

			str = br.readLine();
			StringTokenizer st2 = new StringTokenizer(str);
			snack = new int[N];
			for (int i = 0; i < N; i++)
				snack[i] = Integer.parseInt(st2.nextToken());

			whichSnack(0, 0);
			sb.append(max).append("\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

	private static void whichSnack(int pick, int a) {
		if (weight > limit)
			return;
		if (pick == 2) {
			max = Math.max(max, weight);
			return;
		}
		for (int i = a; i < N; i++) {
			weight += snack[i];
			whichSnack(pick + 1, i + 1);
			weight -= snack[i];
		}
	}
}