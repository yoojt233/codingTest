package BaekJoon.no8979_올림픽;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		medal[] country = new medal[N];

		int x = 0, y = 0, z = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (n == k) {
				x = g;
				y = s;
				z = c;
			}
			country[i] = new medal(n, g, s, c);
		}

		Arrays.sort(country);
		for (int i = 0; i < N; i++) {
			if (country[i].gold == x && country[i].silver == y && country[i].copper == z) {
				System.out.print(i + 1);
				break;
			}
		}
		br.close();
	}

	static class medal implements Comparable<medal> {
		int num, gold, silver, copper;

		public medal(int num, int gold, int silver, int copper) {
			this.num = num;
			this.gold = gold;
			this.silver = silver;
			this.copper = copper;
		}

		@Override
		public int compareTo(medal o) {
			if (this.gold != o.gold)
				return o.gold - this.gold;
			else if (this.silver != o.silver)
				return o.silver - this.silver;
			else
				return o.copper - this.copper;
		}
	}
}
