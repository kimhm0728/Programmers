package Kakao;

public class Kakao2017_2_1 {
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int cnt;
    static int max;
    static int width;
    static boolean[][] visit;
    static int[][] pictures;
    static int M, N;
    
	public static void main(String[] args) {
		int[][] picture = {{1, 1, 1, 0}, 
				{1, 2, 2, 0}, 
				{1, 0, 0, 1}, 
				{0, 0, 0, 1}, 
				{0, 0, 0, 3}, 
				{0, 0, 0, 3}};
		
		int[] result = solution(6, 4, picture);
		System.out.println(result[0] + " " + result[1]);
	}
	
    static int[] solution(int m, int n, int[][] picture) {
        cnt = 0; max = 0;
        M = m; N = n; pictures = picture;
        visit = new boolean[m][n];

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(picture[i][j] != 0 && !visit[i][j]) { // ��ĥ�Ǿ� �ְ� ���� �湮���� ���� ���̸� ���ο� ������ �ǹ�
                    width = 0;
                    visit[i][j] = true; 
                    DFS(i, j, picture[i][j]); // ��ĥ�� ��ġ�� ������ DFS
                    max = Math.max(width, max); // DFS�� Ž���� ������ ���̸� max�� ���� ����
                    cnt++; // ������ ���� ���ϱ�
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = cnt;
        answer[1] = max;
        return answer;
    }
    
    static void DFS(int x, int y, int value) {
        width++; // DFS�� ������ ������ ���� 1�� ����
        
        for(int i=0;i<4;i++) {
            // �����¿�� Ž��
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            
            // Ž���Ϸ��� ��ġ�� ���� ���� �����ϰ� �湮���� �ʾ�����, ���� ������ ���� ���� ������ ��ĥ�Ǿ� �ִٸ�
            if(isNext(nextX, nextY) && !visit[nextX][nextY] && pictures[nextX][nextY] == value) {
                visit[nextX][nextY] = true;
                DFS(nextX, nextY, value); 
            }
        }
    }
    
    // Ž���Ϸ��� ���� picture �迭 ���� �ִ��� Ȯ��
    static boolean isNext(int x, int y) {
        if(x < M && x >= 0 && y < N && y >= 0)
            return true;
        return false;
    }

}
