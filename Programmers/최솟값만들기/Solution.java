package Programmers.최솟값만들기;

import java.util.Arrays;

public class Solution {
	public int solution(int []A, int []B)
    {
        int size = A.length;
        Arrays.sort(A);
        Arrays.sort(B);
        
        int ans = 0;
        for(int i=0; i<size; ++i)
            ans += (A[i] * B[size - i - 1]);

        return ans;
    }
}
