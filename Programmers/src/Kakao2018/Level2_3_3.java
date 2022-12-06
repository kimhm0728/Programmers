package Kakao2018;

import java.util.*;

public class Level2_3_3 {
	// 2018 KAKAO BLIND RECRUITMENT 3�� Level 2 �� ��° ���� ����

	static HashMap<String, Integer> dic = new HashMap<>();
	static ArrayList<Integer> list = new ArrayList<>();
	static int last = 26; // ������ ���� ��ȣ

	public static void main(String[] args) {
		for(int i : solution("KAKAO"))
			System.out.print(i + " ");
	}

	static int[] solution(String msg) {
		char c = 'A';

        // A~Z ������ �߰�
		for(int i=0;i<26;i++)
			dic.put(Character.toString((char)(c + i)), i + 1);

		compression(0, msg, msg.length());

		int size = list.size();
		int[] ans = new int[size];

		for(int i=0;i<size;i++)
			ans[i] = list.get(i);
        
		return ans;
	}

	static void compression(int idx, String msg, int n) {
		String w = ""; // ������ �����ϰ� ���� �Է°� ��ġ�ϴ� ���� �� ���ڿ�
		StringBuilder wc = new StringBuilder(); // w + �Է¿��� ó������ ���� ���� ���� (c)
		int i;

		for(i=idx;i<n;i++) {
			wc.append(msg.charAt(i));
			if(!dic.containsKey(wc.toString())) 
				break;
			else 
				w = wc.toString();
		}

		list.add(dic.get(w));
		if(!dic.containsKey(wc.toString()))
			dic.put(wc.toString(), ++last);

		if(i < n)
			compression(i, msg, n);
	}
	
}