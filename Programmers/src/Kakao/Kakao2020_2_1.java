package Kakao;

public class Kakao2020_2_1 {

	public static void main(String[] args) {
		System.out.println(solution("ababcdcdababcdcd"));
	}

	static int solution(String s) {
		int len = s.length();
		int ans = s.length();

		// 1���� ���ڿ��� ������ �ݱ����� ������ �߶� ����
		for(int i=1;i<=s.length() / 2;i++) {
			StringBuilder sb = new StringBuilder();
			String delim = s.substring(0, i);
			
			int cnt = 1; // ���� ���� Ƚ��
			int start = i; // substring ���� �ε���
			while(start < len) {
				if(s.substring(start, len).startsWith(delim)) {
					cnt++;
				}
				else { 
					if(cnt == 1) sb.append(delim);
					else sb.append(delim).append(cnt);
					cnt = 1;
					delim = start + i < len ? s.substring(start, start + i) : s.substring(start, len);
				}
				start += i;
			}
			if(cnt == 1) sb.append(delim);
			else sb.append(delim).append(cnt);
			ans = Math.min(ans, sb.toString().length());
		}
		return ans;
	}

}
