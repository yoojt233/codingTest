package BaekJoon.no11067_모노톤길;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static boolean flag;
	static pos[] cafe;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine()); // TestCase

		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());

			cafe = new pos[N + 1];
			cafe[0] = new pos("-1", "0");

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				cafe[i] = new pos(st.nextToken(), st.nextToken());
			}

			Arrays.sort(cafe);
			for (int i = 1; i < N; i++) {

				// x 좌표가 다를 때
				if (cafe[i].x != cafe[i + 1].x) {

					// y 좌표가 같으면 방향유지, 다르면 reverse 필요
					if (cafe[i].y == cafe[i + 1].y)
						flag = true;
					else
						flag = false;
				}

				// x 좌표가 같은 값들 reverse
				else {
					if (!flag)
						reverse(i);
				}
			}

			// 출력 부분
			st = new StringTokenizer(br.readLine());

			int out = Integer.parseInt(st.nextToken());
			for (int i = 0; i < out; i++) {
				int idx = Integer.parseInt(st.nextToken());
				sb.append(cafe[idx].x).append(" ").append(cafe[idx].y).append("\n");
			}
		}
		System.out.print(sb.toString());
		br.close();
	}

	private static void reverse(int start) {
		Stack<pos> s = new Stack<>();
		for (int i = start; i <= N; i++) {
			if (cafe[i].x == cafe[start].x)
				s.add(cafe[i]);
			else
				break;
		}

		int size = s.size();
		for (int i = start; i < start + size; i++) {
			cafe[i] = s.pop();
		}

		flag = true;
	}
}

class pos implements Comparable<pos> {
	int x, y;

	public pos(String x, String y) {
		super();
		this.x = Integer.parseInt(x);
		this.y = Integer.parseInt(y);
	}

	@Override
	public int compareTo(pos o) {
		return this.x != o.x ? this.x - o.x : this.y - o.y;
	}
}