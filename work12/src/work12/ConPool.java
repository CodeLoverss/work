package work12;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ConPool {
	private List<MyCon> freeCons=new ArrayList<MyCon> ();
	private List<MyCon> buzyCons=new ArrayList<MyCon> ();
	private int max=50000;
	private int min=100;
	private int current=0;
	private static ConPool instance;
	
	private ConPool() {
		while(this.min>this.current)
		{
			this.freeCons.add(this.createCon());
		}
	}
	
	public static ConPool getInstance()
	{
		if(instance==null) instance=new ConPool();
		return instance;
	}
	public MyCon getCon() {
		MyCon myCon=this.getFreeCon();
		if(myCon!=null)
		{
			return myCon;
		}
		else {
			return this.getNewCon();
		}
	}
	private MyCon getFreeCon() {
		if(freeCons.size()>0) {
			MyCon con=freeCons.remove(0);
			con.setState(MyCon.BUZY);
			this.buzyCons.add(con);
			return con;
		}
		else {return null;}
	}
	private MyCon getNewCon() {
		if(this.current<this.max) {
			MyCon myCon=this.createCon();
			myCon.setState(MyCon.BUZY);
			this.buzyCons.add(myCon);
			return myCon;
		}
		else {return null;}
	}
	private MyCon createCon() {
		try {
			Connection con=MySqlDAO.getConnection();
			MyCon myCon=new MyCon(con);
			this.current++;
			return myCon;
		}catch(Exception e){}
		return null;
	}
	public void setFree(MyCon con) {
		this.buzyCons.remove(con);
		con.setState(MyCon.FREE);
		this.freeCons.add(con);
	}
	
}
