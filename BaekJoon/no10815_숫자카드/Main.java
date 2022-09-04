package BaekJoon.no10815_숫자카드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		HashSet<Integer> card = new HashSet<Integer>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			card.add(Integer.parseInt(st.nextToken()));

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			if (card.contains(Integer.parseInt(st.nextToken())))
				sb.append(1 + " ");
			else
				sb.append(0 + " ");
		}

		System.out.print(sb.toString());
		br.close();
	}
}
