package work1;

public class View {
	
	//
	public static void ThreadFunc()
	{
		/*
	
		CBrush *newbrush = new CBrush(), *oldbrush;
		newbrush->CreateSolidBrush(RGB(114,197,227));
		oldbrush=(CBrush *)pDC->SelectObject(newbrush);
		pDC->Rectangle(0,0,1500,700);
		pDC->SelectObject(oldbrush);

		CPen *oldpen = new CPen();
		//CClientDC *pDC = new CClientDC(this);
		int r = 300;
		
		CPoint point[] = {
			CPoint(680,25),
			CPoint(point[0].x - r * sin(PI / 5),r + point[0].y + r * cos(PI / 5)),
			CPoint(point[0].x + r * cos(PI / 10),r + point[0].y - r * sin(PI / 10)),
			CPoint(point[0].x - r * cos(PI / 10),r + point[0].y - r * sin(PI / 10)),
			CPoint(point[0].x + r * sin(PI / 5),r + point[0].y + r * cos(PI / 5))
			};
		pDC->Ellipse(380, 25, 980, 625);
		pDC->Polygon(point, 5);
		
		
		float kit = 0, y = 0;
		pDC->MoveTo(680, 25);
		for (int i = 0, c = 0, x = 680; i < 5; i++, c++)
		{
			kit = (float)(point[i].y - point[i + 1].y) / (float)(point[i].x - point[i + 1].x);//若不进行类型转换，则kit==0；
			if (i == 0)
			{
				for (int j = 680, k = 0; j>503; j-=2, k += 1)
				{
					CPen *newpen = new CPen(PS_SOLID, 5, RGB(255 - k, k, k + 10));
					pDC->SelectObject(newpen);
					pDC->LineTo(j, kit*j + point[i].y - kit * point[i].x + 3);
					delete newpen;
					Sleep(1);
				}
			}
			if (i == 1)
			{
				for (int j = 503, k = 0; j<965; j+=2, k += 1)
				{

					CPen *newpen = new CPen(PS_SOLID, 5, RGB(255 - k, k, k + 10));
					pDC->SelectObject(newpen);
					pDC->LineTo(j, (kit*j + 232 - kit * 965 + 3));
					delete newpen;
					Sleep(1);
				}
			}
			if (i == 2)
			{
				for (int j = 965, k = 0; j>394; j-=2, k += 1)
				{

					CPen *newpen = new CPen(PS_SOLID, 5, RGB(255 - k, k, k + 10));
					pDC->SelectObject(newpen);
					pDC->LineTo(j, (kit*j + 232 - kit * 394 + 3));
					delete newpen;
					Sleep(1);
				}
			}
			if (i == 3)
			{
				for (int j = 394, k = 0; j<856; j+=2, k += 1)
				{

					CPen *newpen = new CPen(PS_SOLID, 5, RGB(255 - k, k, k + 10));
					pDC->SelectObject(newpen);
					pDC->LineTo(j, (kit*j + 567 - kit * 856 + 3));
					delete newpen;
					Sleep(1);
				}
			}
			if (i == 4)
			{
				kit = (float)(point[0].y - point[4].y) / (float)(point[0].x - point[4].x);
				for (int j = 856, k = 0; j >680; j-=2, k += 1)
				{

					CPen *newpen = new CPen(PS_SOLID, 5, RGB(255 - k, k, k + 10));
					pDC->SelectObject(newpen);
					pDC->LineTo(j, (kit*j + 50 - kit * 680 - 20));
					delete newpen;
					Sleep(1);
				}
			}
		}
		//CClientDC *pDC = new CClientDC(this);
		pDC->SelectObject(oldpen);
		pDC->SetTextColor(RGB(255, 0, 0));
		pDC->TextOut(540, 415, "右键双击任意位置消除我");
		CFont *newfont = new CFont(), *oldfont;
		newfont->CreateFont(100, 40, 0, 0, 25, FALSE, FALSE, 0, ANSI_CHARSET, OUT_DEFAULT_PRECIS, CLIP_DEFAULT_PRECIS, DEFAULT_QUALITY, DEFAULT_PITCH&FF_SWISS, "Courier");
		oldfont = (CFont *)pDC->SelectObject(newfont);
		pDC->SetTextColor(RGB(36, 90, 205));
		pDC->TextOut(450, 160, "Welcom to");
		pDC->TextOut(200, 310, "this Drawing program!");
		pDC->SelectObject(oldfont);
		*/
	}
	
