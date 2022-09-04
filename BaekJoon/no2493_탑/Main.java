package BaekJoon.no2493_탑;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		Stack<int[]> tower = new Stack<int[]>();
		int[] ans = new int[n];

		String str = br.readLine();
		StringTokenizer s = new StringTokenizer(str);

		for (int i = 0; i < n; i++) {
			int temp = Integer.parseInt(s.nextToken());
			while (!tower.isEmpty()) {
				if (tower.peek()[1] < temp)
					tower.pop();
				else {
					sb.append(tower.peek()[0]).append(" ");
					break;
				}
			}
			if (tower.isEmpty())
				sb.append(0).append(" ");
			tower.push(new int[] { i + 1, temp });
		}

		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}