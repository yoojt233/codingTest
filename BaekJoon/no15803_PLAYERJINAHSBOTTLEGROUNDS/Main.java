package BaekJoon.no15803_PLAYERJINAHSBOTTLEGROUNDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		pos[] p = new pos[3];
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			p[i] = new pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(p);

		boolean flag = false;
		if (slope(p[0], p[1]) == slope(p[1], p[2]))
			flag = true;

		if (flag)
			System.out.println("WHERE IS MY CHICKEN?");
		else
			System.out.println("WINNER WINNER CHICKEN DINNER!");

		br.close();
	}

	private static double slope(pos a, pos b) {
		double x = (double) (b.y - a.y) / (double) (b.x - a.x);
		return x;
	}
}

class pos implements Comparable<pos> {
	int x, y;

	public pos(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(pos o) {
		if (this.x != o.x)
			return this.x - o.x;
		else
			return this.y - o.y;
	}
}