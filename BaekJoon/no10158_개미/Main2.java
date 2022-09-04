package BaekJoon.no10158_개미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int dx = 1, dy = 1; // 기본 방향

		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken()); // 행 최대
		int c = Integer.parseInt(st.nextToken()); // 열 최대

		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken()); // 초기 x좌표
		int y = Integer.parseInt(st.nextToken()); // 초기 y좌표

		int N = Integer.parseInt(br.readLine()); // 몇 초 후?
		for (int i = 0; i < N; i++) {
			if (x == 0 || x == r) // 아래 위 벽을 만났을 때
				dx *= -1;
			if (y == 0 || y == c) // 왼쪽 오른쪽 벽을 만났을 때
				dy *= -1;
			x += dx;
			y += dy;
		}
		sb.append(x).append(" ").append(y);
		System.out.print(sb);
		br.close();
	}
}