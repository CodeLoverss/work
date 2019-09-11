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
	

	//静态代理类
	public static class UserManagerImplProxy implements UserManager {
	 
		// 目标对象
		private UserManager userManager;
		// 通过构造方法传入目标对象
		public UserManagerImplProxy(UserManager userManager){
			this.userManager=userManager;
		}
		@Override
		public void addUser(String userId, String userName) {
			try{
					//添加打印日志的功能
					//开始添加用户
					System.out.println("start-->addUser()");
					userManager.addUser(userId, userName);
					//添加用户成功
					System.out.println("success-->addUser()");
				}catch(Exception e){
					//添加用户失败
					System.out.println("error-->addUser()");
				}
		}
	 
	}

	//动态代理类
	public static class LogHandler implements InvocationHandler {
		 
		private Object targetObject;//目标
		//绑定关系，也就是关联到哪个接口（与具体的实现类绑定）的哪些方法将被调用时，执行invoke方法。            
		public Object newProxyInstance(Object targetObject){
			this.targetObject=targetObject;
			//第一个参数指定产生代理对象的类加载器，需要将其指定为和目标对象同一个类加载器
			//第二个参数要实现和目标对象一样的接口，所以只需要拿到目标对象的实现接口
			//第三个参数表明这些被拦截的方法在被拦截时需要执行哪个InvocationHandler的invoke方法
			//根据传入的目标返回一个代理对象
			return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
					targetObject.getClass().getInterfaces(),this);
		}
		@Override
		//关联的这个实现类的方法被调用时将被执行
		/*InvocationHandler接口的方法，proxy表示代理，method表示原对象被调用的方法，args表示方法的参数*/
		public Object invoke(Object proxy, Method method, Object[] args)
				throws Throwable {
			System.out.println("start-->>");
			for(int i=0;i<args.length;i++){
				System.out.println(args[i]);//参数值
			}
			Object ret=null;
			try{
				/*原对象方法调用前处理日志信息*/
				System.out.println("satrt-->>");
				
				//调用目标方法
				ret=method.invoke(targetObject, args);
				/*原对象方法调用后处理日志信息*/
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
		//静态代理
		UserManager userManager=new UserManagerImplProxy(new UserManagerImpl());
		userManager.addUser("111", "jack");

		//动态代理
		LogHandler logHandler=new LogHandler();
		UserManager userManager2=(UserManager)logHandler.newProxyInstance(new UserManagerImpl());
		userManager2.addUser("222", "rose");

	}

}
