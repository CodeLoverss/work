package work11;

import java.sql.*;

public class DataBaseTest {

	// MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc";//jdbc为数据库名称
 
    // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    //static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    //static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB?useSSL=false&serverTimezone=UTC";
 
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "root";
    
    public static void mysqlTest()
    {
    	Connection conn = null;
        Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
        
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql,sql2,sql3,sql4;
            sql="insert into test(id,username) values(1,'user1')";
            sql2="delete from test where id=1";
            sql3="update test set username='user2' where id=1";
            sql4 = "SELECT * FROM test";
            //增
            stmt.execute(sql);
            //删
            stmt.execute(sql2);
            //改
            stmt.execute(sql3);
            //查
            ResultSet rs = stmt.executeQuery(sql4);
        
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("id");
                String name = rs.getString("username");
    
                // 输出数据
                System.out.print("ID: " + id+"\t");
                System.out.print("用户名： " + name+"\t");
                System.out.print("\n");
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
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
			//增
			statement.execute("insert into test(id,username) values(1,'user1')");
			//删
			statement.execute("delete from test where id=1");
			//改
			statement.execute("update test set username='user2' where id=1");
			//查
			ResultSet re = statement.executeQuery("SELECT * name FROM test");//执行查询语句，接收结果集
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