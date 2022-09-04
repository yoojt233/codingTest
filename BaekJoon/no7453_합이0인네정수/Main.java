package BaekJoon.no7453_합이0인네정수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] ab, cd;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[4][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++)
				arr[j][i] = Integer.parseInt(st.nextToken());
		}

		ab = new int[N * N];
		cd = new int[N * N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ab[i * N + j] = arr[0][i] + arr[1][j];
				cd[i * N + j] = arr[2][i] + arr[3][j];
			}
		}

		Arrays.sort(cd);

		long ans = 0;
		for (int i : ab)
			ans += (right(0, N * N - 1, -i) - left(0, N * N - 1, -i));

		System.out.print(ans);
		br.close();
	}

	// Lower bound
	private static int left(int st, int ed, int target) {
		while (st <= ed) {
			int mid = (st + ed) / 2;
			if (cd[mid] >= target)
				ed = mid - 1;
			else
				st = mid + 1;
		}
		return ed;
	}

	// Upper bound
	private static int right(int st, int ed, int target) {
		while (st <= ed) {
			int mid = (st + ed) / 2;
			if (cd[mid] <= target)
				st = mid + 1;
			else
				ed = mid - 1;
		}
		return ed;
	}
}
