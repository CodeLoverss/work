package work12;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub		
		long start,end;
		
		start=System.currentTimeMillis();
		for(int i=0;i<5000;i++)
		{
			Connection cons3=MySqlDAO.getConnection();
			//System.out.println(i);
			cons3.close();
		}
		end=System.currentTimeMillis();
		System.out.println("ֱ���������ݿ�5000�κ�ʱ "+(end-start)+"ms");
		
	
		start=System.currentTimeMillis();
		for(int i=0;i<5000;i++)
		{
			ConPool c=ConPool.getInstance();
			MyCon mycon=c.getCon();
			c.setFree(mycon);//�ͷ�	
		}
		end=System.currentTimeMillis();
		System.out.println("�������ݿ����ӳ��������ݿ�5000�κ�ʱ "+(end-start)+"ms");
		
		
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setDriverClass( "com.mysql.jdbc.Driver" ); //loads the jdbc driver            
		cpds.setJdbcUrl("jdbc:mysql://localhost:3306/jdbc");
		cpds.setUser("root");                                  
		cpds.setPassword("root");                                  		    
		cpds.setMinPoolSize(2);                                     
		cpds.setMaxPoolSize(10000);
		//cpds.setAcquireIncrement(5);
		start=System.currentTimeMillis();		
		// ֱ�Ӵ����ӳ��л�ȡ����
		for(int j=0;j<5000;j++)
		{
			Connection cons=cpds.getConnection();
			cons.close();
		}
		// �ر����ӳ�
		cpds.close();
		end=System.currentTimeMillis();
		System.out.println("c3p0���ݿ����ӳ��������ݿ�5000�κ�ʱ "+(end-start)+"ms");
							
	}

}
