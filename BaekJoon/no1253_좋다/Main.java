package BaekJoon.no1253_좋다;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			num[i] = Integer.parseInt(st.nextToken());

		// 이분 탐색 필수 조건
		Arrays.sort(num);

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int left = 0;
			int right = N - 1;

			while (left < right) {
				
				// 자기 자신을 더하거나 빼는데 사용하면 안된다.
				if (left == i)
					left++;
				if (right == i)
					right--;
				if (left == right)	// 값 변경 후 재검사
					break;

				// 목표
				int val = num[left] + num[right];
				if (val > num[i])
					right--;
				else if (val < num[i])
					left++;
				else {
					cnt++;
					break;
				}
			}
		}

		System.out.println(cnt);
		br.close();
	}
}
