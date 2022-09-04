package BaekJoon.no4948_베르트랑공준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		while (n != 0) {	// 0이 나올 때까지
			sb.append(getCount(n)).append("\n");
			n = Integer.parseInt(br.readLine());
		}
		System.out.print(sb.toString());
		br.close();
	}

	private static int getCount(int n) {
		int cnt = 0;
		boolean[] check = new boolean[2 * n + 1];

		// 기준점으로부터 배수들을 true로 변환, 다음 방문 시 true면 건너뛰기
		for (int i = 2, size = check.length; i < size; i++) {
			if (check[i])
				continue;
			else {
				int idx = 2;
				while (i * idx < size) {
					check[i * idx++] = true;
				}
			}
		}

		// false면 소수
		for (int i = n + 1; i <= 2 * n; i++)
			if (!check[i])
				cnt++;

		return cnt;
	}
}
