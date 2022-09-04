package BaekJoon.no2457_공주님의정원;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] month_day = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		days[] flowers = new days[N];

		// 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken());
			int ed = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken());
			flowers[i] = new days(op, ed);
		}

		// 정렬
		Arrays.sort(flowers);

		int start = 301;
		int end = 1131;
		int last = 0;
		int idx = 0;
		int cnt = 0;

		while (start <= end) {
			boolean flag = false;

			for (int i = idx; i < N; i++) {
				if (flowers[i].op > start)
					break;

				if (last < flowers[i].ed) {
					flag = true;
					last = flowers[i].ed;
					idx = i + 1; // 탐색 범위를 줄여준다.
				}
			}

			if (flag) {
				start = last;
				cnt++;
			} else
				break;
		}

		// start가 11월 31일을 넘어가면 가능
		if (start >= end)
			System.out.println(cnt);
		else
			System.out.println(0);

		br.close();
	}
}

class days implements Comparable<days> {
	int op, ed;

	public days(int op, int ed) {
		super();
		this.op = op;
		this.ed = ed;
	}

	@Override
	public int compareTo(days o) {

		// 꽃의 개화 기준 오름차순, 같을 경우 낙화 기준 내림차순
		if (this.op == o.op)
			return o.ed - this.ed;
		return this.op - o.op;
	}
}