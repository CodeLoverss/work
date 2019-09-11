package work2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class test2 {
	
	public static class UserManagerImpl implements UserManager {
		 
		@Override
		public void addUser(String userId, String userName) {
			System.out.println("UserManagerImpl.addUser");
		}
	}
	

	//��̬������
	public static class UserManagerImplProxy implements UserManager {
	 
		// Ŀ�����
		private UserManager userManager;
		// ͨ�����췽������Ŀ�����
		public UserManagerImplProxy(UserManager userManager){
			this.userManager=userManager;
		}
		@Override
		public void addUser(String userId, String userName) {
			try{
					//��Ӵ�ӡ��־�Ĺ���
					//��ʼ����û�
					System.out.println("start-->addUser()");
					userManager.addUser(userId, userName);
					//����û��ɹ�
					System.out.println("success-->addUser()");
				}catch(Exception e){
					//����û�ʧ��
					System.out.println("error-->addUser()");
				}
		}
	 
	}

	//��̬������
	public static class LogHandler implements InvocationHandler {
		 
		private Object targetObject;//Ŀ��
		//�󶨹�ϵ��Ҳ���ǹ������ĸ��ӿڣ�������ʵ����󶨣�����Щ������������ʱ��ִ��invoke������            
		public Object newProxyInstance(Object targetObject){
			this.targetObject=targetObject;
			//��һ������ָ�������������������������Ҫ����ָ��Ϊ��Ŀ�����ͬһ���������
			//�ڶ�������Ҫʵ�ֺ�Ŀ�����һ���Ľӿڣ�����ֻ��Ҫ�õ�Ŀ������ʵ�ֽӿ�
			//����������������Щ�����صķ����ڱ�����ʱ��Ҫִ���ĸ�InvocationHandler��invoke����
			//���ݴ����Ŀ�귵��һ���������
			return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
					targetObject.getClass().getInterfaces(),this);
		}
		@Override
		//���������ʵ����ķ���������ʱ����ִ��
		/*InvocationHandler�ӿڵķ�����proxy��ʾ����method��ʾԭ���󱻵��õķ�����args��ʾ�����Ĳ���*/
		public Object invoke(Object proxy, Method method, Object[] args)
				throws Throwable {
			System.out.println("start-->>");
			for(int i=0;i<args.length;i++){
				System.out.println(args[i]);//����ֵ
			}
			Object ret=null;
			try{
				/*ԭ���󷽷�����ǰ������־��Ϣ*/
				System.out.println("satrt-->>");
				
				//����Ŀ�귽��
				ret=method.invoke(targetObject, args);
				/*ԭ���󷽷����ú�����־��Ϣ*/
				System.out.println("success-->>");
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("error-->>");
				throw e;
			}
			return ret;
		}
	 
	}
	
	public static void main(String[] args) {
		//��̬����
		UserManager userManager=new UserManagerImplProxy(new UserManagerImpl());
		userManager.addUser("111", "jack");

		//��̬����
		LogHandler logHandler=new LogHandler();
		UserManager userManager2=(UserManager)logHandler.newProxyInstance(new UserManagerImpl());
		userManager2.addUser("222", "rose");

	}

}
