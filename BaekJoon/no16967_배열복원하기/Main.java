package BaekJoon.no16967_배열복원하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());

		int[][] A = new int[H][W];
		int[][] B = new int[H + X][W + Y];
		for (int i = 0; i < H + X; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W + Y; ++j)
				B[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < H; ++i)
			A[i] = Arrays.copyOfRange(B[i], 0, W);

		for (int i = 0; i < H; ++i) {
			for (int j = 0; j < W; ++j) {
				int ci = i - X;
				int cj = j - Y;

				if (ci < 0 || ci >= H || cj < 0 || cj >= W) {
					sb.append(A[i][j] + " ");
					continue;
				}

				A[i][j] -= A[ci][cj];
				sb.append(A[i][j] + " ");
			}
			sb.append("\n");
		}

		System.out.print(sb.toString());
		br.close();
	}
}
