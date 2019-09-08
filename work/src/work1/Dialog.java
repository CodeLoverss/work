package work1;

public class Dialog {

	public static void DoDataExchange(/*CDataExchange* pDX*/)
	{
		
		/*
		 * CDialogEx::DoDataExchange(pDX); DDX_Control(pDX, IDC_COMBO1, list);
		 * list.SetCurSel(0);
		 * 
		 * DDX_Control(pDX, IDC_LIST1, Bordertype); DDX_LBString(pDX, IDC_LIST1,
		 * Bordertype1);
		 * 
		 * Bordertype.AddString("PS_SOLID");//在此处初始化列表框控件
		 * Bordertype.AddString("PS_DASH"); Bordertype.AddString("PS_DOT");
		 * Bordertype.AddString("PS_DASHDOT"); Bordertype.AddString("PS_DASHDOTDOT");
		 * Bordertype.AddString("PS_NULL"); Bordertype.AddString("PS_INSIDEFRAME");
		 * DDX_Control(pDX, IDC_MFCCOLORBUTTON1, b_Color); DDX_Control(pDX, IDC_LIST2,
		 * FillStyle); DDX_Control(pDX, IDC_MFCCOLORBUTTON2, c_color);
		 * FillStyle.AddString("HS_BDIAGONAL"); FillStyle.AddString("HS_CROSS");
		 * FillStyle.AddString("HS_DIAGCROSS"); FillStyle.AddString("HS_FDIAGONL");
		 * FillStyle.AddString("HS_HORIZONTAL"); FillStyle.AddString("HS_VERTICAL");
		 * FillStyle.AddString("HS_NULL"); DDX_Control(pDX, IDC_EDIT7, Edit);
		 * Change(temp);
		 */
		
	}
	
	//更新数据
	public static void UpdateData(/*int temp*/)
	{
		/*temp_ElementType = temp;
		temp_W = GetDlgItemInt(IDC_EDIT3);
		temp_H = GetDlgItemInt(IDC_EDIT4);
		temp_BorderWidth = GetDlgItemInt(IDC_EDIT6);
		temp_BorderType = Bordertype.GetCurSel();
		temp_color = (COLORREF)b_Color.GetColor();  
		temp_FillType = FillStyle.GetCurSel();
		temp_FillColor = (COLORREF)c_color.GetColor();*/
	}

	//提示信息更改
	public static void Change(/*int temp*/)
	{
		/*
		 * if (temp == 1) { SetDlgItemText(IDC_EDIT7, "注意： 您正在修改图元属性！"); } else
		 * if(temp==0) { SetDlgItemText(IDC_EDIT7, "注意： 您正在新建图元！"); }
		 * 
		 */
	}
	
	//BOOL del=FALSE;
	public static void OnBnClickedOk()
	{
		// TODO: 在此添加控件通知处理程序代码
		/*
		 * CString str; int nindex = list.GetCurSel(); list.GetLBText(nindex, str);
		 * 
		 * if (str == "Square") { Give(1); } else if (str == "Rectangle") { Give(2); }
		 * else if (str == "Circle") { Give(3); } else if (str == "Ellipse") { Give(4);
		 * } else if (str == "Triangle") { Give(5); } else if (str == "Text") { Give(6);
		 * GetDlgItemText(IDC_EDIT5,temp_str); } //AfxMessageBox("参数设置成功"); del = TRUE;
		 * CDialogEx::OnOK();
		 */
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("dialog");
	}

}