	public static void OnDraw(/*CDC* pDC*/)
	{
		/*
		Ctext3Doc* pDoc = GetDocument();
		ASSERT_VALID(pDoc);
		if (!pDoc)
			return;
		// TODO: 在此处为本机数据添加绘制代码
		/*
		CBitmap bitmap;	
		bitmap.LoadBitmap(IDB_BITMAP1);
		CDC dcComp;			//创建CDC对象   
		dcComp.CreateCompatibleDC(pDC);		//创建设备环境   
		dcComp.SelectObject(&bitmap);			//选择位图对象   
		BITMAP bmInfo;    bitmap.GetObject(sizeof(bmInfo),&bmInfo);	//获取位图信息   //将位图显示到视图中   
		pDC->BitBlt(0,0,bmInfo.bmWidth,bmInfo.bmHeight, &dcComp, 0,0,SRCCOPY);
		
		if (YN)	Paint();
		int n = obj.objects.GetCount();

		for (int i = 0; i < obj.objects.GetCount(); i++)
		{
			CShape *p = (CShape *)obj.objects[i];//虚函数，，，多态性
			p->Draw(pDC);
		}
		*/
	}

	public static void OnLButtonDown(/*UINT nFlag, CPoint point*/)
	{
		/*
		CClientDC *dc=new CClientDC(this);
		if((nFlag&MK_CONTROL)==MK_CONTROL)//ctrl键按下
		{
			if(temp_ElementType==1)
			{
			CSquare *square = new CSquare();
			square->SetValue(temp_ElementType, temp_W, temp_H, point, temp_BorderWidth,temp_BorderType,temp_color,temp_FillType,temp_FillColor, temp_str);
			square->Draw(dc);//ctrl+点击后绘图
			if (obj.objects.Add(square))
			{
				obj.SetModifiedFlag();
				//pDoc->UpdateAllViews(NULL);
			}
			}
		else if (temp_ElementType == 2)
		{
			CRectangle *rectangle = new CRectangle();
			rectangle->SetValue(temp_ElementType, temp_W, temp_H, point, temp_BorderWidth, temp_BorderType, temp_color, temp_FillType, temp_FillColor, temp_str);
			rectangle->Draw(dc);//ctrl+点击画图
			if (obj.objects.Add(rectangle))//添加对象
			{
				obj.SetModifiedFlag();
			}
		}
		else if (temp_ElementType == 3)
		{
			CCircle *circle = new CCircle();
			circle->SetValue(temp_ElementType, temp_W, temp_H, point, temp_BorderWidth, temp_BorderType, temp_color, temp_FillType, temp_FillColor, temp_str);
			circle->Draw(dc);
			if (obj.objects.Add(circle))
			{
				obj.SetModifiedFlag();
			}
		}
		else if (temp_ElementType == 4)
		{
			CEllipse *ellipse = new CEllipse();
			ellipse->SetValue(temp_ElementType, temp_W, temp_H, point, temp_BorderWidth, temp_BorderType, temp_color, temp_FillType, temp_FillColor, temp_str);
			ellipse->Draw(dc);
			if (obj.objects.Add(ellipse))
			{
				obj.SetModifiedFlag();
			}
		}
		else if (temp_ElementType == 5)
		{
			CTriangle *triangle = new CTriangle();
			triangle->SetValue(temp_ElementType, temp_W, temp_H, point, temp_BorderWidth, temp_BorderType, temp_color, temp_FillType, temp_FillColor, temp_str);
			triangle->Draw(dc);
			if (obj.objects.Add(triangle))
			{
				obj.SetModifiedFlag();
			}
		}
		else if (temp_ElementType == 6)
		{
			CText *text = new CText();
			//text->str = temp_str;
			text->SetValue(temp_ElementType, temp_W, temp_H, point, temp_BorderWidth, temp_BorderType, temp_color, temp_FillType, temp_FillColor, temp_str);
			text->Draw(dc);
			if (obj.objects.Add(text))
			{
				obj.SetModifiedFlag();
			}
		}
		}
		*/
	}
	public static void Paint()
	{
		/*
		CClientDC *DC = new CClientDC(this);
		pDC = DC;
		LPDWORD ThreadID=0;
		hwnd=CreateThread(NULL, 0, (LPTHREAD_START_ROUTINE)ThreadFunc, NULL, 0, ThreadID);
		*/
	}
	//extern int temp;
	//extern BOOL del;
	public void OnRButtonDblClk(/*UINT nFlag, CPoint point*/)
	{
		/*
		YN = FALSE;
		//PostQuitMessage(ThreadFunc,1);结束所处的进程
		TerminateThread(hwnd,1);

		Ctext3Doc *pDoc = GetDocument();
		ASSERT_VALID(pDoc);
		if (!pDoc) return;

		if(!YN) Invalidate(TRUE);//重绘窗口
		CClientDC *dc = new CClientDC(this);
		Setting *set = new Setting();
		//修改图形
		int i = 0;
		temp = 0;
		for (i = 0; i < obj.objects.GetCount(); i++)
		{
			CShape *p = (CShape *)obj.objects[i];
			if (p->IsMatched(point))
			{
				temp = 1;//提示信息
				set->DoModal();
				if (del)
				{
				obj.objects.RemoveAt(i);
				if (temp_ElementType == 1)
				{
					CSquare *squ = new CSquare();
					squ->SetValue(temp_ElementType, temp_W, temp_H, point, temp_BorderWidth, temp_BorderType, temp_color, temp_FillType, temp_FillColor, temp_str);
					obj.objects.Add(squ);
					squ->Draw(dc);
				}
				if (temp_ElementType == 2)
				{
					CRectangle *rec=new CRectangle();
					rec->SetValue(temp_ElementType, temp_W, temp_H, point, temp_BorderWidth, temp_BorderType, temp_color, temp_FillType, temp_FillColor, temp_str);
					obj.objects.Add(rec);
					rec->Draw(dc);
				}
				if (temp_ElementType == 3)
				{
					CCircle *cir = new CCircle();
					cir->SetValue(temp_ElementType, temp_W, temp_H, point, temp_BorderWidth, temp_BorderType, temp_color, temp_FillType, temp_FillColor, temp_str);
					obj.objects.Add(cir);
					cir->Draw(dc);
				}
				if (temp_ElementType == 4)
				{
					CEllipse *cir = new CEllipse();
					cir->SetValue(temp_ElementType, temp_W, temp_H, point, temp_BorderWidth, temp_BorderType, temp_color, temp_FillType, temp_FillColor, temp_str);
					obj.objects.Add(cir);
					cir->Draw(dc);
				}
				if (temp_ElementType == 5)
				{
					CTriangle *cir = new CTriangle();
					cir->SetValue(temp_ElementType, temp_W, temp_H, point, temp_BorderWidth, temp_BorderType, temp_color, temp_FillType, temp_FillColor, temp_str);
					obj.objects.Add(cir);
					cir->Draw(dc);
				}
				if (temp_ElementType == 6)
				{
					CText *cir = new CText();
					cir->SetValue(temp_ElementType, temp_W, temp_H, point, temp_BorderWidth, temp_BorderType, temp_color, temp_FillType, temp_FillColor, temp_str);
					obj.objects.Add(cir);
					cir->Draw(dc);
				}
				
				//p->Draw(dc);
				pDoc->UpdateAllViews(NULL);//更新
				del = FALSE;
				}
				return;

			}
		}
		if (i == 0||i== obj.objects.GetCount()) set->DoModal();
		*/
	}

	void OnLButtonDblClk(/*UINT nFlag, CPoint point*/)//删除图元
	{
		/*
		Ctext3Doc *pDoc=GetDocument();
		ASSERT_VALID(pDoc);
		if (!pDoc) return;

		for (int i = 0; i < obj.objects.GetCount(); i++)
		{
			CShape *p = (CShape *)obj.objects[i];//虚函数，，，多态性
			if (p->IsMatched(point))
			{
					obj.objects.RemoveAt(i);
					pDoc->UpdateAllViews(NULL);
					return;
			}
		}
		*/
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("view");
	}

}
