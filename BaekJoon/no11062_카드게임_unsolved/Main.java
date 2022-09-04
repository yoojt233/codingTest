package BaekJoon.no11062_카드게임_unsolved;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] card = new int[N];
			int[] score=new int[2];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				card[i] = Integer.parseInt(st.nextToken());

			int idx = 0;
			
			
		}

		System.out.print(sb.toString());
		br.close();
	}
}
