package BaekJoon.no2669_직사각형네개의합집합의면적구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[100][100];

		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			paint(map, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		int area = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] > 0)
					area++;
			}
		}

		System.out.print(area);
		br.close();
	}

	private static void paint(int[][] map, int sx, int sy, int ex, int ey) {
		for (int i = sx; i < ex; i++) {
			for (int j = sy; j < ey; j++) {
				map[i][j]++;
			}
		}
	}
}
