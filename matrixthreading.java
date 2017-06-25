import java.net.*;
import java.io.*;

public class matrixthreading {

	/**
	 * @param args
	 */
	public final static int NUMTHREAD = 10;
	public static final int m = 3;
	public static final int k = 2;
	public static final int n = 3;
	static int[][] a = {{1,4},{2,5},{3,6}};
	static int[][] b = {{8,7,6},{5,4,3}};
	static int[][] c = new int[m][n];
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread[] workers = new Thread[NUMTHREAD];
		int t = 0;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
			   workers[t] = new Thread(new WorkerThread(i,j,a,b,c));
			 workers[t].start();
			 t++;
			}
		}
		
		for(int i=0;i<NUMTHREAD;i++){
			try{
				workers[i].join();
				
			}catch(InterruptedException e){}
		}
		
		for(int i=0;i<NUMTHREAD;i++){
			
		}
		
		
		
	}

}

 class WorkerThread implements Runnable
 {
	 private int row;
	 private int col;
	 private int[][] A;
	 private int[][] B;
	 private int[][] C;
	 
	 public WorkerThread(int row, int col, int[][] A,int[][] B, int[][] C){
		 this.row = row;
		 this.col = col;
		 this.A = A;
		 this.B = B;
		 this.C = C;
		 
	 }
	 
	 public void run(){
		 C[row][col] = 0;
		 for(int k=0;k<A[0].length;k++){
			 C[row][col] = C[row][col] + A[row][k]*B[k][col];
		 }
	 }
	 
 }

class Data{
	public  int i;
	public int j;
	
	
	Data(int i, int j){
		this.i = i;
		this.j = j;
	}
}