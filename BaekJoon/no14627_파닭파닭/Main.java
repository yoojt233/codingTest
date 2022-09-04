package BaekJoon.no14627_파닭파닭;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 파 갯수
		int chicken = Integer.parseInt(st.nextToken()); // 치킨 갯수
		int max = Integer.MIN_VALUE;

		int[] pa = new int[N];
		long total = 0;
		for (int i = 0; i < N; i++) {
			pa[i] = Integer.parseInt(br.readLine());
			total += pa[i];
			max = Math.max(max, pa[i]); // 가장 긴 파
		}

		long start = 1;
		long end = max;

		while (start < end) {
			int cnt = 0;
			long mid = (start + end) / 2;

			for (int i : pa)
				cnt += (i / mid);

			// 치킨 수 충족 시
			if (cnt >= chicken)
				start = mid + 1;
			else // 충족 불가
				end = mid - 1;
		}

		System.out.print(total - ((start + end) / 2) * chicken);
		br.close();
	}
}
