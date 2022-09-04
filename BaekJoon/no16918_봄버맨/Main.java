package BaekJoon.no16918_봄버맨;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static char[][][] status;
	static int row, col;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		int sec = Integer.parseInt(st.nextToken());

		// 장판에 폭탄이 놓여있는 상태
		// 0 : 초기 폭탄 1 : 모든 칸에 폭탄 2 : 초기 폭탄이 터진 후 3 : 나중에 설치한 폭탄이 터진 후
		status = new char[4][row][col];
		for (int i = 0; i < row; ++i)
			status[0][i] = br.readLine().toCharArray();

		init();
		String[] ans = new String[row];

		if (sec == 1)
			ans = combine(status[0]);
		else {
			if (sec % 4 == 1)
				ans = combine(status[3]);
			else if (sec % 4 == 3)
				ans = combine(status[2]);
			else
				ans = combine(status[1]);
		}

		for (String s : ans)
			sb.append(s + "\n");

		System.out.println(sb.toString());
		br.close();
	}

	private static void init() {

		// 모든 칸에 폭탄
		for (int i = 0; i < row; ++i)
			Arrays.fill(status[1][i], 'O');

		status[2] = boom(status[0]); // 초기 폭탄 터짐
		status[3] = boom(status[2]); // 나중에 설치한 폭탄 터짐
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static char[][] boom(char[][] before) {
		char[][] after = new char[row][col];

		// after라는 새로운 map을 그리기 위해 폭탄이 위치한 부분은 .으로 나머지는 O로
		Queue<pos> q = new LinkedList<>();
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				if (before[i][j] == 'O') {
					q.add(new pos(i, j));
					after[i][j] = '.';
				} else
					after[i][j] = 'O';
			}
		}

		// + 방향으로 터진다.
		while (!q.isEmpty()) {
			pos cur = q.poll();
			for (int d = 0; d < 4; ++d) {
				int cx = cur.x + dx[d];
				int cy = cur.y + dy[d];

				if (cx < 0 || cx >= row || cy < 0 || cy >= col)
					continue;

				after[cx][cy] = '.';
			}
		}
		return after;
	}

	// 정답 출력을 위해 String 배열에 각각의 행을 합쳐서 저장
	private static String[] combine(char[][] output) {
		String[] ans = new String[row];

		for (int i = 0; i < row; ++i) {
			StringBuilder temp = new StringBuilder();
			for (int j = 0; j < col; ++j)
				temp.append(output[i][j]);
			ans[i] = temp.toString();
		}
		return ans;
	}
}

class pos {
	int x, y;

	public pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}