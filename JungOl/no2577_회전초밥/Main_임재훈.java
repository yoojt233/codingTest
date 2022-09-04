package JungOl.no2577_회전초밥;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_임재훈 {
	static int N, D, K, C;
	static int sushi[], kind[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		N = Integer.parseInt(line[0]);
		D = Integer.parseInt(line[1]);
		K = Integer.parseInt(line[2]);
		C = Integer.parseInt(line[3]);
		sushi = new int[N];
		kind = new int[D + 1];
		kind[C] = 1;
		int temp = 1;
		
		for (int i = 0; i < N; ++i)
			sushi[i] = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < K; ++i) {
			if (kind[sushi[i]]++ == 0)
				temp++;
		}
		
		int answer = temp;
		for (int i = K; i < N + K; ++i) {
			int head = sushi[(i - K) % N];
			int tail = sushi[i % N];
			if (--kind[head] == 0)
				temp--;
			if (kind[tail]++ == 0)
				temp++;
//			answer = answer > temp ? answer : temp;
			answer = Math.max(answer, temp);
			if (answer == D)
				break;
		}
		System.out.println(answer);
	}
}
