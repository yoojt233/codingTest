package BaekJoon.no1058_친구;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int max = 0; // 가장 유명한 사람의 2-친구 수

		// 입력
		char[][] map = new char[N][N];
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < N; j++)
				map[i][j] = temp.charAt(j);
		}

		for (int i = 0; i < N; i++) {
			HashSet<Integer> friend = new HashSet<>();

			for (int j = 0; j < N; j++) {

				// 둘이 친구라면
				if (map[i][j] == 'Y') {
					friend.add(j);

					// j의 친구들도 2-친구에 포함
					for (int k = 0; k < N; k++) {
						if (map[j][k] == 'Y')
							friend.add(k);
					}
				}
			}

			int size = friend.size();

			// 자기자신이 포함되어 있을 수도 있다.
			if (friend.contains(i))
				size -= 1;

			// 최댓값 갱신
			max = Integer.max(size, max);
		}

		System.out.print(max);
		br.close();
	}
}
