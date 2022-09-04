package BaekJoon.no15961_회전초밥;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, d, k, c; // 접시, 초밥 가짓 수, 연속 접시, 쿠폰
	static int[] table;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		table = new int[N];
		for (int i = 0; i < N; i++)
			table[i] = Integer.parseInt(br.readLine());

		int temp = 1;
		int[] sushi = new int[d + 1];
		sushi[c] = 1; // 확정 초밥
		for (int i = 0; i < k; i++) { // 처음 먹으면 temp + 1
			if (sushi[table[i]] == 0)
				temp++;
			sushi[table[i]]++;
		}

		int ans = temp;
		for (int i = k; i < N + k; i++) {
			int op = table[(i - k) % N];
			int ed = table[i % N];

			if (--sushi[op] == 0)
				temp--;

			if (sushi[ed]++ == 0)
				temp++;

			ans = Math.max(ans, temp);
			if (ans == d)
				break;
		}
		System.out.print(ans);
		br.close();
	}
}
