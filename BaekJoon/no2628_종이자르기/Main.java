package BaekJoon.no2628_종이자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int r, c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		int N = Integer.parseInt(br.readLine());

		divide[] act = new divide[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			act[i] = new divide(st.nextToken(), st.nextToken());
		}
		Arrays.sort(act);// 가로-> 세로 정렬, 라인 넘버가 작은 순서로

		List<Integer> x = new LinkedList<Integer>();// 가로로 잘랐을 때 남는 부분들
		List<Integer> y = new LinkedList<Integer>();// 세로로 잘랐을 때 남는 부분들

		int min_x = 0, min_y = 0;
		for (int i = 0; i < N; i++) {
			switch (act[i].dir) {
			case 0:
				x.add(act[i].n - min_x); // 자른 윗 부분
				min_x = act[i].n;
				break;
			case 1:
				y.add(act[i].n - min_y); // 자른 왼쪽 부분
				min_y = act[i].n;
				break;
			}
		}
		x.add(c - min_x); // 자르고 남은 아랫 부분
		y.add(r - min_y); // 자르고 남은 오른쪽 부분

		// 정렬하면 마지막 idx가 최댓값
		Collections.sort(x);
		Collections.sort(y);

		int area = x.get(x.size() - 1) * y.get(y.size() - 1);

		System.out.println(area);
		br.close();
	}

	static class divide implements Comparable<divide> {
		int dir, n;

		public divide(String dir, String n) {
			super();
			this.dir = Integer.parseInt(dir);
			this.n = Integer.parseInt(n);
		}

		@Override
		public int compareTo(divide o) { // 가로 먼저 정렬, n에 따른 오름차순
			return this.dir != o.dir ? this.dir - o.dir : this.n - o.n;
		}
	}
}
