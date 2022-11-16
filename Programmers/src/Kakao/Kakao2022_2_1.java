package Kakao;

import java.util.StringTokenizer;

public class Kakao2022_2_1 {

	public static void main(String[] args) {
		System.out.println(solution(437674, 3));
	}
	
    static int solution(int n, int k) {
        String str = Integer.toString(n, k);
        
        StringTokenizer st = new StringTokenizer(str, "0");
        
        int cnt = 0;
        
        while(st.hasMoreTokens()) {
            if(isPrime(Long.parseLong(st.nextToken())))
                cnt++;
        }
        
        return cnt;
    }
    
    static boolean isPrime(long n) {
        if(n == 0 || n == 1)
            return false;
        
        if(n == 2)
            return true;

        for(long i=2;i<=Math.sqrt(n);i++)
            if(n % i == 0)
                return false;
        
        return true;
    }

}
