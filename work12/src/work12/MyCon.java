package work12;

import java.sql.Connection;
import java.sql.SQLException;

public class MyCon {
	public static final int FREE=100;
	public static final int BUZY=101;
	public static final int CLOSED=102;
	private Connection con;
	private int state=FREE;
	public MyCon(Connection con) {
		this.con=con;
	}
	public Connection getCon()
	{
		return con;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state=state;
	}

	public void closeCon() throws SQLException {
		this.con.close();
	}
	
}
