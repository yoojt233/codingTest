package BaekJoon.no14719_빗물;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	static int w;
	static int[] block;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int h = Integer.parseInt(st.nextToken()); // 최대 높이(사실 필요x)
		w = Integer.parseInt(st.nextToken()); // 가로로 놓인 블록 수

		block = new int[w]; // 각 블록의 높이를 저장
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < w; i++)
			block[i] = Integer.parseInt(st.nextToken());

		int total = 0;
		for (int i = 1; i < w - 1; i++) {
			int left = getLeft(i); // 왼쪽 최대 높이 블록
			int right = getRight(i); // 오른쪽 최대 높이 블록

			total += (Integer.min(left, right) - block[i]);
		}

		System.out.print(total);
		br.close();
	}

	// 왼쪽과 오른쪽의 max 값을 구할 때, 본인이 최대 높이일 경우가 있으므로 탐색 범위에 자기 자신을 넣어야한다.
	private static int getLeft(int cur) {
		int max = 0;
		for (int i = 0; i <= cur; i++) {
			if (block[i] >= block[cur])
				max = Integer.max(max, block[i]);
		}

		return max;
	}

	private static int getRight(int cur) {
		int max = 0;
		for (int i = cur; i < w; i++) {
			if (block[i] >= block[cur])
				max = Integer.max(max, block[i]);
		}

		return max;
	}
}
