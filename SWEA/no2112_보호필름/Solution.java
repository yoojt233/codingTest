package SWEA.no2112_보호필름;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int D, W, K, film[][], min;
	static int[] drugA, drugB;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			film = new int[D][W];
			drugA = new int[W];
			drugB = new int[W];
			min = Integer.MAX_VALUE;

			// 입력 처리
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++)
					film[i][j] = Integer.parseInt(st.nextToken());
			}

			// A는 0, B는 1
			Arrays.fill(drugB, 1);

			process(0, 0);

			sb.append("#").append(t).append(" ").append(min).append("\n");
		}

		System.out.print(sb.toString());
		br.close();
	}

	// 보호 필름 성능 검사
	private static boolean check() {
		for (int c = 0; c < W; c++) {
			int count = 1;
			int before = film[0][c];

			// 하나의 열을 고정해서 수직 검사
			for (int r = 1; r < D; r++) {
				int current = film[r][c];
				if (before == current) {
					if (++count == K)
						break;
				} else {
					before = current;
					count = 1;
				}
			}

			if (count < K)
				return false;
		}

		return true;
	}

	// 각 막에 부분집합으로 약품 투여x, 약품A 투여, 약품B 투여
	private static boolean process(int row, int useCnt) {
		if (row == D) {
			if (check()) {
				min = Math.min(min, useCnt);
				return min == 0; // 약품을 하나도 사용하지 않았으면 true, 사용했으면 false
			}
			return false;
		}

		if (useCnt >= min)
			return false;

		int[] backup = film[row];

		// 투여x
		process(row + 1, useCnt);

		// 약품A
		film[row] = drugA;
		process(row + 1, useCnt + 1);

		// 약품B
		film[row] = drugB;
		process(row + 1, useCnt + 1);

		film[row] = backup;
		return false;
	}
}
