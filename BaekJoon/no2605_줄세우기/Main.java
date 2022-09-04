package BaekJoon.no2605_줄세우기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] number = new int[N];
		for (int i = 0; i < N; i++)
			number[i] = Integer.parseInt(st.nextToken());

		List<Integer> line = new LinkedList<Integer>();

		int idx = 1;
		for (int i = 0; i < N; i++)
			line.add(number[i], idx++);

		for (int i = line.size() - 1; i >= 0; i--) {
			sb.append(line.get(i)).append(" ");
		}

		System.out.print(sb.toString());
		br.close();
	}
}