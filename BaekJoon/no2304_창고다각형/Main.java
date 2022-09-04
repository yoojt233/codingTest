package BaekJoon.no2304_창고다각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		storage[] group = new storage[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			group[i] = new storage(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(group);

		// 왼쪽부터 가장 높은 창고까지 sum
		int min = 0;
		for (int i = 0; i < N - 1; i++) {
			if (group[min].y < group[i + 1].y) {
				sum += (group[i + 1].x - group[min].x) * group[min].y;
				min = i + 1;
			}
		}

		// 오른쪽부터 가장 높은 창고까지 sum
		// 같은 높이의 창고가 있을 수 있기 때문에 밑에선 <=를 넣어줌
		int max = N - 1;
		for (int i = N - 1; i >= 1; i--) {
			if (group[max].y <= group[i - 1].y) {
				sum += (group[max].x - group[i - 1].x) * group[max].y;
				max = i - 1;
			}
		}

		// 가장 높은 창고 sum
		sum += group[min].y;

		System.out.print(sum);
		br.close();
	}

	// 창고 클래스, x축 기준 정렬
	static class storage implements Comparable<storage> {
		int x, y;

		public storage(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(storage o) {
			return this.x - o.x;
		}
	}
}
