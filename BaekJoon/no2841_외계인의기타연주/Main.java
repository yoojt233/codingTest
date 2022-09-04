package BaekJoon.no2841_외계인의기타연주;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int cnt = 0; // 손가락 몇 번 움직여?

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		Stack<Integer>[] line = new Stack[7]; // 각 줄마다 stack 생성. 0번째 index 사용 안 함
		for (int i = 1; i < 7; i++)
			line[i] = new Stack<Integer>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()); // 줄
			int fret = Integer.parseInt(st.nextToken()); // 프렛

			press(line[num], fret); // 줄의 stack에서 fret 비교
		}

		System.out.print(cnt);
		br.close();
	}

	private static void press(Stack<Integer> s, int fret) {

		// stack이 비었거나, 가장 위의 값이 누를 fret보다 작으면 push
		if (s.isEmpty() || s.peek() < fret) {
			s.push(fret);
			cnt++;
		} else if (s.peek() > fret) {

			// stack의 size 만큼 돌며 pop(손가락 떼기) 하며 cnt 증가. 만약 가장 위의 값이 fret보다 작거나 같아지면 break
			for (int i = 0; i < s.size(); i++) {
				if (s.peek() <= fret)
					break;
				s.pop();
				cnt++;
			}

			// 손가락 뗐으면 주어진 fret 눌러야지?
			press(s, fret);
		}
	}
}