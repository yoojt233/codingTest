package BaekJoon.no1449_수리공항승;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, L;
	static int[] where;
	static boolean[] check;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 물이 새는 곳 개수
		L = Integer.parseInt(st.nextToken()); // 테이프 길이
		where = new int[N];
		check = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			where[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(where);

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (!check[i]) {
				int start = where[i];
				for (int j = i + 1; j < N; j++) {
					if (where[j] < start + L)
						check[j] = true;
				}
				cnt++;
			}
		}

		System.out.print(cnt);
		br.close();
	}
}
