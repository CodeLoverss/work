package work13;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SwingDemo extends JFrame implements ActionListener{

	JLabel label1,label2,label3;
	JTextField text,he,want_erase;
	String s;
	public int flag = 0;
	public Container c;
	public SwingDemo()
	{
		super("my work");
		c = new Container();
		he = new JTextField();
		setLocation(600,300);
		setSize(500,300);
		setLayout(new GridLayout(8,1,10,10));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		text = new JTextField();
		label1 = new JLabel("请输入字符串：");
		getContentPane().add(label1);
		getContentPane().add(text);
		label2 = new JLabel("请输入你想要删除的字符:");
		getContentPane().add(label2);
		want_erase = new JTextField();
		want_erase.addActionListener(this);
		getContentPane().add(want_erase);
		label3 = new JLabel("最后结果是：");
		getContentPane().add(label3);
		getContentPane().add(he);
		setVisible(true);
	}
	public static void main(String args[])
	{
		new SwingDemo();
	}
	public void actionPerformed(ActionEvent e)
	{
		s = want_erase.getText();
		if(s.length()>1)
		{
			he.setText("你输入有误！");
		}
		else
		{
			String ss = new String();
			int k=0;
			String s1 = text.getText();
			char ch = s.charAt(0);
			for(int i = 0;i<s1.length();i++)
			{
				if(s1.charAt(i)==ch)
					continue;
				else
					ss=ss+s1.charAt(i);
			}
			he.setText(ss);
		}
		this.setVisible(true);
	}
}
