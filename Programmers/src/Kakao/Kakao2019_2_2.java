package Kakao;

import java.util.*;

public class Kakao2019_2_2 {
	static ArrayList<String> uniKey = new ArrayList<>();
	static ArrayList<String> cdKey = new ArrayList<>();
	static int n, m;
	static boolean[] visit;
	static String[][] rel;

	public static void main(String[] args) {
		String[][] relation = { {"a","1","aaa","c","ng"},
				{"a","1","bbb","e","g"},
				{"c","1","aaa","d","ng"},
				{"d","2","bbb","d","ng"}};

		System.out.println(solution(relation));
	}

	static int solution(String[][] relation) { 
		n = relation.length; // Ʃ�� ����
		m = relation[0].length; // ��Ʈ����Ʈ ����

		visit = new boolean[m];
		rel = relation;

		DFS(0, new StringBuilder());

		uniKey.sort((o1, o2) -> o1.length() == o2.length() ? 
				o1.compareTo(o2) : o1.length() - o2.length());

		// ���ϼ��� �����ϴ� Ű �� �ּҼ��� �����ϴ� Ű�� list�� �߰�
		for(int i=0;i<uniKey.size();i++)
			if(isMin(i))
				cdKey.add(uniKey.get(i));

		return cdKey.size();
	}

	static void DFS(int start, StringBuilder sb) {
		for(int i=start;i<m;i++) {
			if(!visit[i]) {
				visit[i] = true;
				sb.append(i);

				String tuple = sb.toString();
				// ���ϼ��� �����Ѵٸ� list�� �߰�
				if(isUnique(tuple))
					uniKey.add(tuple);

				if(i + 1 != m)
					DFS(i + 1, sb);
				visit[i] = false;
				sb.setLength(sb.length() - 1);
			}
		}
	}

	static boolean isMin(int idx) {
		String target = uniKey.get(idx);
		HashSet<Integer> set = new HashSet<>();
		
		for(char c : target.toCharArray())
			set.add(c - '0');

		// �˻��Ϸ��� Ű�� �ĺ�Ű�� �����Ѵٸ� ���ϼ��� �������� ����
		for(String s : cdKey) {
			int check = 0;
			for(char c : s.toCharArray()) {
				int i = c - '0';
				if(!set.contains(i))
					break;
				check++;
			}
			if(check == s.length())
				return false;
		}

		return true;
	}
	
	static boolean isUnique(String s) {
		// ���ڿ�, ���� ����
		HashMap<String, Integer> map = new HashMap<>();

		for(int i=0;i<n;i++) {
			StringBuilder sb = new StringBuilder();
			for(char c : s.toCharArray()) {
				sb.append(rel[i][c - '0']);
			}
			String tuple = sb.toString();
			map.put(tuple, map.getOrDefault(tuple, 0) + 1);
		}

		// ���� �� �̻��̶�� �������� ���� ��
		for(int i : map.values())
			if(i > 1) return false;

		return true;
	}

}
