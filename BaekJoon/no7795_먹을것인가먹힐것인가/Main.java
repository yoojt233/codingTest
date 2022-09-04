package BaekJoon.no7795_먹을것인가먹힐것인가;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static long ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 테케
		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			ans = 0; // 정답 초기화

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			long[] A = new long[N];
			long[] B = new long[M];

			// A 입력 및 정렬
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				A[i] = Long.parseLong(st.nextToken());
			Arrays.sort(A);

			// B 입력 및 정렬
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++)
				B[i] = Long.parseLong(st.nextToken());
			Arrays.sort(B);

			twoPointer(A, B);
			sb.append(ans + "\n");
		}

		System.out.print(sb.toString());
		br.close();
	}

	private static void twoPointer(long[] a, long[] b) {
		int left = 0, right = 0;

		while (left < N && right < M) {

			if (a[left] > b[right]) {
				long cnt = 1;

				// a[left]보다 크거나 같아질 때 까지 right 증가
				while (++right < M && b[right] < a[left])
					cnt++;

				ans += (N - left) * cnt;
			} else	
				left++;
		}
	}
}
