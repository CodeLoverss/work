package work4;

public class Compare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long beginTime = System.currentTimeMillis();
		String str = "";
		for (int i = 0; i < 10000; i++){
		str = str + i;
		}
		long endTime = System.currentTimeMillis();

		long beginTime2 = System.currentTimeMillis();
		StringBuilder builder = new StringBuilder("");
		for (int j = 0; j < 10000; j++){
		builder.append(j);
		}
		long endTime2 = System.currentTimeMillis();
		
		System.out.println("String执行时间：" + (endTime - beginTime)+"ms");
		System.out.println("StringBuilder执行时间：" + (endTime2 - beginTime2)+"ms");

		
	}

}
