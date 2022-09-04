package BaekJoon.no1074_Z;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int r, c;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		answer = 0;

		int x = 0;
		int y = 0;
		divide(1 << N, x, y);
	}

	private static void divide(int side, int x, int y) {
		if (x == r && y == c) {
			System.out.print(answer);
			System.exit(0);
			return;
		}
		int half = side / 2;
		if (r < x + side && c < y + side) {
			divide(half, x, y);
			divide(half, x, y + half);
			divide(half, x + half, y);
			divide(half, x + half, y + half);
		} else
			answer += side * side;
	}
}
