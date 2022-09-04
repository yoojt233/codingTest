package BaekJoon.no20056_마법사상어와파이어볼;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int total, n;
	static Queue<fire>[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String[] in = br.readLine().split(" ");
		n = Integer.parseInt(in[0]);

		// Queue 2차원 배열 초기화
		map = new Queue[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				map[i][j] = new LinkedList<>();
		}

		// 인덱스 0부터 사용
		for (int i = 0; i < Integer.parseInt(in[1]); i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;

			String w = st.nextToken();
			total += Integer.parseInt(w); // map에 존재하는 파이어볼들의 질량 합

			map[x][y].offer(new fire(w, st.nextToken(), st.nextToken(), false));
		}

		for (int k = 0; k < Integer.parseInt(in[2]); k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j].isEmpty())
						continue;

					// Queue가 비어있지 않은 위치의 파이어볼들 이동
					move(i, j);
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j].isEmpty())
						continue;
					else if (map[i][j].size() == 1) // 파이어볼이 1개 있다면 이동 상태를 초기화
						map[i][j].peek().status = false;
					else
						sep(i, j); // 파이어볼 분열
				}
			}
		}

		System.out.print(total);
		br.close();
	}

	static int[][] ad = { { 0, 2, 4, 6 }, { 1, 3, 5, 7 } };

	private static void sep(int x, int y) {
		int size = map[x][y].size();

		fire[] temp = new fire[size];

		// Queue -> 배열
		for (int i = 0; i < size; i++)
			temp[i] = map[x][y].poll();

		int aw = 0; // Queue에 있는 파이어볼들 질량 합
		int as = 0; // Queue에 있는 파이어볼들 속도 합
		for (fire f : temp) {
			aw += f.w;
			as += f.s;
		}

		total -= aw; // 전체 질량에서 Queue에 있던 질량 합 제외
		if (aw / 5 > 0) { // 소멸x
			int dir = check(temp);
			for (int i = 0; i < 4; i++)
				map[x][y].offer(new fire(aw / 5 + "", as / size + "", ad[dir][i] + "", false));

			total += aw / 5 * 4; // 전체 질량에 나뉜 파이어볼들의 질량 추가
		}
	}

	// 파이어볼들의 방향이 모두 홀수? 모두 짝수?
	private static int check(fire[] temp) {
		int std = temp[0].d % 2;
		for (fire f : temp) {
			if (f.d % 2 != std)
				return 1;
		}
		return 0;
	}

	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

	// 이동
	private static void move(int x, int y) {

		// Queue가 비어있지 않으면서 이동한 적 없는 파이어볼 이동
		while (!map[x][y].isEmpty() && !map[x][y].peek().status) {
			fire cur = map[x][y].poll();

			// 이동 후 좌표
			int cx = range(x + dx[cur.d] * cur.s);
			int cy = range(y + dy[cur.d] * cur.s);

			cur.status = true; // 이동 후 상태 변경
			map[cx][cy].offer(cur); // 이동 위치 Queue에 현재 파이어볼 삽입
		}
	}

	// 좌표 재조정
	private static int range(int temp) {
		if (temp >= n) // n 이상으로 커지는 경우
			return temp %= n;
		else if (temp < 0) // 0보다 작아지는 경우
			return range(n + temp); // n을 더한 후에도 0보다 작을 수 있으므로 재귀
		return temp;
	}
}

// 질량, 속도, 방향, 이동 여부
class fire {
	int w, s, d;
	boolean status;

	public fire(String w, String s, String d, boolean status) {
		this.w = Integer.parseInt(w);
		this.s = Integer.parseInt(s);
		this.d = Integer.parseInt(d);
		this.status = status;
	}
}