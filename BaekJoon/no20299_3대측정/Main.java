package BaekJoon.no20299_3대측정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, S, M; // 신청 동아리 수, 가입 능력치 합, 인 당 최소 능력치
	static StringBuilder sb; // 출력을 값들을 저장할 stringbuilder

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 키보드 입력
		sb = new StringBuilder(); // stringbuilder 초기화

		String input[] = br.readLine().split(" "); // 첫 줄을 공백 단위로 짤라서 input 배열에 저장
		N = Integer.parseInt(input[0]); // input[0] 신청한 동아리 수
		S = Integer.parseInt(input[1]); // input[1] 가입 능력치 합
		M = Integer.parseInt(input[2]); // input[2] 인 당 최소 능력치

		int cnt = 0;
		OUTER: for (int i = 0; i < N; i++) {
			int sum = 0; // 클럽의 능력치 합을 저장할 sum 변수를 새로운 클럽마다 0으로 초기화
			input = br.readLine().split(" "); // 클럽의 개인 능력치를 공백 단위로 짤라서 input 배열에 저장

			for (int j = 0; j < 3; j++) { // sum에 개인 능력치를 더하는데 클럽은 3인이 한팀이므로 3번
				if (Integer.parseInt(input[j]) < M) // 개인의 능력치가 기준보다 낮다면 OUTER로 이동
					continue OUTER;
				sum += Integer.parseInt(input[j]); // 높다면 sum에 더해준다.
			}

			if (sum < S) // 능력치의 합이 가입 최소 조건보다 낮으면 skip
				continue;
			else { // 높다면 합격이므로 cnt를 1 증가시키고 stringbuilder에 값 저장
				cnt++;
				for (int j = 0; j < 3; j++) {
					sb.append(input[j]).append(" ");
				}
			}
		}
		System.out.print(cnt + "\n" + sb.toString());
		br.close();
	}
}