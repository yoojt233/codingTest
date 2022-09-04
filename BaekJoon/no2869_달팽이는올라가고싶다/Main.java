package BaekJoon.no2869_달팽이는올라가고싶다;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int up = Integer.parseInt(st.nextToken());
		int down = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());

		int ans = 1;
		if (up >= target)
			ans = 1;
		else if (up - down >= target - up)
			ans = 2;
		else {
			ans += (target - up) / (up - down);
			if ((target - up) % (up - down) != 0)
				ans++;
		}

		System.out.print(ans);
		br.close();
	}
}
