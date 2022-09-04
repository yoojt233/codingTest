package BaekJoon.no2096_내려가기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		block[][] map = new block[N][3];

		// 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = new block(temp, temp);
			}
		}

		for (int i = 1; i < N; i++) {
			map[i][0].high += Math.max(map[i - 1][0].high, map[i - 1][1].high);
			map[i][1].high += getMax(map[i - 1][0].high, map[i - 1][1].high, map[i - 1][2].high);
			map[i][2].high += Math.max(map[i - 1][1].high, map[i - 1][2].high);

			map[i][0].low += Math.min(map[i - 1][0].low, map[i - 1][1].low);
			map[i][1].low += getMin(map[i - 1][0].low, map[i - 1][1].low, map[i - 1][2].low);
			map[i][2].low += Math.min(map[i - 1][1].low, map[i - 1][2].low);
		}

		// 마지막 행에서 최솟값, 최댓값 찾기
		int max = getMax(map[N - 1][0].high, map[N - 1][1].high, map[N - 1][2].high);
		int min = getMin(map[N - 1][0].low, map[N - 1][1].low, map[N - 1][2].low);

		System.out.printf("%d %d", max, min);
		br.close();
	}

	// 세 숫자의 최대 최소 비교
	private static int getMin(int a, int b, int c) {
		return Math.min(Math.min(a, b), c);
	}

	private static int getMax(int a, int b, int c) {
		return Math.max(Math.max(a, b), c);
	}
}

// 배열 두 개, 3차원 배열 만들기 싫어서 만든 클래스
// 칸에 해당 하는 high에 최댓값, low에 최솟값 저장
class block {
	int high, low;

	public block(int high, int low) {
		super();
		this.high = high;
		this.low = low;
	}
}
