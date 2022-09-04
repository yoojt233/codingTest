package BaekJoon.no6198_옥상정원꾸미기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 빌딩 수
		int[] building = new int[N];
		for (int i = 0; i < N; i++)
			building[i] = Integer.parseInt(br.readLine());

		long total = 0;
		Stack<Integer> s = new Stack<>();

		// 맨 뒤부터 스택에 담기 시작
		for (int i = N - 1; i >= 0; i--) {
			
			// 스택이 비어있으면 무조건 담는다.
			if (s.isEmpty())
				s.push(i);
			else {
				
				// 스택 맨 위의 높이가 현재 빌딩보다 낮다면 pop
				while (!s.isEmpty() && building[s.peek()] < building[i])
					s.pop();

				// 스택이 빌 때까지 pop했다면 현재부터 맨 뒤까지 모두 볼 수 있다는 뜻
				if (s.isEmpty())
					total += (N - i - 1);
				else	// 아니라면 현재부터 막힌 곳 전까지 볼 수 있다는 뜻
					total += (s.peek() - i - 1);

				s.push(i);
			}
		}

		System.out.println(total);
		br.close();
	}
}
