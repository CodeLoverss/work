
package work6; 
import java.io.*; 
import java.net.*;
import java.util.Scanner;
  
  public class Client {
  
  public static void main(String[] args) { // TODO Auto-generated method stub  
  Socket mysocket;
  
  DataInputStream in=null;
  
  DataOutputStream out=null;
  
  try {  
	  mysocket =new Socket("127.0.0.1", 2019);
  	  in =new DataInputStream(mysocket.getInputStream()); 
  	  out =new DataOutputStream(mysocket.getOutputStream()); 
  
  	  System.out.println("orders:\n<register name='xu'/>\n<login name='xu'/>\n<message from='xu' to='zhang' message='this is a test'>"
  	  		+ "\n<logout name='xu'/>");
  	  
  	  while(true)
  	  {
  	  System.out.println("please input instruction:\n");
	  Scanner input = new Scanner(System.in);
	  String orderNum=input.nextLine();
	  
	  out.writeUTF(orderNum);
	  String reply=in.readUTF();//in读取信息，阻塞状态
	  System.out.println("the replies received by client:"+reply);
	  Thread. sleep(500);
  	  }
 
  }
  
  catch(Exception e) {
  
  System.out.println("the server disconnented"+e);
  
  	} 
  }
  
  }
 



/*
 * package work6;
 * 
 * 
 * 
 * import java.awt.BorderLayout;
 * 
 * import java.awt.Container;
 * 
 * import java.awt.FlowLayout;
 * 
 * import java.awt.event.ActionEvent;
 * 
 * import java.awt.event.ActionListener;
 * 
 * import java.io.DataInputStream;
 * 
 * import java.io.DataOutputStream;
 * 
 * import java.io.IOException;
 * 
 * import java.net.Socket;
 * 
 * import java.net.UnknownHostException;
 * 
 * 
 * 
 * import javax.swing.JButton;
 * 
 * import javax.swing.JFrame;
 * 
 * import javax.swing.JLabel;
 * 
 * import javax.swing.JPanel;
 * 
 * import javax.swing.JTextArea;
 * 
 * import javax.swing.JTextField;
 * 
 * 
 * 
 * public class Client extends JFrame implements ActionListener, Runnable {
 * 
 * Socket clientSocket = null;
 * 
 * DataInputStream in = null;
 * 
 * DataOutputStream out = null;
 * 
 * String str = null;
 * 
 * JButton button;
 * 
 * JTextField tf;
 * 
 * JTextArea ta;
 * 
 * Thread thread;
 * 
 * public Client(){
 * 
 * thread = new Thread(this);
 * 
 * initSwing();
 * 
 * initSocket();
 * 
 * }
 * 
 * 
 * 
 * public void initSwing(){
 * 
 * Container container = this.getContentPane();
 * 
 * JPanel panel = new JPanel();
 * 
 * JLabel label = new JLabel("输入聊天内容：");
 * 
 * tf = new JTextField(40);
 * 
 * button = new JButton("发送");
 * 
 * button.addActionListener(this);
 * 
 * panel.setLayout(new FlowLayout(FlowLayout.LEFT));
 * 
 * panel.add(label);
 * 
 * panel.add(tf);
 * 
 * panel.add(button);
 * 
 * ta = new JTextArea();
 * 
 * container.setLayout(new BorderLayout());
 * 
 * container.add(ta,BorderLayout.CENTER);
 * 
 * container.add(panel,BorderLayout.SOUTH);
 * 
 * this.setTitle("客户端程序");
 * 
 * this.setBounds(300, 200, 700, 350);
 * 
 * this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 * 
 * this.validate();
 * 
 * this.setVisible(true);
 * 
 * }
 * 
 * public void initSocket(){
 * 
 * try {
 * 
 * clientSocket = new Socket("127.0.0.1", 4331);
 * 
 * in = new DataInputStream(clientSocket.getInputStream());
 * 
 * out = new DataOutputStream(clientSocket.getOutputStream());
 * 
 * } catch (UnknownHostException e) {
 * 
 * e.printStackTrace();
 * 
 * } catch (IOException e) {
 * 
 * e.printStackTrace();
 * 
 * }
 * 
 * 
 * 
 * //启动线程
 * 
 * thread.start();
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * @Override
 * 
 * public void run() {
 * 
 * while(true){//一直监听是否有信息发来
 * 
 * try {
 * 
 * str = in.readUTF();
 * 
 * ta.append(str + "\n");
 * 
 * 
 * 
 * } catch (IOException e) {
 * 
 * e.printStackTrace();
 * 
 * }
 * 
 * }
 * 
 * }
 * 
 * 
 * 
 * @Override
 * 
 * public void actionPerformed(ActionEvent e) {
 * 
 * if(e.getSource() == button){
 * 
 * try {
 * 
 * out.writeUTF(tf.getText());
 * 
 * } catch (IOException e1) {
 * 
 * e1.printStackTrace();
 * 
 * }
 * 
 * }
 * 
 * }
 * 
 * public static void main(String[] args) {
 * 
 * Client client = new Client();
 * 
 * }
 * 
 * 
 * 
 * }
 */