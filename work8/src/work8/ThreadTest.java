package work8;

import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {
	static int a[][];
	static int result[][];
	static long runTime=0;
	static int flags=0;
	
	public static void singleThread(int size)
	{	
		int temp=0;
		int m=0,n=0;
		long startTime=System.currentTimeMillis();
		for(int row=0;row<size;row++)
		{
			for(int j=0;j<size;j++)
			{
				for(int i=0;i<size;i++)
				{
					temp+=a[row][m]*a[n][j];
					m++;
					n++;
				}
				result[row][j]=temp;
				m=0;
				n=0;
				temp=0;
			}
		}
		long endTime=System.currentTimeMillis();
		runTime=endTime-startTime;
	}
	
	public static void doubleThread(int size)
	{
		long startTime=System.currentTimeMillis();
		Thread t[]=new Thread[size];
		for(int row=0;row<size;row++)
		{
			subThread s=new subThread(row,size);
			t[row]=new Thread(s);
			t[row].setName(String.valueOf(row));
			t[row].start();
		}
		long endTime=0;
		while(Thread.activeCount()>1)
		{
			//System.out.print(result[size-1][size-1]);
			endTime=System.currentTimeMillis();
		}
		runTime=endTime-startTime;
	}
	
	public static void poolThread(int size)
	{
		
		long startTime=System.currentTimeMillis();
		ExecutorService pool = Executors.newFixedThreadPool(1000);
		for(int row=0;row<size;row++)
		{
			pool.execute(new subThread(row,size));
		}
		//pool.shutdown();
		long endTime=0;
		
		while(true)
		{
			if(flags==size) {
			//System.out.println("flags is "+flags);
			endTime=System.currentTimeMillis();
			break;
			}
		}
		pool.shutdown();
		runTime=endTime-startTime;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("请输入矩阵大小（行列相等）：");
		Scanner input=new Scanner(System.in);
		int size=input.nextInt();
		a=new int[size][size];
		result=new int[size][size];
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				a[i][j]=2;
				result[i][j]=0;
			}
		}
		//矩阵a*a
		//单线程
		singleThread(size);
		
		/*
		 * for(int i=0;i<size;i++) { for(int j=0;j<size;j++) {
		 * System.out.print(result[i][j]+"  "); } System.out.println(""); }
		 */
		System.out.println("singleThread running time is："+runTime+"ms");
		//多线程
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				result[i][j]=0;
			}
		}
		doubleThread(size);
		
		/*
		 * for(int i=0;i<size;i++) { for(int j=0;j<size;j++) {
		 * System.out.print(result[i][j]+"  "); } System.out.println("");
		 }*/ 
		 
		System.out.println("doubleThread running time is："+runTime+"ms");
		//线程池
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				result[i][j]=0;
			}
		}
		flags=0;
		poolThread(size);
		while(true) {
			//System.out.print("flags= "+flags);
			if(flags==size) {
				
				/*
				 * for(int i=0;i<size;i++) { for(int j=0;j<size;j++) {
				 * System.out.print(result[i][j]+"  "); } System.out.println(""); }
				 */
				 
			 
			//System.out.print(result[0][0]+" "+result[size-1][size-1]+" "+result[size/2][size/2]);
			System.out.println("poolThread running time is："+runTime+"ms");
			break;
			}
		}  
	}
}

class subThread implements Runnable{
	int row,size;
	int a[][]=ThreadTest.a;
	public subThread(int row,int size)
	{
		this.row=row;
		this.size=size;
		ThreadTest.flags++;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//System.out.println("线程 "+Thread.currentThread().getName()+" 已启动");
		int temp=0,m=0,n=0;
		for(int j=0;j<size;j++)
		{
			for(int i=0;i<size;i++)
			{
				temp+=a[row][m]*a[n][j];
				m++;
				n++;
			}
			ThreadTest.result[row][j]=temp;
			//System.out.print("temp="+temp+" ");
			m=0;
			n=0;
			temp=0;
		}
		//System.out.println(Thread.currentThread().getName()+"执行完毕");
		//System.out.println("现在flags是 "+ThreadTest.flags);
	}
}
