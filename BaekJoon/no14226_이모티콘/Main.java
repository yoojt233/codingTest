package BaekJoon.no14226_이모티콘;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[][] visited = new boolean[10000][10000];

		int target = Integer.parseInt(br.readLine()); // 목표 개수

		Queue<emoticon> q = new LinkedList<emoticon>();
		q.add(new emoticon(1, 0, 0));

		OUT: while (!q.isEmpty()) {
			emoticon cur = q.poll();

			for (int i = 0; i < 3; i++) {
				int nscreen = 0; // 다음 화면 이모티콘 개수
				int nboard = 0; // 다음 클립보드 이모티콘 개수
				int nsec = cur.sec + 1;

				if (i == 0) { // 화면 -> 클립보드
					nscreen = cur.screen;
					nboard = cur.screen;
				} else if (i == 1) { // 클립보드 -> 화면
					nscreen = cur.screen + cur.board;
					nboard = cur.board;
				} else { // 화면 - 1
					nscreen = cur.screen - 1;
					nboard = cur.board;
				}

				// 범위 이탈, 방문 여부 확인
				if (nscreen < 0 || nboard < 0 || visited[nscreen][nboard])
					continue;

				// 목표 도달
				if (nscreen == target) {
					System.out.println(nsec);
					break OUT;
				}

				visited[nscreen][nboard] = true;
				q.add(new emoticon(nscreen, nboard, nsec));
			}
		}

		br.close();
	}
}

class emoticon {
	int screen, board, sec;

	public emoticon(int screen, int board, int sec) {
		super();
		this.screen = screen;
		this.board = board;
		this.sec = sec;
	}
}