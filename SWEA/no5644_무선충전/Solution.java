package SWEA.no5644_무선충전;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int M, A, sum;
	static BC[] bc;
	static int[][] walk;
	static int[] dx = { 0, -1, 0, 1, 0 }; // 그대로 상 우 하 좌
	static int[] dy = { 0, 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");
			String input[] = br.readLine().split(" ");
			M = Integer.parseInt(input[0]);
			A = Integer.parseInt(input[1]);
			sum = 0;
			bc = new BC[A];
			walk = new int[2][20];

			// 이동 정보
			for (int i = 0; i < 2; i++) {
				input = br.readLine().split(" ");
				for (int j = 0; j < 20; j++) {
					walk[i][j] = Integer.parseInt(input[j]);
				}
			}

			// BC의 정보
			for (int i = 0; i < A; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				bc[i] = new BC(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			int x1 = 0;
			int y1 = 0;
			int x2 = 9;
			int y2 = 9;
			battery(x1, y1, x2, y2);
			for (int i = 0; i < 20; i++) {
				x1 += dx[walk[0][i]];
				y1 += dy[walk[0][i]];
				x2 += dx[walk[1][i]];
				y2 += dy[walk[1][i]];
				battery(x1, y1, x2, y2);
			}
			sb.append(sum).append("\n");

		}
		System.out.print(sb.toString());
		br.close();
	}

	private static void battery(int x1, int y1, int x2, int y2) {

		int[] disA = new int[A];
		int[] disB = new int[A];
		List<Integer> batteryA = new ArrayList<Integer>();
		List<Integer> batteryB = new ArrayList<Integer>();
		for (int i = 0; i < A; i++) {
			disA[i] = Math.abs(x1 - bc[i].x) + Math.abs(y1 - bc[i].y);
			disB[i] = Math.abs(x2 - bc[i].x) + Math.abs(y2 - bc[i].y);
		}

		for (int i = 0; i < A; i++) {
			if (disA[i] <= bc[i].C) {
				batteryA.add(bc[i].p);
			}
			if (disB[i] <= bc[i].C) {
				batteryB.add(bc[i].p);
			}
		}

		if (batteryA.size() != 0 && batteryB.size() == 0) { // a만
			sum += Collections.max(batteryA);
		} else if (batteryA.size() == 0 && batteryB.size() != 0) { // b만
			sum += Collections.max(batteryB);
		} else if (batteryA.size() != 0 && batteryB.size() != 0) {
			int max = 0;
			for (int i = 0; i < batteryA.size(); i++) {
				for (int j = 0; j < batteryB.size(); j++) {
					int temp = batteryA.get(i) + batteryB.get(j);
					if (batteryA.get(i) == batteryB.get(j))
						temp /= 2;
					max = Math.max(max, temp);
				}
			}
			sum += max;
		}

	}

	static class BC implements Comparable<BC> {
		int x, y; // 좌표 값
		int C; // 충전 거리
		int p; // 처리량

		public BC(int x, int y, int c, int p) {
			super();
			this.x = y - 1;
			this.y = x - 1;
			C = c;
			this.p = p;
		}

		@Override
		public int compareTo(BC o) {
			return p - o.p;
		}

	}
}
