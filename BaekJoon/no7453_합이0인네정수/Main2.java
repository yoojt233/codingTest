package BaekJoon.no7453_합이0인네정수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
	static int N;
	static int[] ab, cd;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++)
				arr[j][i] = Integer.parseInt(st.nextToken());
		}

		// ab = a + b 배열, cd = c + d 배열
		ab = new int[N * N];
		cd = new int[N * N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ab[i * N + j] = arr[0][i] + arr[1][j];
				cd[i * N + j] = arr[2][i] + arr[3][j];
			}
		}

		Arrays.sort(ab);
		Arrays.sort(cd);

		int op = 0; // 시작
		int ed = N * N - 1; // 마지막
		long ans = 0;

		// a + b 배열의 작은 수 부터, c + d 배열의 큰 수 부터 탐색 시작
		OUT: while (op < N * N && ed >= 0) {
			int left = ab[op];
			int right = cd[ed];

			// 두 수의 합이 음수라면 작은 수를 증가 시켜야한다.
			if (left + right < 0) {
				op++;
				continue OUT;
			}

			// 두 수의 합이 양수라면 큰 수를 감소 시켜야한다.
			if (left + right > 0) {
				ed--;
				continue OUT;
			}

			// 원하는 경우라면
			if (left + right == 0) {
				long left_cnt = 0, right_cnt = 0;

				// 왼쪽부터 같은 수가 몇 개인지
				while (op < N * N && left == ab[op]) {
					left_cnt++;
					op++;
				}

				// 오른쪽부터 같은 수가 몇 개인지
				while (ed >= 0 && right == cd[ed]) {
					right_cnt++;
					ed--;
				}

				// left_cnt * right_cnt 값이 long일 수 있기 때문에 둘 다 long으로 지정
				ans += left_cnt * right_cnt;
			}
		}

		System.out.print(ans);
		br.close();
	}
}
