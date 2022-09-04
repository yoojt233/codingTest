package BaekJoon.no1713_후보추천하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 사진 틀 갯수
		int M = Integer.parseInt(br.readLine()); // 추천 횟수
		StringTokenizer st = new StringTokenizer(br.readLine());

		List<rec> std = new LinkedList<rec>();
		int[] cnt = new int[101];

		for (int i = 0; i < M; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if (std.size() < N && cnt[temp] == 0) {
				std.add(new rec(std.size(), temp, 1));
				cnt[temp]++;
			} else if (cnt[temp] > 0) {
				cnt[temp]++;
				for (int j = 0; j < std.size(); j++) {
					if (std.get(j).name == temp)
						std.get(j).cnt++;
				}
			} else {
				Collections.sort(std);
				cnt[std.get(0).name] = 0;
				cnt[temp]++;
				std.get(0).num = i;
				std.get(0).name = temp;
				std.get(0).cnt = 1;
			}
		}

		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i] != 0)
				System.out.printf("%d ", i);
		}

		br.close();
	}

	static class rec implements Comparable<rec> {
		int num, name, cnt;

		public rec(int num, int name, int cnt) {
			this.num = num;
			this.name = name;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(rec o) {
			return this.cnt != o.cnt ? this.cnt - o.cnt : this.num - o.num;
		}
	}
}
