package Kakao;

import java.util.*;

public class Kakao2020_3_3 {
	static int num;
	static int min = -1;
	static boolean[] arr;
	static int N;

	public static void main(String[] args) {
		System.out.println(solution(30, new int[] {0, 3, 11, 21}, new int[] {10, 4}));
	}

	static int solution(int n, int[] weak, int[] dist) {
		N = n;
		num = weak.length; // ��� ���� ����
		arr = new boolean[n];

		for(int i=0;i<weak.length;i++)
			arr[weak[i]] = true;

		// �������� ����
		Arrays.sort(dist);

		// dist.length - 1 ���� 0���� �ݴ�� DFS�� ������ (�� �� �ִ� �Ÿ��� ū �������)
		DFS(dist.length - 1, 0, 1, weak, dist);
		return min;
	}

	// ���� �ε���, ���� �Ϸ� ����, ���� ģ�� ��
	static void DFS(int start, int cnt, int f, int[] weak, int[] dist) {
		if(cnt == num) {
			f--;
			min = min == -1 ? f : Math.min(f, min);
			return;
		}

		ArrayList<Integer> back = new ArrayList<>();
		
		if(start < 0)
			return;
		
		for(int i=0;i<num;i++) {
			if(!arr[weak[i]])
				continue;
			else {
				back.add(weak[i]);
				arr[weak[i]] = false;
				cnt++;
			}
			int dis = dist[start]; // ģ���� �̵��� �� �ִ� �Ÿ�
			int temp = 1; // cnt�� �ǵ����� ���� cnt�� �󸶳� �����ߴ��� ����
			int idx = i;
			while(dis > 0 && cnt < num) { // ģ���� �̵��� �� ���� ������
				if(!arr[weak[(idx + 1) % num]]) 
					break;
				
				int disDiff = weak[(idx + 1) % num] - weak[idx];
				if(disDiff < 0)
					disDiff += N;

				dis -= disDiff;

				if(dis >= 0) {
					temp++;
					cnt++;
					
					idx = (idx + 1) % num;
					back.add(weak[idx]);
					arr[weak[idx]] = false;
				}
			}

			DFS(start - 1, cnt, f + 1, weak, dist);
			cnt -= temp;
			for(int b : back) {
				arr[b] = true;
			}
			back.clear();
		}
	}

}
