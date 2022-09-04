package BaekJoon.no2174_로봇시뮬레이션;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main2 {
	static roboto[] robots;
	static int[][] map;
	static boolean flag;
	static int col, row;
	static Map<String, Integer> direction;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		init(); // 전역 변수 초기화

		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new int[row][col];

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		robots = new roboto[n];

		// 초기 로봇 위치 및 방향
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			robots[i] = new roboto(i + 1, x, y, direction.get(st.nextToken()));
			map[x][y] = i+1;
		}

		// 명령 실행
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			char f = st.nextToken().charAt(0);

			if (f == 'L')
				L(num, Integer.parseInt(st.nextToken()));
			else if (f == 'R')
				R(num, Integer.parseInt(st.nextToken()));
			else {
				flag = F(num, Integer.parseInt(st.nextToken()));
				if (!flag)
					break;
			}
		}

		if (flag)
			sb.append("OK");

		System.out.println(sb.toString());
		br.close();

	}

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	private static boolean F(int num, int chance) {
		for (int i = 0; i < chance; i++) {
			int cx = robots[num - 1].x + dx[robots[num - 1].dir];
			int cy = robots[num - 1].y + dy[robots[num - 1].dir];

			if (cx < 0 || cx >= row || cy < 0 || cy >= col) { // 범위 이탈 = 벽
				sb.append("Robot " + num + " crashes into the wall");
				return false;
			} else if (map[cx][cy] != 0) { // 이미 다른 로봇이 있다.
				sb.append("Robot " + num + " crashes into robot " + map[cx][cy]);
				return false;
			}

			// 로봇 이동
			map[robots[num - 1].x][robots[num - 1].y] = 0;
			robots[num - 1].x = cx;
			robots[num - 1].y = cy;
			map[cx][cy] = num;
		}
		return true;
	}

	// 좌향 좌
	private static void L(int num, int x) {
		robots[num - 1].dir = (robots[num - 1].dir + x) % 4;
	}

	// 우향 우
	private static void R(int num, int x) {
		int temp = robots[num - 1].dir - x % 4;
		robots[num - 1].dir = temp < 0 ? 4 + temp : temp;
	}

	private static void init() {
		flag = true;
		sb = new StringBuilder();

		// map을 오른쪽으로 90도 돌렸기 때문에, 방향도 90도 돌려서 저장
		direction = new HashMap<>();
		direction.put("W", 0);
		direction.put("S", 1);
		direction.put("E", 2);
		direction.put("N", 3);
	}
}

// 번호, 좌표, 방향
class roboto {
	int num, x, y, dir;

	public roboto(int num, int x, int y, int dir) {
		super();
		this.num = num;
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
}