package BaekJoon.no11650_좌표정렬하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		pos[] input = new pos[N];

		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			input[i] = new pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(input);
		StringBuilder sb = new StringBuilder();
		for (pos p : input)
			sb.append(p.toString() + "\n");

		System.out.println(sb);
		br.close();
	}
}

class pos implements Comparable<pos> {
	int x, y;

	public pos(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int compareTo(pos o) {
		return this.x != o.x ? this.x - o.x : this.y - o.y;
	}

	public String toString() {
		return x + " " + y;
	}
}