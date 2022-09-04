package BaekJoon.no14713_앵무새;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 가능 여부 판단
		boolean flag = true;

		// 앵무새 수
		N = Integer.parseInt(br.readLine());

		// 문장들을 담을 큐
		Queue<String>[] lines = new LinkedList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			lines[i] = new LinkedList<String>();

			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens())
				lines[i].offer(st.nextToken());
		}

		OUT: while (!lines[N].isEmpty() && !linesEmpty(lines)) {
			String cur = lines[N].poll();

			// 순서가 맞다면 continue
			for (int i = 0; i < N; i++) {
				if (!lines[i].isEmpty() && lines[i].peek().equals(cur)) {
					lines[i].poll();
					continue OUT;
				}
			}

			// 순서가 안맞다면 break
			flag = false;
			break;
		}

		if(!lines[N].isEmpty() || !linesEmpty(lines))
			flag = false;
		
		if (flag)
			System.out.print("Possible");
		else
			System.out.print("Impossible");

		br.close();
	}

	private static boolean linesEmpty(Queue<String>[] lines) {
		for (int i = 0; i < N; i++) {
			if (!lines[i].isEmpty())
				return false;
		}
		return true;
	}
}
