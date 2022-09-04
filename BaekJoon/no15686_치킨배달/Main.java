package BaekJoon.no15686_치킨배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int M, answer;
	static List<position> shop;
	static List<position> house;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		shop = new LinkedList<position>();
		house = new LinkedList<position>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp == 1) // 집 좌표
					house.add(new position(i, j));
				else if (temp == 2) // 치킨집 좌표
					shop.add(new position(i, j));
			}
		}

		answer = Integer.MAX_VALUE;
		combo(0, 0, new position[M]);
		System.out.print(answer);
		br.close();
	}

	private static void combo(int cnt, int start, position[] chicken) {
		if (cnt == M) {
			int total = 0;
			for (int i = 0, n = house.size(); i < n; i++) {
				int dis = Integer.MAX_VALUE;
				for (int j = 0; j < M; j++) {
					int temp = Math.abs(house.get(i).x - chicken[j].x) + Math.abs(house.get(i).y - chicken[j].y);
					dis = Math.min(dis, temp);
				}
				total += dis;
			}
			answer = Math.min(answer, total);
			return;
		}

		for (int i = start, n = shop.size(); i < n; i++) {
			chicken[cnt] = shop.get(i);
			combo(cnt + 1, i + 1, chicken);
		}
	}

	static class position {
		int x, y;

		public position(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
