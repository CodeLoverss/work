package work1;


public class Shapes {

	
	public static abstract class Shape{
		
	String str;
	int ElementType;
	int  OrgX, OrgY,Width,Height;
	String BorderColor;//边界颜色
	String FillColor;//填充颜色
	int BorderType;//边界类型
	int BorderWidth;//边界宽度
	int FillType;//填充类型

	 Shape()
	 {
	 	ElementType = 0;
	 	OrgX = 0; 
	 	OrgY = 0;
	 	Width = 0;
	 	Height = 0;
	 	BorderWidth = 0;
	 	BorderType = 0;
	 	FillType = 0;
	 	BorderColor = "a";
	 	FillColor = "a";
	 }
	 public abstract void SetValue(int elementtype,int width,int height ,String point,int borderwidth, int temp_BorderType,String temp_color, int temp_FillType, String temp_FillColor,String s);
	 /*
	 {
		
	 	str = s;
	 	ElementType = elementtype;
	 	Width = width;
	 	Height = height;
	 	OrgX = 1;
	 	OrgY = 1;
	 	BorderWidth = borderwidth;
	 	BorderType = temp_BorderType;
	 	BorderColor=temp_color;
	 	FillType = temp_FillType;
	 	FillColor = temp_FillColor;
	 	
	 }
	 */

	 public abstract void Draw();

	 public abstract void Serialize();//存取

	 public abstract boolean IsMatched();
	/*
	public static void main(String args[])
	{

		System.out.print("fgdf");
	}
	*/
	}

	public static class Square extends Shape{

		@Override
		public boolean IsMatched()
		{
			return false;
			/*
			if (point.x >= (OrgX - Width/2) && point.x <= (OrgX+Width/2) && point.y >= (OrgY- Width /2) && point.y <= (OrgY + Width /2))
			{
				return true;
			}
			else
			{
				return false;
			}
			*/
		}

		@Override
		public void SetValue(int elementtype, int width, int height, String point, int borderwidth, int temp_BorderType,
				String temp_color, int temp_FillType, String temp_FillColor, String s) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void Serialize() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void Draw() {
			// TODO Auto-generated method stub
			/*
			if (BorderType != -1)
			{
				CPen newpen(BorderType, BorderWidth, BorderColor);
				CPen oldpen;
				pDC->SelectObject(&newpen);
				pDC->Rectangle(OrgX - Width / 2, OrgY - Width / 2, OrgX + Width / 2, OrgY + Width / 2);
				pDC->SelectObject(&oldpen);
			}
			
			if (FillType != -1)
			{
				CBrush newbrush(FillType,FillColor);
				CBrush oldbrush;
				pDC->SelectObject(&newbrush);
				pDC->Rectangle(OrgX - Width / 2, OrgY - Width / 2, OrgX + Width / 2, OrgY + Width / 2);
				pDC->SelectObject(&oldbrush);
			}
			*/
			
		}
	}
	
	public static class Rectangle extends Shape{
		
		@Override
		public void SetValue(int elementtype, int width, int height, String point, int borderwidth, int temp_BorderType,
				String temp_color, int temp_FillType, String temp_FillColor, String s) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void Serialize() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void Draw() {
			// TODO Auto-generated method stub
			/*
			if (BorderType != -1)
			{
				CPen newpen(BorderType, BorderWidth, BorderColor);
				CPen oldpen;
				pDC->SelectObject(&newpen);
				pDC->Rectangle(OrgX - Width / 2, OrgY - Height / 2, OrgX + Width / 2, OrgY + Height / 2);
				pDC->SelectObject(&oldpen);
			}

			if (FillType != -1)
			{
				CBrush newbrush(FillType, FillColor);
				CBrush oldbrush;
				pDC->SelectObject(&newbrush);
				pDC->Rectangle(OrgX - Width / 2, OrgY - Height / 2, OrgX + Width / 2, OrgY + Height / 2);
				pDC->SelectObject(&oldbrush);
			}
			*/
		}

		@Override
		public boolean IsMatched() {
			// TODO Auto-generated method stub
			return false;
			/*
			if (point.x >= (OrgX - Width / 2) && point.x <= (OrgX + Width / 2) && point.y >= (OrgY - Height / 2) && point.y <= (OrgY + Height / 2))
			{
				return true;
			}
			else
			{
				return false;
			}
			*/
		}

	}

	public static class Circle extends Shape{

		@Override
		public void SetValue(int elementtype, int width, int height, String point, int borderwidth, int temp_BorderType,
				String temp_color, int temp_FillType, String temp_FillColor, String s) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void Serialize() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void Draw() {
			// TODO Auto-generated method stub
			/*
			if (BorderType != -1)
			{	
				CPen newpen(BorderType, BorderWidth, BorderColor);
				CPen oldpen;
				pDC->SelectObject(&newpen);
				pDC->Ellipse(OrgX - Width / 2, OrgY - Width / 2, OrgX + Width / 2, OrgY + Width / 2);
				pDC->SelectObject(&oldpen);
			}

			if (FillType != -1)
			{
				CBrush newbrush(FillType, FillColor);
				CBrush oldbrush;
				pDC->SelectObject(&newbrush);
				pDC->Ellipse(OrgX - Width / 2, OrgY - Width / 2, OrgX + Width / 2, OrgY + Width / 2);
				pDC->SelectObject(&oldbrush);
			}
			*/
		}

