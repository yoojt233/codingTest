package BaekJoon.no16953_AB;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long op = Integer.parseInt(st.nextToken());
		long ed = Integer.parseInt(st.nextToken());

		Deque<Long> dq = new ArrayDeque<Long>();
		dq.offer(op);

		int ans = 1;
		boolean flag = false;
		OUT: while (!dq.isEmpty()) {
			int size = dq.size();

			for (int i = 0; i < size; ++i) {
				long cur = dq.poll();

				if (cur == ed) {
					flag = true;
					break OUT;
				}

				long next = cur;
				for (int j = 0; j < 2; ++j) {
					if (j == 0)
						next = cur * 2;
					else
						next = cur * 10 + 1;

					if (next > Integer.MAX_VALUE)
						continue;
					dq.offer(next);
				}
			}

			++ans;
		}

		if (!flag)
			ans = -1;

		System.out.print(ans);
		br.close();
	}
}
