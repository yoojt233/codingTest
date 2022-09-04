package BaekJoon.no11501_주식;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		while (tc-- > 0) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			int[] pr = new int[N];
			for (int i = 0; i < N; i++)
				pr[i] = Integer.parseInt(st.nextToken());

			long ans = 0;
			Stack<Integer> s = new Stack<Integer>();
			for (int i = N - 1; i >= 0; i--) {
				int cur = pr[i];
				if (s.isEmpty())
					s.push(cur);
				else if (s.peek() > cur)
					ans += (s.peek() - cur);
				else if (s.peek() < cur) {
					s.pop();
					s.push(cur);
				}
			}

			sb.append(ans + "\n");
		}

		System.out.print(sb.toString());
		br.close();
	}
}
