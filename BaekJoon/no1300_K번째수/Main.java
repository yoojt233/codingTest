package BaekJoon.no1300_K번째수;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());

		long left = 1;
		long right = k;
		long ans = 0;
		while (left <= right) {
			long sum = 0;
			
			long mid = (left + right) / 2;
			for (int i = 1; i <= N; i++)
				sum += Math.min(mid / i, N);

			if (sum < k) 
				left = mid + 1;
			else {
				ans = mid;
				right = mid - 1;
			}
		}

		System.out.print(ans);
		br.close();
	}
}
