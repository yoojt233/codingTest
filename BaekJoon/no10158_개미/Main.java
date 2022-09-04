package BaekJoon.no10158_개미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken()); // 행 최대
		int c = Integer.parseInt(st.nextToken()); // 열 최대

		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken()); // 초기 x좌표
		int y = Integer.parseInt(st.nextToken()); // 초기 y좌표

		int N = Integer.parseInt(br.readLine()); // 몇 초 후?
		x = (x + N) % (2 * r); // 가로는 2*r 주기로 원위치
		y = (y + N) % (2 * c); // 세로는 2*c 주기로 원위치
		if (x > r)
			x = 2 * r - x; // 남은 구간이 r 초과 2*r 미만일 경우 뒤에서부터 계산(r - (x-r))
		if (y > c)
			y = 2 * c - y; // 위와 동일
		sb.append(x).append(" ").append(y);
		System.out.print(sb);
		br.close();
	}
}