		@Override
		public boolean IsMatched() {
			// TODO Auto-generated method stub
			return false;
			/*
			if (pow((point.x-OrgX),2)+pow((point.y-OrgY),2)<pow(Width/2,2))
			{
				return true;
			}
			else
			{
				return false;
			}
			*/
		}
	}
	
	public static class Ellipse extends Shape{
		
		@Override
		public void SetValue(int elementtype, int width, int height, String point, int borderwidth, int temp_BorderType,
				String temp_color, int temp_FillType, String temp_FillColor, String s) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void Draw() {
			// TODO Auto-generated method stub
			/*
			if (BorderType != -1)
			{	
				CPen newpen(BorderType, BorderWidth, BorderColor);
				CPen oldpen;
				pDC->SelectObject(&newpen);
				pDC->Ellipse(OrgX - Width / 2, OrgY - Height / 2, OrgX + Width / 2, OrgY + Height / 2);
				pDC->SelectObject(&oldpen);
			
			}

			if (FillType != -1)
			{
				CBrush newbrush(FillType, FillColor);
				CBrush oldbrush;
				pDC->SelectObject(&newbrush);
				pDC->Ellipse(OrgX - Width / 2, OrgY - Height / 2, OrgX + Width / 2, OrgY + Height / 2);
				pDC->SelectObject(&oldbrush);
			}
			*/
		}
		@Override
		public void Serialize() {
			// TODO Auto-generated method stub
			
		}
		@Override
		public boolean IsMatched() {
			// TODO Auto-generated method stub
			return false;
			/*
			if (Width >= Height)
			{
				float s = ((pow(point.x, 2) / pow(Width, 2)) + (pow(point.y, 2) / pow(Height, 2)));
				if (((pow(point.x-OrgX,2) / pow(Width,2)) + (pow(point.y-OrgY,2) / pow(Height,2))) <= 0.25)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			else
			{
				float s1 = ((pow(point.x, 2) / pow(Height, 2)) + (pow(point.y, 2) / pow(Width, 2)));
				if (((pow(point.x-OrgX,2) / pow(Height,2)) + (pow(point.y-OrgY,2) / pow(Width,2))) <= 0.25)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			*/
		}
	}
	
	public static class Triangle extends Shape{
		
		@Override
		public void SetValue(int elementtype, int width, int height, String point, int borderwidth, int temp_BorderType,
				String temp_color, int temp_FillType, String temp_FillColor, String s) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void Draw() {
			// TODO Auto-generated method stub
			/*
			if (BorderType != -1)
			{
				CPen newpen(BorderType, BorderWidth, BorderColor);
				CPen oldpen;
				pDC->SelectObject(&newpen);
				CPoint point[] = { CPoint(OrgX, OrgY - (Width / 2 / cos(PI / 6))),
								   CPoint(OrgX + Width / 2, OrgY + (Width*cos(PI / 6) - Width / 2 / cos(PI / 6))),
								   CPoint(OrgX - Width / 2, OrgY + (Width*cos(PI / 6) - Width / 2 / cos(PI / 6)))
								  };
				pDC->Polygon(point,3);
				/*
				pDC->MoveTo(OrgX, OrgY - (Width / 2 / cos(PI / 6)));
				pDC->LineTo(OrgX + Width / 2, OrgY + (Width*cos(PI / 6) - Width / 2 / cos(PI / 6)));
				pDC->LineTo(OrgX - Width / 2, OrgY + (Width*cos(PI / 6) - Width / 2 / cos(PI / 6)));
				pDC->LineTo(OrgX, OrgY - (Width / 2 / cos(PI / 6)));
				pDC->SelectObject(&oldpen);
				
			}

			if (FillType != -1)
			{
				CBrush newbrush(FillType, FillColor);
				CBrush oldbrush;
				pDC->SelectObject(&newbrush);
				CPoint point[] = { CPoint(OrgX, OrgY - (Width / 2 / cos(PI / 6))),
								    CPoint(OrgX + Width / 2, OrgY + (Width*cos(PI / 6) - Width / 2 / cos(PI / 6))),
								    CPoint(OrgX - Width / 2, OrgY + (Width*cos(PI / 6) - Width / 2 / cos(PI / 6)))
				};
				pDC->Polygon(point, 3);
				/*
				pDC->MoveTo(OrgX, OrgY - (Width / 2 / cos(PI / 6)));
				pDC->LineTo(OrgX + Width / 2, OrgY + (Width*cos(PI / 6) - Width / 2 / cos(PI / 6)));
				pDC->LineTo(OrgX - Width / 2, OrgY + (Width*cos(PI / 6) - Width / 2 / cos(PI / 6)));
				pDC->LineTo(OrgX, OrgY - (Width / 2 / cos(PI / 6)));
				pDC->SelectObject(&oldbrush);
				
			}
			*/
		}
		@Override
		public void Serialize() {
			// TODO Auto-generated method stub
			
		}
		@Override
		public boolean IsMatched() {
			// TODO Auto-generated method stub
			return false;
			/*
			float a1, b1, a2, b2, a3, b3;
			//顶点
			a1 = OrgX;
			b1 = OrgY - (Width / 2 / cos(PI / 6));
			//右点
			a2 = OrgX + Width / 2;
			b2 = OrgY + (Width*cos(PI / 6) - Width / 2 / cos(PI / 6));
			//左点
			a3 = OrgX - Width / 2;
			b3 = OrgY + (Width*cos(PI / 6) - Width / 2 / cos(PI / 6));
			//斜率
			float k1 = (b1 - b3) / (a1 - a3), k2 = (b1 - b2) / (a1 - a2);
			if (((k1*point.x + b1 - k1 * a1) <= point.y) && ((k2*point.x + b1 - k2 * a1) <= point.y)&&(point.y<=b2))
			{
				return true;
			}
			else
			{
				return false;
			}
			*/
		}
	}

