
  package work6; 
  
  import java.io.*; 
  import java.net.*;

  public class Server { public static void main(String[] args) { 
  ServerSocket serverForClient=null;
  Socket socketOnServer=null;
  
  DataOutputStream out = null;
  
  DataInputStream in =null;
  boolean ifRegister=false;
  boolean ifLogin=false;
  
  try { serverForClient =new ServerSocket(2019); }
  
  catch (IOException el) {
  
  System. out. println(el); }
  
  try { 
	 
	  System. out.println("wait for client......");
	  socketOnServer =serverForClient.accept();//阻塞状态，除非有客户 
	  out =new DataOutputStream(socketOnServer.getOutputStream()); 
	  in = new DataInputStream(socketOnServer.getInputStream()); 
	  
	  while(true) {
	  String s=in.readUTF();//1n读取信息，阻寒状态
	  if(s.equals("<register name='xu'/>"))
	  {
		  if(!ifRegister)
		  {
			  out.writeUTF("<result command='register' state='ok'/>");
			  ifRegister=true;
		  }
		  else out.writeUTF("<result command='register' state='error' message='Unable to double register'/>");
		  Thread.sleep(500); 
	  }
	  else if(s.equals("<login name='xu'/>"))
	  {
		  if(!ifLogin)
		  {
			  out.writeUTF("<result command='login' state='ok'/>");
			  ifLogin=true;
		  }
		  else out.writeUTF("<result command='register' state='error' message='Unable to double login'/>");
		  Thread.sleep(500); 
		  
	  }
	  else if(s.equals("<message from='xu' to='zhang' message='this is a test'>"))
	  {
		  out.writeUTF("<result command='message' state='ok'/>");
		  
	  }
	  else if(s.equals("<logout name='xu'/>"))
	  {
		  if(ifLogin)
		  {
			  out.writeUTF("<result command='logout' state='ok'/>");
			  ifLogin=false;
		  }
		  else out.writeUTF("<result command='logout' state='error' message='You are not logged in yet'/>");
		  
	  }
	  else
	  {
		  out.writeUTF("wrong instruction！");
		  Thread.sleep(500);
	  }
	 }
	  }
  
  catch (Exception e) {
  
  System.out.println("the client disconnected"+e); }
  
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
 * import java.io.DataInputStream;
 * 
 * import java.io.DataOutputStream;
 * 
 * import java.io.IOException;
 * 
 * import java.net.ServerSocket;
 * 
 * import java.net.Socket;
 * 
 * import java.util.ArrayList;
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
 * import javax.swing.border.Border;
 * 
 * 
 * 
 * public class Server extends JFrame {//实现聊天室多人聊天。 客户端一对多通信
 * 
 * 
 * 
 * ServerSocket serverSocket = null;
 * 
 * Socket clientSocket = null;
 * 
 * ArrayList<Socket> array = null;
 * 
 * JTextArea ta;
 * 
 * //构造器是没有返回值的
 * 
 * public Server(){
 * 
 * initSwing();
 * 
 * initSocket();
 * 
 * }
 * 
 * public void initSwing(){
 * 
 * Container container = this.getContentPane();
 * 
 * ta = new JTextArea();
 * 
 * 
 * 
 * container.setLayout(new BorderLayout());
 * 
 * container.add(ta,BorderLayout.CENTER);
 * 
 * JLabel label = new JLabel("输入聊天内容：");
 * 
 * JTextField tf = new JTextField(40);
 * 
 * JButton button = new JButton("发送");
 * 
 * JPanel south = new JPanel();
 * 
 * south.setLayout(new FlowLayout(FlowLayout.LEFT));
 * 
 * south.add(label);
 * 
 * south.add(tf);
 * 
 * south.add(button);
 * 
 * container.add(south,BorderLayout.SOUTH);
 * 
 * this.setTitle("服务器端程序");
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
 * array = new ArrayList<Socket>();
 * 
 * try {
 * 
 * serverSocket = new ServerSocket(4331);
 * 
 * while(true){
 * 
 * clientSocket = serverSocket.accept();
 * 
 * //每增加一个客户端，就将其加入到array中
 * 
 * array.add(clientSocket);
 * 
 * ClientThread clientThread = new ClientThread(clientSocket);
 * 
 * Thread t = new Thread(clientThread);
 * 
 * t.start();
 * 
 * }
 * 
 * } catch (IOException e) {
 * 
 * e.printStackTrace();
 * 
 * }
 * 
 * }
 * 
 * 
 * 
 * //主程序入口
 * 
 * public static void main(String[] args) {
 * 
 * Server server = new Server();
 * 
 * }
 * 
 * 
 * 
 * //客户端线程--类中定义的类
 * 
 * class ClientThread implements Runnable{
 * 
 * 
 * 
 * private Socket clientSocket;
 * 
 * private String str = null;
 * 
 * DataInputStream in = null;
 * 
 * DataOutputStream out = null;
 * 
 * public ClientThread(Socket clientSocket){
 * 
 * this.clientSocket = clientSocket;
 * 
 * try {
 * 
 * in = new DataInputStream(clientSocket.getInputStream());
 * 
 * out = new DataOutputStream(clientSocket.getOutputStream());
 * 
 * } catch (IOException e) {
 * 
 * e.printStackTrace();
 * 
 * }
 * 
 * }
 * 
 * 
 * 
 * @Override
 * 
 * public void run() {
 * 
 * while(true){
 * 
 * try {
 * 
 * str = in.readUTF();
 * 
 * ta.append(str + "\n");
 * 
 * //服务端每次收到的信息，必须向所有的客户端发送
 * 
 * DataOutputStream out = null;
 * 
 * for(int i = 0; i < array.size(); i++){
 * 
 * out = new DataOutputStream(array.get(i).getOutputStream());
 * 
 * out.writeUTF(str);
 * 
 * }
 * 
 * 
 * 
 * Thread.sleep(1000);
 * 
 * } catch (Exception e) {
 * 
 * e.printStackTrace();
 * 
 * }
 * 
 * }
 * 
 * 
 * 
 * }
 * 
 * 
 * 
 * }
 * 
 * }
 * 
 */
