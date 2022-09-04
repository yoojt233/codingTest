package SWEA.no1210_Ladder1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	// 좌 우 상
	static int[] dx = { 0, 0, -1 };
	static int[] dy = { -1, 1, 0 };

	static String[][] arr;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int tc = 10; // 테스트 케이스
		int ans = 0;
		sb = new StringBuilder();
		while (tc > 0) {
			String str = br.readLine();
			sb.append("#").append(str).append(" ");
			// 사다리 생성
			arr = new String[100][100];

			for (int i = 0; i < 100; i++) {
				str = br.readLine();
				StringTokenizer st = new StringTokenizer(str);
				for (int j = 0; j < 100; j++)
					arr[i][j] = st.nextToken();
			}

			// 골인 지점부터 출발
			for (int i = 0; i < 100; i++) {
				if (arr[99][i].equals("2")) {
					ans = ride(99, i);
				}
			}

			sb.append(ans).append("\n");
			tc--;
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

	private static int ride(int x, int y) {
		int cx = x;
		int cy = y;
		while (cx > 0) {
			for (int i = 0; i < 3; i++) {
				if (cx == 0)
					break;
				cx += dx[i];
				cy += dy[i];
				if (cy < 100 && cy >= 0 && arr[cx][cy].equals("1")) {
					switch (i) {
					case 0:
						cy = moveLeft(cx, cy);
						cx -= 1;
						i = -1;
						break;
					case 1:
						cy = moveRight(cx, cy);
						cx -= 1;
						i = -1;
						break;
					default:
						break;
					}
				} else {
					cx -= dx[i];
					cy -= dy[i];
				}
			}
		}
		return cy;
	}

	private static int moveLeft(int x, int y) {
		while (y >= 0 && arr[x][y].equals("1"))
			y -= 1;
		return y + 1;
	}

	private static int moveRight(int x, int y) {
		while (y <= 99 && arr[x][y].equals("1"))
			y += 1;
		return y - 1;
	}
}