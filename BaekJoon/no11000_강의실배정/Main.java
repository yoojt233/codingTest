package BaekJoon.no11000_강의실배정;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
	static PriorityQueue<Integer> live;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		lesson[] lessons = new lesson[N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			lessons[i] = new lesson(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(lessons);
		int max = 0;
		live = new PriorityQueue<>();
		for (lesson l : lessons)
			max = Math.max(max, find(l));

		System.out.print(max);
		br.close();
	}

	private static int find(lesson cur) {
		while (!live.isEmpty() && live.peek() <= cur.startTime)
			live.poll();
		live.add(cur.endTime);
		return live.size();
	}
}

class lesson implements Comparable<lesson> {
	int startTime, endTime;

	public lesson(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	@Override
	public int compareTo(lesson o) {
		return this.startTime - o.startTime;
	}
}