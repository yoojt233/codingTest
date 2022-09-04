package BaekJoon.no2527_직사각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static class Square {
		int x, y, p, q;

		public Square(int x, int y, int p, int q) {
			this.x = x;
			this.y = y;
			this.p = p;
			this.q = q;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			Square a = new Square(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			Square b = new Square(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			int x = Math.max(a.x, b.x);
			int y = Math.max(a.y, b.y);
			int p = Math.min(a.p, b.p);
			int q = Math.min(a.q, b.q);

			if (x < p && y < q)
				sb.append("a\n");
			else if ((x == p && y < q) || (y == q && x < p))
				sb.append("b\n");
			else if (x == p && y == q)
				sb.append("c\n");
			else
				sb.append("d\n");
		}
		System.out.println(sb.toString());
	}
}
