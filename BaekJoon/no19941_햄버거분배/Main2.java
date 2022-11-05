package BaekJoon.no19941_햄버거분배;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] range = br.readLine().split(" ");
		int N = Integer.parseInt(range[0]);
		int K = Integer.parseInt(range[1]);

		char[] table = br.readLine().toCharArray();
		boolean[] ate = new boolean[N];
		int ans = 0;
		for (int i = 0; i < N; ++i) {
			if (table[i] == 'H')
				continue;

			for (int j = -K; j <= K; ++j) {
				int cur = i + j;
				if (cur < 0 || cur >= N || ate[cur] || table[cur] == 'P')
					continue;
				ate[cur] = true;
				++ans;
				break;
			}
		}

		System.out.print(ans);
		br.close();
	}
}
