package BaekJoon.no16926_배열돌리기1;

import java.io.FileInputStream;
import java.util.Scanner;


public class Main_B_16926_배열돌리기2 {
    static int R, C,CNT;
    static int[][] Arr ;
    
    static int[] dx= {0,1,0,-1};
    static int[] dy= {1,0,-1,0};//반시계방향 우 상 좌 하   > - ^ -  < -  v
     // 좌 상 우 하
    /*
	반시계 방향
	static int[] dx= {0,1,0,-1};
    static int[] dy= {1,0,-1,0};//반시계방향 우 상 좌 하   > - ^ -  < -  v
   
    //시계방향
    static int[] dx= {0,1,0,-1};
    static int[] dy= {-1,0,1,0};//
    
 */
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input/16926.txt"));

		Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        CNT = sc.nextInt();
        
        Arr = new int[R][C];
        
        for(int i=0;i<R;i++) {
        	for(int j=0;j<C;j++) {
        		Arr[i][j] = sc.nextInt();
        	}
        }
        
      
        // 돌려야 하는 그룹 갯수 
        // 2*2 => 1개 , 5*5 => 2개 
        //이규칙에서 항상 시작점은 x,y가 같은 값에서 시작 
        int g = Math.min(R, C) / 2;
        
        //회전 횟수
        for(int i=0;i<CNT;i++) {
        	//그룹 갯수
            for(int j=0;j<g;j++) {
            	int x = j;  //이규칙에서 항상 시작점은 x,y가 같은 값에서 시작 
            	int y = j;
            	
            	int value = Arr[x][y]; //나중에 넣기 위해 저장 
            	
            	int idx = 0 ;//방향
            	
            	while(idx < 4) {
            		int nx = x + dx[idx];
            		int ny = y + dy[idx];
            		
            		//범위 내에 있을 경우 회전 
            		if(nx>=j && ny>=j&&nx<R-j&&ny<C-j) {
            			Arr[x][y] = Arr[nx][ny];
            			x=nx;
            			y=ny;
            		}
            		else idx++; //범위 벗어나면 방향 전환 
            	}
            	Arr[j+1][j] = value;
            }
        	
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<R;i++) {
        	for(int j=0;j<C;j++) {
        		sb.append(Arr[i][j]+" ");
        	}
        	sb.append("\n");
        }
        System.out.println(sb.toString());
    }
	
}

