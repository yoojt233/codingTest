package BaekJoon.no21608_상어초등학교;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] sequence; // 자리 정할 학생의 순서

	static Map<Integer, int[]> student; // 학생 별 친구 리스트
	static int[][] map, empty;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		sequence = new int[n * n];
		student = new HashMap<>();

		for (int i = 0; i < n * n; i++) {
			st = new StringTokenizer(br.readLine());
			int cur = Integer.parseInt(st.nextToken());
			sequence[i] = cur;

			int[] temp = new int[4];
			for (int j = 0; j < 4; j++)
				temp[j] = Integer.parseInt(st.nextToken());

			// binarySearch를 위해 정렬
			Arrays.sort(temp);

			// Key: 자리를 정할 학생, Value: 학생의 친구 리스트
			student.put(cur, temp);
		}

		map = new int[n][n];

		// 빈 자리 초기화
		empty = new int[n][n];
		setEmpty();

		// 순서대로 자리 배정
		for (int i = 0; i < n * n; i++)
			setStd(sequence[i]);

		int total = 0; // 점수
		int[] score = { 0, 1, 10, 100, 1000 };

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				total += score[getCnt(i, j, map[i][j])];
		}

		System.out.print(total);
		br.close();
	}

	private static void setEmpty() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				empty[i][j] = getCnt(i, j, 0);
		}
	}

	private static void setStd(int cur) {
		int[] like = student.get(cur); // 자리를 정할 학생의 친구 리스트
		where max = new where(-1, -1, -1);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				// 아무도 앉지 않았다.
				if (map[i][j] == 0) {
					int near = getCnt(i, j, cur);

					// 1. 현재 위치가 기존 max보다 주변 친구가 많으면 갱신
					if (near > max.near)
						max = new where(i, j, near);

					// 2. 같은 경우에는 빈자리가 많은 순
					else if (near == max.near) {
						if (empty[i][j] > empty[max.x][max.y])
							max = new where(i, j, near);
					}

					// 3. 행이 작을 수록, 열이 작을 수록은 for문 순서 정해지므로 인해 구현할 필요가 없다.
				}
			}
		}

		// 자리 배정
		map[max.x][max.y] = cur;

		// 주변 빈 자리 감소
		for (int d = 0; d < 4; d++) {
			int cx = max.x + dx[d];
			int cy = max.y + dy[d];
			if (cx < 0 || cx >= n || cy < 0 || cy >= n)
				continue;
			empty[cx][cy]--;
		}
	}

	// f가 0이면 빈 자리 탐색, 아니면 주변 친구 탐색
	private static int getCnt(int x, int y, int f) {
		int cnt = 0;
		int[] list = new int[4];

		if (f != 0)
			list = student.get(f);

		for (int d = 0; d < 4; d++) {
			int cx = x + dx[d];
			int cy = y + dy[d];
			if (cx < 0 || cx >= n || cy < 0 || cy >= n)
				continue;
			if (f == 0)
				cnt++;
			else {
				if (Arrays.binarySearch(list, map[cx][cy]) >= 0)
					cnt++;
			}
		}
		return cnt;
	}
}

// 좌표, 주변 친구 수
class where {
	int x, y, near;

	public where(int x, int y, int near) {
		super();
		this.x = x;
		this.y = y;
		this.near = near;
	}
}