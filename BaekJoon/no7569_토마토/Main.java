package BaekJoon.no7569_토마토;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = { -1, 1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, -1, 1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		int[][][] box = new int[row][col][height];

		int total = 0;
		Queue<pos> welldone = new LinkedList<pos>();

		for (int k = 0; k < height; ++k) {
			for (int j = 0; j < col; ++j) {
				st = new StringTokenizer(br.readLine());
				for (int i = 0; i < row; ++i) {
					int status = Integer.parseInt(st.nextToken());
					box[i][j][k] = status;

					if (status == 0)
						++total;
					else if (status == 1)
						welldone.add(new pos(i, j, k));
				}
			}
		}

		int ans = -1;
		while (!welldone.isEmpty()) {
			int size = welldone.size();
			for (int i = 0; i < size; ++i) {
				pos cur = welldone.poll();

				for (int d = 0; d < 6; ++d) {
					int cx = cur.x + dx[d];
					int cy = cur.y + dy[d];
					int cz = cur.z + dz[d];

					if (cx < 0 || cx >= row || cy < 0 || cy >= col || cz < 0 || cz >= height || box[cx][cy][cz] != 0)
						continue;

					box[cx][cy][cz] = 1;
					--total;
					welldone.add(new pos(cx, cy, cz));
				}
			}
			++ans;
		}

		System.out.print(total > 0 ? -1 : ans);
		br.close();
	}
}

class pos {
	int x, y, z;

	public pos(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
