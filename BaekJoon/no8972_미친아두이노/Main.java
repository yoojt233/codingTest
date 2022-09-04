package BaekJoon.no8972_미친아두이노;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static ardu me; // 종수의 아두이노
	static List<ardu> mad; // 미친 아두이노 리스트
	static int[][] map; // 칸에 존재하는 미친 아두이노 수
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		mad = new ArrayList<ardu>();

		// I는 종수의 아두이노, R은 미친 아두이노
		for (int i = 0; i < row; i++) {
			String s = br.readLine();
			for (int j = 0; j < col; j++) {
				char temp = s.charAt(j);
				if (temp == 'I')
					me = new ardu(i, j);
				else if (temp == 'R') {
					mad.add(new ardu(i, j));
					map[i][j]++;
				}
			}
		}

		// 명령
		String s = br.readLine();
		int[] order = new int[s.length()];
		for (int i = 0; i < s.length(); i++)
			order[i] = s.charAt(i) - '0';

		OUT: for (int i = 0; i < order.length; i++) {
			move(me, order[i]); // 종수의 아두이노 이동

			// 미친 아두이노 확인
			for (ardu a : mad) {
				if (isOver(a)) {
					sb.append(i + 1);
					break OUT;
				}
			}

			// 미친 아두이노 이동
			for (int j = 0; j < mad.size(); j++) {
				ardu a = mad.get(j);
				map[a.x][a.y]--; // 현재 위치의 칸 아두이노 수 감소

				move(a, dir(a));

				// 종수의 아두이노 확인
				if (isOver(a)) {
					sb.append(i + 1);
					break OUT;
				}

				map[a.x][a.y]++; // 이동한 칸 아두이노 수 증가
			}

			// 겹치는 아두이노 파괴
			reset();
		}

		// 모든 명령 정상 완수
		if (sb.length() == 0) {
			char[][] board = new char[row][col];

			// board를 .으로 초기화
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++)
					board[i][j] = '.';
			}

			// 아두이노 배치
			board[me.x][me.y] = 'I';
			for (ardu a : mad)
				board[a.x][a.y] = 'R';

			for (char[] b : board) {
				for (char c : b)
					sb.append(c);
				sb.append("\n");
			}
		}

		System.out.print(sb.toString());
		br.close();
	}

	// 칸에 아두이노가 1개보다 많다면 폭발
	// 1개라면 미친 아두이노 리스트에 추가
	private static void reset() {
		mad.clear();

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] > 1)
					map[i][j] = 0;
				else if (map[i][j] == 1)
					mad.add(new ardu(i, j));
			}
		}
	}

	// 게임 오버 검사
	private static boolean isOver(ardu a) {
		if (a.x == me.x && a.y == me.y) {
			sb.append("kraj ");
			return true;
		}
		return false;
	}

	// 종수의 아두이노 쪽으로 이동
	private static int dir(ardu a) {
		int gx = me.x - a.x;
		int gy = me.y - a.y;

		if (gx > 0 && gy > 0)
			return 3;
		else if (gx > 0 && gy < 0)
			return 1;
		else if (gx < 0 && gy > 0)
			return 9;
		else if (gx < 0 && gy < 0)
			return 7;
		else if (gx > 0)
			return 2;
		else if (gx < 0)
			return 8;
		else if (gy > 0)
			return 6;
		else
			return 4;
	}

	static int[] dx = { 0, 1, 1, 1, 0, 0, 0, -1, -1, -1 };
	static int[] dy = { 0, -1, 0, 1, -1, 0, 1, -1, 0, 1 };

	private static void move(ardu cur, int d) {
		cur.x += dx[d];
		cur.y += dy[d];
	}
}

class ardu {
	int x, y;

	public ardu(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}