package Kakao;

import java.util.*;

public class Kakao2021_3_3 {
	static ArrayList<Point> list[] = new ArrayList[7];
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		int[][] board = {{1, 0, 0, 3},
				{2, 0, 0, 0},
				{0, 0, 0, 2},
				{3, 0, 1, 0}};
		
		System.out.println(solution(board, 1, 0));
	}
	
    static int solution(int[][] board, int r, int c) {
    	for(int i=1;i<7;i++)
    		list[i] = new ArrayList<>();
    	
    	int n = board.length;
    	int m = board[0].length;
    	
    	// hashmap�� ���. key�� ī���ȣ, value�� ī�� ��ġ �ΰ�.
    	for(int i=0;i<n;i++)
    		for(int j=0;j<m;j++)
    			if(board[i][j] != 0)
    				list[board[i][j]].add(new Point(i, j, 0));
    	
    	DFS(0);

    	return min;
    }
    
	static void DFS(int depth) {
		
		// ī�尹����ŭ �迭�� ������� bfs�� �ּڰ� ã��
		// if(depth == ī�尹��) Math.min(bfs, min)
		
		for(int i=1;i<7;i++) {
			//int dis = BFS();
			//int reverse = BFS();
			
			// �迭���� ��ġ ���
			// 0���� ����, 1���� ��
			// 0���� ��, 1���� ���� �̷� ������ dfs �ι� ����. visit �߰�.
		}
		
	}
	
	static void BFS() {
		// ť�� ������ �ֱ�. ���������� ī�� �ϳ��ϳ� 
		// ctrl���� (�ִ� 2���� ����), ctrl���� �ϳ��� ���� �� �Ѵ� q�� �ֱ�
	}
	
	static class Point {
		int row, col, cnt;
		
		Point(int row, int col, int cnt) {
			this.row = row;
			this.col = col;
			this.cnt = cnt;
		}
	}

}
