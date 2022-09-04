package BaekJoon.no1525_퍼즐;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static HashSet<String> exist = new HashSet<>(); // 이미 돌려봤던 퍼즐 저장
	static Queue<pos> zero = new LinkedList<>(); // 0의 위치 저장
	static Queue<String> map = new LinkedList<>(); // 퍼즐 경우

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 2차원 배열을 1차원으로 바꾸어 String으로 저장
		// 배열 자체를 HashSet에 저장하면 contains로 확인할 수 없다.
		String first = "";
		for (int i = 0; i < 3; i++) {
			String[] temp = br.readLine().split(" ");
			for (int j = 0; j < 3; j++) {
				first += temp[j];
				if (temp[j].equals("0"))
					zero.offer(new pos(i, j));
			}
		}

		// 처음 퍼즐 저장
		exist.add(first);
		map.offer(first);

		System.out.print(move(map));
		br.close();
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static int move(Queue<String> q) {
		int level = 0; // 깊이, 이동 횟수

		while (!q.isEmpty()) {
			int size = q.size(); // 같은 level의 수만큼

			for (int i = 0; i < size; i++) {
				String map = q.poll(); // 현재 퍼즐
				pos cur = zero.poll(); // 현재 0의 위치

				// 목표 달성 시
				if (map.equals("123456780"))
					return level;

				for (int d = 0; d < 4; d++) {
					int cx = cur.x + dx[d];
					int cy = cur.y + dy[d];

					if (cx < 0 || cx >= 3 || cy < 0 || cy >= 3)
						continue;

					// 다음 경우에서도 같은 퍼즐을 쓸 수 있으므로 퍼즐을 복사하여 움직인다
					char temp = map.charAt(cx * 3 + cy);

					String cmap = map.replace(temp, '9');
					cmap = cmap.replace('0', temp);
					cmap = cmap.replace('9', '0');

					// 이미 시도했던 퍼즐의 경우이면 안된다
					if (!exist.contains(cmap)) {
						exist.add(cmap);
						q.offer(cmap);
						zero.offer(new pos(cx, cy));
					}
				}
			}
			++level;
		}

		// 여기까지 왔다면 불가능
		return -1;
	}
}

// 좌표
class pos {
	int x, y;

	public pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}