package BaekJoon.no14719_빗물;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		map = new boolean[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
		st = new StringTokenizer(br.readLine());

		int idx = 0;
		while (st.hasMoreTokens()) {
			int h = Integer.parseInt(st.nextToken());

			// 물은 중력으로 위에서 아래로 떨어지지만, 편의를 위해 위부터 저장
			for (int i = 0; i < h; i++)
				map[i][idx] = true;
			idx++;
		}

		int total = 0;
		for (int i = 0; i < map.length; i++) { // 행
			int op = -1; // 0부터 탐색을 시작하므로 -1로 초기화
			for (int j = 0; j < map[i].length; j++) { // 열

				// i행 j열이 블록일 경우
				if (map[i][j]) {

					// 지금이 처음 나온 블록이면 시작 지점으로 저장
					if (op == -1)
						op = j;

					// 이미 시작 지점이 있었다면 시작 지점부터 현재 지점 사이까지는 물이 고여있다.
					else {
						total += (j - op - 1);
						op = j; // 현재 지점을 시작 지점으로 지정 후 탐색 시작
					}
				}
			}
		}

		System.out.println(total);
		br.close();
	}
}
