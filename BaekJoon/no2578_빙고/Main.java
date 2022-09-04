package BaekJoon.no2578_빙고;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[5][5];

		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				if (i < 5)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 부를 번호를 큐에 저장
		Queue<Integer> number = new LinkedList<Integer>();
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens())
				number.offer(Integer.parseInt(st.nextToken()));
		}

		// 큐에서 하나씩 뽑은 후 빙고판에서 0으로 변환.
		outer: while (bingo() < 3) {
			int temp = number.poll();
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (map[i][j] == temp) {
						map[i][j] = 0;
						continue outer;
					}
				}
			}
		}

		// 사용한 큐의 갯수가 정답
		System.out.print(25 - number.size());
		br.close();
	}

	private static int bingo() {
		int many = 0;

		// 가로 탐색
		for (int i = 0; i < 5; i++) {
			int cnt = 0;
			for (int j = 0; j < 5; j++) {
				if (map[i][j] == 0) {
					cnt++;
				}
			}
			if (cnt == 5)
				many++;
		}

		// 세로 탐색
		for (int i = 0; i < 5; i++) {
			int cnt = 0;
			for (int j = 0; j < 5; j++) {
				if (map[j][i] == 0) {
					cnt++;
				}
			}
			if (cnt == 5)
				many++;
		}

		// 대각선 탐색 ( \ )
		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			if (map[i][i] == 0)
				cnt++;
			if (cnt == 5)
				many++;
		}

		// 대각선 탐색 ( / )
		cnt = 0;
		for (int i = 0; i < 5; i++) {
			if (map[i][4 - i] == 0)
				cnt++;
			if (cnt == 5)
				many++;
		}

		return many;
	}
}
