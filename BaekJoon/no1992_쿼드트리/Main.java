package BaekJoon.no1992_쿼드트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static char[][] data;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		data = new char[N][N];

		// 데이터 입력
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++)
				data[i][j] = str.charAt(j);
		}

		// 변의 크기, 시작 x좌표, 시작 y좌표
		divide(N, 0, 0);

		System.out.print(sb.toString());
		br.close();
	}

	private static void divide(int n, int x, int y) {
		if (n <= 1) {
			sb.append(data[x][y]);
			return;
		}

		int half = n / 2;

		// 모두 같은 문자인지 확인
		// false : 분할 true : sb에 입력 후 리턴
		if (!one(n, x, y)) {
			sb.append("(");
			divide(half, x, y);
			divide(half, x, y + half);
			divide(half, x + half, y);
			divide(half, x + half, y + half);
			sb.append(")");
		} else {
			sb.append(data[x][y]);
			return;
		}
	}

	private static boolean one(int n2, int x, int y) {
		char temp = data[x][y];

		// 다른 즉시 false 리턴
		for (int i = 0; i < n2; i++) {
			for (int j = 0; j < n2; j++) {
				if (temp != data[x + i][y + j])
					return false;
			}
		}
		return true;
	}
}
