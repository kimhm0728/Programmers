package Kakao;

import java.util.*;

public class Kakao2021_3_3 {
	static HashMap<Integer, int[][]> map = new HashMap<>();
	static int min = Integer.MAX_VALUE;
	static int n = 0;
	static int card[][];
	static boolean visit[];
	static int R, C;
	
	public static void main(String[] args) {
		int[][] board = {{1, 0, 0, 3},
				{2, 0, 0, 0},
				{0, 0, 0, 2},
				{3, 0, 1, 0}};
		
		System.out.println(solution(board, 1, 0));
	}
	
    static int solution(int[][] board, int r, int c) {
    	R = r; C = c;
    	
    	// key�� ī�� ��ȣ, value�� ī�� ��ġ �ΰ�.
    	for(int i=0;i<board.length;i++)
    		for(int j=0;j<board[0].length;j++) 
    			if(board[i][j] != 0) {
    				if(!map.containsKey(board[i][j])) {
    					int[][] temp = new int[2][2];
    					temp[0][0] = i; temp[0][1] = j;
    					map.put(board[i][j], temp);
    					n++;
    				}
    				else {
    					int[][] temp = map.get(board[i][j]);
    					temp[1][0] = i; temp[1][1] = j;
    				}
    			}
    	
    	// ī�尡 3������ �� ī���ȣ�� 1,2,3 ���� 1,4,5ó�� ���������� �������ִ���. �ϴ� ���ڷ� ����.
    	card = new int[n * 2][2];
    	visit = new boolean[n + 1];
    	
    	DFS(0);

    	return min;
    }
    
	static void DFS(int depth) {
		// ī�尹����ŭ �迭�� ������� BFS�� �ּڰ� ã��
		if(depth == n) { 
			min = Math.min(BFS(), min);
			return;
		}
		
		for(int i=1;i<=n;i++) {
			if(!visit[i] && map.containsKey(i)) {
				visit[i] = true;
				int pos[][] = map.get(i);
				int idx = (i - 1) * 2;
				card[idx] = pos[0]; card[idx + 1] = pos[1];
				DFS(depth + 1);
				
				// ���� ��ȣ�� ī�� �̴� ���� �ݴ��
				card[idx] = pos[1]; card[idx + 1] = pos[0];
				DFS(depth + 1);
				visit[i] = false;
			}
		}
		
	}
	
	static int BFS() {
		Queue<Point> q = new LinkedList<>();
		
		q.add(new Point(R, C, 0));
		
		// start ���� card�� ���ұ���
		for(int i=0;i<card.length;i++) {
			while(!q.isEmpty()) {
				// ť�� ������ �ֱ�. ���������� ī�� �ϳ��ϳ� 
				// ctrl���� (�ִ� 2���� ����), ctrl���� �ϳ��� ���� �� �Ѵ� q�� �ֱ�
			}
		}
		
		return 0;
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
