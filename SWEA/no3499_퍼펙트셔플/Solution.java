package SWEA.no3499_퍼펙트셔플;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			sb.append("#").append(t).append(" ");

			int n = Integer.parseInt(br.readLine());

			Stack<String> U = new Stack<>();
			Stack<String> A = new Stack<>();
			Stack<String> B = new Stack<>();

			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);

			for (int i = 0; i < n; i++)
				U.push(st.nextToken());

			for (int i = 0; i < n / 2; i++)
				B.push(U.pop());

			while (!U.isEmpty())
				A.push(U.pop());

			for (int i = 0; i < n; i++) {
				if (i % 2 == 0)
					U.push(A.pop());
				else
					U.push(B.pop());
				sb.append(U.elementAt(i)).append(" ");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