	public static class Text extends Shape{
		
		
		@Override
		public void SetValue(int elementtype, int width, int height, String point, int borderwidth, int temp_BorderType,
				String temp_color, int temp_FillType, String temp_FillColor, String s) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void Draw() {
			// TODO Auto-generated method stub
			/*
			//CPen newpen(BorderType, BorderWidth, BorderColor);
			//CPen oldpen;
			//pDC->SelectObject(&newpen);
			//pDC->TextOut(OrgX, OrgY, str);
			//pDC->SelectObject(&oldpen);
			CFont *newfont=new CFont(), *oldfont;
			newfont->CreateFont(Height*1.5, Height*0.7, Width * 10, 0, BorderWidth, FALSE, FALSE, 0, ANSI_CHARSET, OUT_DEFAULT_PRECIS, CLIP_DEFAULT_PRECIS, DEFAULT_QUALITY, DEFAULT_PITCH&FF_SWISS, "Aerial");
			oldfont=(CFont *)pDC->SelectObject(newfont);
			pDC->SetTextColor(BorderColor);
			pDC->SetBkColor(FillColor);
			pDC->TextOut(OrgX,OrgY,str);
			pDC->SelectObject(oldfont);
			*/
		}
		@Override
		public void Serialize() {
			// TODO Auto-generated method stub
			
		}
		@Override
		public boolean IsMatched() {
			// TODO Auto-generated method stub
			System.out.print("work1");
			return false;
			/*
			//旋转问题
			int Width1=Width;
			if (Width > 90) Width1 -= 90;
			int length = strlen(str);
			CPoint subpoint[] = {
				CPoint(OrgX,OrgY),
				CPoint(OrgX + Height * 1.5*sin(PI*Width1 / 180),OrgY + Height * 1.5*cos(PI*Width1 / 180)),
				CPoint(OrgX + Height * 1.5*sin(PI*Width1 / 180) + length*Height*0.7 * cos(Width1*PI / 180),OrgY + Height * 1.5*cos(PI*Width1 / 180) - length * Height*0.7 * sin(Width1*PI / 180)),
				CPoint(OrgX + length * Height*0.7 * cos(Width1*PI / 180),OrgY - length * Height*0.7 * sin(Width1*PI / 180))
			};
			
			float kit1 = (float)(subpoint[0].y - subpoint[1].y) / (subpoint[0].x - subpoint[1].x);
			float kit2 = (float)(subpoint[1].y - subpoint[2].y) / (subpoint[1].x - subpoint[2].x);
			float kit3 = (float)(subpoint[2].y - subpoint[3].y) / (subpoint[2].x - subpoint[3].x);
			float kit4 = (float)(subpoint[3].y - subpoint[0].y) / (subpoint[3].x - subpoint[0].x);

			float y1 = (float)kit1*point.x + subpoint[0].y - kit1 * subpoint[0].x;
			float y2 = (float)kit2*point.x + subpoint[1].y - kit2 * subpoint[1].x;
			float y3 = (float)kit3*point.x + subpoint[2].y - kit3 * subpoint[2].x;
			float y4 = (float)kit4*point.x + subpoint[3].y - kit4 * subpoint[3].x;

			if (point.y<=y1&&point.y<=y2&&point.y>=y3&&point.y>=y4)
			{
				return true;
			}
			else
			{
				return false;
			}
			*/
		}
	}
	
	public static void main(String[] args) {
			Text text=new Text();
			text.IsMatched();
		  }
		
}

