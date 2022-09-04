package BaekJoon.no2805_나무자르기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] tree = new int[N];
		int min = 0;
		int max = Integer.MIN_VALUE;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			tree[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, tree[i]);
		}

		while (min < max) {
			long sum = 0;
			int mid = (min + max) / 2;

			for (int i : tree) {
				if (i > mid)
					sum += (i - mid);
			}

			if (sum < M)
				max = mid;
			else
				min = mid + 1;
		}

		System.out.println(min - 1);
		br.close();
	}
}
