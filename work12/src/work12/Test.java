package work12;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub		
		long start,end;
		
		List<Connection> cons3=new ArrayList<Connection>();
		start=System.currentTimeMillis();
		for(int i=0;i<5000;i++)
		{
			cons3.add(MySqlDAO.getConnection());
			//System.out.println(i);
		}
		for(Connection m:cons3)
		{
			m.close();
		}
		end=System.currentTimeMillis();
		System.out.println("ֱ���������ݿ�5000�κ�ʱ "+(end-start)+"ms");
		
		
		List<MyCon> myCons=new ArrayList<MyCon>();
		start=System.currentTimeMillis();
		MyCon con=null;
		for(int i=0;i<5000;i++)
		{
			myCons.add(ConPool.getInstance().getCon() );
			//System.out.println(i);
		}
		for(MyCon m:myCons)
		{
			m.closeCon();
		}
		end=System.currentTimeMillis();
		System.out.println("�������ݿ����ӳ��������ݿ�5000�κ�ʱ "+(end-start)+"ms");
		
		/*
		List<Connection> cons=new ArrayList<Connection>();
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
			cons.add(cpds.getConnection());
		}
		// �ر����ӳ�
		cpds.close();
		end=System.currentTimeMillis();
		System.out.println("c3p0���ݿ����ӳ��������ݿ�5000�κ�ʱ "+(end-start)+"ms");
		*/					
	}

}
