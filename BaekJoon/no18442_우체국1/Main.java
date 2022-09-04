package BaekJoon.no18442_우체국1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[] village, ans;
	static int V, P;
	static long L, min = Long.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		L = Long.parseLong(st.nextToken());

		village = new long[V];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < V; i++)
			village[i] = Long.parseLong(st.nextToken());

		ans = new long[P];
		combo(0, 0, new long[P]);

		sb.append(min + "\n");
		for (long i : ans)
			sb.append(i + " ");

		System.out.print(sb.toString());
		br.close();
	}

	private static void combo(int cnt, int start, long[] sel) {
		if (cnt == P) {
			long sum = 0;
			for (int i = 0; i < V; i++)
				sum += nearPolice(i, sel); // i 번째 마을에서 가장 가까운 우체국

			if (sum < min) { // 최솟값이 갱신되었으면 ans를 선택된 조합으로
				min = sum;
				ans = sel.clone();
			}

			return;
		}

		for (int i = start; i < V; i++) {
			sel[cnt] = village[i];
			combo(cnt + 1, i + 1, sel);
		}
	}

	private static long nearPolice(int n, long[] sel) {
		long near = Long.MAX_VALUE;

		for (int i = 0; i < P; i++) {
			if (village[n] == sel[i]) // 내 자리가 우체국
				return 0;

			long distance = Math.abs(village[n] - sel[i]);
			distance = Math.min(distance, L - distance);
			near = Math.min(near, distance);
		}

		return near;
	}
}
