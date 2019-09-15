package work3;



public class MatrixTest{
	
	public abstract static class GenericMatrix <E extends Number>{
		
		protected abstract E add(E o1,E o2);
		protected abstract E multiply(E o1,E o2);
		protected abstract E zero();
		public E[][] addMatrix(E[][]matrix1,E[][]matrix2){
			if((matrix1.length!=matrix2.length)||(matrix1[0].length!=matrix2[0].length)){
				throw new RuntimeException("The matrices do not have the same size");
				
			}
			E[][] result=(E[][])new Number[matrix1.length][matrix1[0].length];
			for(int i=0;i<result.length;i++)
				for(int j=0;j<result[i].length;j++){
					result[i][j]=add(matrix1[i][j],matrix2[i][j]);
				}
			return result;
		}
		public E[][] mulyiplyMartix(E[][]matrix1,E[][]matrix2){
			if((matrix1.length!=matrix2.length)||(matrix1[0].length!=matrix2[0].length)){
				throw new RuntimeException("The matrices do not have the same size");
				
			}
			E[][] result=(E[][])new Number[matrix1.length][matrix2[0].length];
			for(int i=0;i<result.length;i++)
				for(int j=0;j<result[0].length;j++){
					result[i][j]=zero();
					for(int k=0;k<matrix1[0].length;k++){
						result[i][j]=add(result[i][j],multiply(matrix1[i][k],matrix2[k][j]));
					}
					
				}
			return result;
			
		}
		public static void printResult(Number[][] m1,Number[][] m2,Number[][]m3,char op){
			for(int i=0;i<m1.length;i++){
				for(int j=0;j<m1[0].length;j++)
					System.out.print(" "+m1[i][j]);
				if(i==m1.length/2)
					System.out.print(" "+op+" ");
				else
					System.out.print("   ");
				for(int j=0;j<m2.length;j++)
					System.out.print(" "+m2[i][j]);
				if(i==m1.length/2)
					System.out.print(" = ");
				else
					System.out.print("   ");
				for(int j=0;j<m3.length;j++)
					System.out.print(m3[i][j]+" ");
				System.out.println();
				
			}
		}
	 
	}
	public static class IntegerMatrix extends GenericMatrix<Integer>{
	 
		@Override
		protected Integer add(Integer o1, Integer o2) {
			return o1+o2;
		}
	 
		@Override
		protected Integer multiply(Integer o1, Integer o2) {
			return o1*o2;
		}
	 
		@Override
		protected Integer zero() {
			return 0;
		}
		
	 
	}
	public static class RationalMatrix extends GenericMatrix<Rational>{
		@Override
		protected Rational add(Rational o1, Rational o2) {
			return o1.add(o2);
		}
	 
		@Override
		protected Rational multiply(Rational o1, Rational o2) {
			return o1.multiply(o2);
		}
		
		@Override
		protected Rational zero() {
			return new Rational(0,1);
		}
	 
	}
	public static class Rational extends Number{
		private long numerator=0;
		private long denominator=1;
		public Rational(){
			this(0,1);
		}
		public Rational(long num1,long num2){
			long gcd=gcd(num1,num2);
			this.numerator=(num2>0?1:-1)*num1/gcd;
			this.denominator=Math.abs(num2)/gcd;
		}
		private static long gcd(long n,long d){
			long n1=Math.abs(n);
			long n2=Math.abs(d);
			int gcd=1;
			for(int k=1;k<=n1&&k<=n2;k++){
				if(n1%k==0&&n2%k==0)
					gcd=k;
			}
			return gcd;
		}
		public String toString(){
			if(denominator==1)
				return numerator+"";
			else
				return numerator+"/"+denominator;
		}
		@Override
		public double doubleValue() {
			// TODO 自动生成的方法存根
			return numerator*1.0/denominator;
		}
		@Override
		public float floatValue() {
			// TODO 自动生成的方法存根
			return (float) doubleValue();
		}
		@Override
		public int intValue() {
			// TODO 自动生成的方法存根
			return (int) doubleValue();
		}
		@Override
		public long longValue() {
			// TODO 自动生成的方法存根
			return (long) doubleValue();
		}
		public long getNumerator(){
			return numerator;
		}
		public long GetDenominator(){
			return denominator;
		}
		public Rational add(Rational second){
			long n=numerator*second.GetDenominator()+denominator*second.getNumerator();
			long d=denominator*second.GetDenominator();
			return new Rational(n,d);
		}
		public Rational multiply(Rational second){
			long n=numerator*second.getNumerator();
			long d=denominator*second.GetDenominator();
			return new Rational(n,d);
		}
	 
	}
	//TestIntegerMatrix {
		public static void main(String args[]){
			Integer[][] m1=new Integer[][]{{1,2,3},{4,5,6},{7,8,9}};
			Integer[][] m2=new Integer[][]{{1,1,1},{2,2,2},{3,3,3}};
			IntegerMatrix integerMatrix=new IntegerMatrix();
			System.out.println("\nm1+m2 is");
			GenericMatrix.printResult(m1, m2, integerMatrix.addMatrix(m1, m2), '+');
			System.out.println("\nm1*m2 is");
			GenericMatrix.printResult(m1, m2, integerMatrix.mulyiplyMartix(m1, m2), '+');
		
	//TestRationalMatrix {
		
		Rational[][] m3=new Rational[3][3];
		Rational[][] m4=new Rational[3][3];
		for(int i=0;i<m1.length;i++)
		   for(int j=0;j<m1[0].length;j++){
			m3[i][j]=new Rational(i+1,j+2);
			m4[i][j]=new Rational(i+1,j+2);
			
		}
		RationalMatrix rationalMartrix=new RationalMatrix();
		System.out.println("\nm1+m2 is");
		GenericMatrix.printResult(m3, m4, rationalMartrix.addMatrix(m3, m4), '+');
		
		System.out.println("\nm1*m2 is");
		GenericMatrix.printResult(m3, m4, rationalMartrix.mulyiplyMartix(m3, m4), '*');
		}
	
	
}
