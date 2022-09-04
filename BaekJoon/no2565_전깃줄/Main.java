package BaekJoon.no2565_전깃줄;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		line[] lines = new line[N];
		int[] dp = new int[N]; // LIS

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			lines[i] = new line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(lines);

		int len = 0;
		dp[0] = lines[0].to; // 첫 번째는 무조건 삽입
		for (int i = 1; i < N; i++) {
			if (lines[i].to > dp[len])
				dp[++len] = lines[i].to;
			else {
				int where = Arrays.binarySearch(dp, 0, len + 1, lines[i].to);
				if (where < 0)
					dp[-where - 1] = lines[i].to;
			}
		}

		// 최대 LIS는 len + 1. 출력은 없애야 할 전깃줄 수.
		System.out.print(N - len - 1);
		br.close();
	}
}

// 전깃줄의 시작 지점과 끝 지점
// 시작 지점 기준 정렬
class line implements Comparable<line> {
	int from, to;

	public line(int from, int to) {
		super();
		this.from = from;
		this.to = to;
	}

	@Override
	public int compareTo(line o) {
		return this.from - o.from;
	}
}
