package BaekJoon.no13164_행복유치원;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 유치원생 수
		int K = Integer.parseInt(st.nextToken()); // 그룹 수

		int[] kids = new int[N]; // 원생들의 키
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			kids[i] = Integer.parseInt(st.nextToken());

		PriorityQueue<Integer> gap = new PriorityQueue<>();
		for (int i = 0; i < N - 1; i++)
			gap.add(kids[i + 1] - kids[i]);

		int total = 0;
		for (int i = 0; i < N - K; i++)
			total += gap.poll();

		System.out.println(total);
		br.readLine();
	}
}
