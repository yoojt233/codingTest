package BaekJoon.no14391_종이조각;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());

		map = new int[row][col];
		for (int i = 0; i < row; i++) {
			String s = br.readLine();
			for (int j = 0; j < col; j++)
				map[i][j] = s.charAt(j) - '0';
		}

		visited = new boolean[row][col];
		
		
		br.close();
	}
}
