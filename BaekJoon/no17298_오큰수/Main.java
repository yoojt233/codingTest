package BaekJoon.no17298_오큰수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine()); // 숫자 개수
		int[] num = new int[n]; // 칸 별 오큰수 저장

		Stack<number> s = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int cur = Integer.parseInt(st.nextToken()); // 현재 값

			// Stack이 비어있지 않으면서, 왼쪽 값이 작은 경우 
			while (!s.isEmpty() && s.peek().val < cur) {
				number temp = s.pop();
				num[temp.idx] = cur;
			}
			
			// 현재 값 삽입
			s.push(new number(i, cur));
		}

		// 오큰수 출력
		for (int i : num) {
			if (i != 0)
				sb.append(i);
			else
				sb.append(-1);
			sb.append(" ");
		}

		System.out.print(sb.toString());
		br.close();
	}
}

// 배열의 몇 번째 인덱스? 그 인덱스의 숫자는?
class number {
	int idx, val;

	public number(int idx, int val) {
		super();
		this.idx = idx;
		this.val = val;
	}
}