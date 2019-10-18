package work11;

import java.sql.*;

public class DataBaseTest {

	// MySQL 8.0 ���°汾 - JDBC �����������ݿ� URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc";//jdbcΪ���ݿ�����
 
    // MySQL 8.0 ���ϰ汾 - JDBC �����������ݿ� URL
    //static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    //static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB?useSSL=false&serverTimezone=UTC";
 
    // ���ݿ���û��������룬��Ҫ�����Լ�������
    static final String USER = "root";
    static final String PASS = "root";
    
    public static void mysqlTest()
    {
    	Connection conn = null;
        Statement stmt = null;
        try{
            // ע�� JDBC ����
            Class.forName(JDBC_DRIVER);
        
            // ������
            System.out.println("�������ݿ�...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            System.out.println(" ʵ����Statement����...");
            stmt = conn.createStatement();
            String sql,sql2,sql3,sql4;
            sql="insert into test(id,username) values(1,'user1')";
            sql2="delete from test where id=1";
            sql3="update test set username='user2' where id=1";
            sql4 = "SELECT * FROM test";
            //��
            stmt.execute(sql);
            //ɾ
            stmt.execute(sql2);
            //��
            stmt.execute(sql3);
            //��
            ResultSet rs = stmt.executeQuery(sql4);
        
            // չ����������ݿ�
            while(rs.next()){
                // ͨ���ֶμ���
                int id  = rs.getInt("id");
                String name = rs.getString("username");
    
                // �������
                System.out.print("ID: " + id+"\t");
                System.out.print("�û����� " + name+"\t");
                System.out.print("\n");
            }
            // ��ɺ�ر�
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // ���� JDBC ����
            se.printStackTrace();
        }catch(Exception e){
            // ���� Class.forName ����
            e.printStackTrace();
        }finally{
            // �ر���Դ
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// ʲô������
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
 
    public static void sqlserverTest()
    {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://ip:1433;database=jdbc";
			String user = "root";
			String password = "root";
			Connection con = DriverManager.getConnection(url, user, password);
			
			Statement statement = con.createStatement();
			//��
			statement.execute("insert into test(id,username) values(1,'user1')");
			//ɾ
			statement.execute("delete from test where id=1");
			//��
			statement.execute("update test set username='user2' where id=1");
			//��
			ResultSet re = statement.executeQuery("SELECT * name FROM test");//ִ�в�ѯ��䣬���ս����
			while (re.next()) {
				System.out.println(re.getString("username"));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    public static void main(String[] args) {
        mysqlTest();
        sqlserverTest();
    }
}