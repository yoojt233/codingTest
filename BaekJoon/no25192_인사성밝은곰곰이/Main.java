package BaekJoon.no25192_인사성밝은곰곰이;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String str;
		Set<String> id = new HashSet<>();

		int ans = 0;
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			if (str.equals("ENTER"))
				id.clear();
			else {
				if (!id.contains(str)) {
					id.add(str);
					ans++;
				}
			}
		}

		System.out.print(ans);
		br.close();
	}
}