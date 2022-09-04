package BaekJoon.no2563_색종이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N; // 붙일 색종이 수
	static int x, y; // 색종이의 x, y 좌표
	static int[][] back = new int[100][100]; // 도화지

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		// 도화지에 색종이 붙이기
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			page(x, y);
		}

		int area = 0; // 색종이 넓이
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (back[i][j] >= 1)
					area++;
			}
		}
		System.out.print(area);
		br.close();
	}

	private static void page(int cx, int cy) {
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++)
				back[i + cx][j + cy]++;
	}
}
