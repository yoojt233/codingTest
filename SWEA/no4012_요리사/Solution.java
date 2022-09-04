package SWEA.no4012_요리사;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, MIN, food1, food2;
	static int[][] synergy;
	static int[] sel1, sel2, selected1, selected2;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		 System.setIn(new FileInputStream("input/SWEA/swea_4012.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		 int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			MIN = Integer.MAX_VALUE;

			synergy = new int[N][N];
			sel1 = new int[N / 2];
			sel2 = new int[N / 2];
			selected1 = new int[2];
			selected2 = new int[2];
			check = new boolean[N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					synergy[i][j] = Integer.parseInt(st.nextToken());
			}

			combo(0, 0);
			sb.append(MIN).append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}

	private static void combo(int cnt, int start) {
		if (cnt == N / 2) {
			food1 = 0;
			food2 = 0;
			int idx = 0;
			for (int i = 0; i < N; i++) {
				if (!check[i])
					sel2[idx++] = i;
			}
			per1(0, new boolean[N / 2]);
			per2(0, new boolean[N / 2]);
			MIN = Math.min(MIN, Math.abs(food1 - food2));
			return;
		}

		for (int i = start; i < N; i++) {
			sel1[cnt] = i;
			check[i] = true;
			combo(cnt + 1, i + 1);
			check[i] = false;
		}
	}

	private static void per1(int count, boolean[] bs) {
		if (count == 2) {
			food1 = food1 + synergy[selected1[0]][selected1[1]];
			return;
		}

		for (int i = 0, size = sel1.length; i < size; i++) {
			if (bs[i])
				continue;
			bs[i] = true;
			selected1[count] = sel1[i];
			per1(count + 1, bs);
			bs[i] = false;
		}
	}

	private static void per2(int count, boolean[] bs) {
		if (count == 2) {
			food2 = food2 + synergy[selected2[0]][selected2[1]];
			return;
		}

		for (int i = 0, size = sel1.length; i < size; i++) {
			if (bs[i])
				continue;
			bs[i] = true;
			selected2[count] = sel2[i];
			per2(count + 1, bs);
			bs[i] = false;
		}
	}
}
