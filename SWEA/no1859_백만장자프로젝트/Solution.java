package SWEA.no1859_백만장자프로젝트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {

			int N = Integer.parseInt(br.readLine());

			// 물건 가격 배열 지정
			Stack<Integer> price = new Stack<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				price.push(Integer.parseInt(st.nextToken()));

			long ans = 0;
			int max = price.pop();
			while (!price.isEmpty()) {
				if (price.peek() < max) {
					ans += (max - price.peek());
					price.pop();
				} else {
					max = price.pop();
				}
			}

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ").append(ans);
			System.out.println(sb.toString());
		}
		br.close();
	}
}
