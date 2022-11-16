package Kakao;

import java.util.HashMap;
import java.util.StringTokenizer;

public class Kakao2022_1 {

	public static void main(String[] args) {
		int[] result = solution(new String[] {"muzi", "frodo", "apeach", "neo"},
				new String[] {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2);
		
		for(int i : result)
			System.out.println(i);
	}
	
    static int[] solution(String[] id_list, String[] report, int k) {
        StringTokenizer st;
        int n = id_list.length;
        boolean[][] report_yn = new boolean[n][n]; // ����ں� �Ű� ����
        int[] report_cnt = new int[n]; // �Ű� Ƚ��
        int[] mail = new int[n]; // ���� ��
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0;i<n;i++)
            map.put(id_list[i], i); // �� ����� ���� �ε��� �ο�
        
        for(int i=0;i<report.length;i++) {
            st = new StringTokenizer(report[i]);
            // ������� �ε��� ã��
            int userIdx = map.get(st.nextToken()); 
            int reportIdx = map.get(st.nextToken());
            
            if(!report_yn[userIdx][reportIdx]) { // �̹� ���� �Ű� �� ��� ����
                report_yn[userIdx][reportIdx] = true;
                report_cnt[reportIdx]++;
            }
        }
        
        for(int i=0;i<n;i++) {
            if(report_cnt[i] >= k) {
                for(int j=0;j<n;j++) 
                    if(report_yn[j][i]) // j�� i�� �Ű��ߴٸ�
                        mail[j]++;
            }
        }
        
        return mail;
    }

}
