package test;

import java.text.DecimalFormat;


public class Test {

	public static void main(String[] args){

        /* y = a x + b
		 * b = sum( y ) / n - a * sum( x ) / n
		 * a = ( n * sum( xy ) - sum( x ) * sum( y ) ) / ( n * sum( x^2 ) - sum(x) ^ 2 )
		 * */
		double[] xCPU=new double[]{1000.0,2500.0,4500.0,6000.0,7000.0};
		double[] yCPU=new double[]{0.12,0.24,0.39,0.62,0.68};;
		estimate(xCPU, yCPU, xCPU.length );
		
		double[] xMemory=new double[]{1000.0,2500.0,4500.0,6000.0,7000.0};
		double[] yMemory=new double[]{0.10,0.13,0.17,0.25,0.28};;
		estimate(xMemory, yMemory, xMemory.length );
	}
	/**
	  * Ԥ��
	  * @param x,y,i
	  */
	public static void estimate( double[] x , double[] y , int i ) {
		double a = getA( x , y ) ;
		double b = getB( x , y , a ) ;
		//����doubl�ַ��������ʽ�����Կ�ѧ���������	
		DecimalFormat df=new DecimalFormat("#,##0.000000");//��ʽ������
		System.out.println("y="+df.format(a)+"x"+"+"+df.format(b));
	}
	 
	 /**
	  * ���� x��ϵ��a
	  * @param x, y
	  * @return a
	  */
	 public static double getA( double[] x , double[] y ){
		 int n = x.length ;
		 return ( n * pSum( x , y ) - sum( x ) * sum( y ) )/ ( n * sqSum( x ) - Math.pow(sum(x), 2) ) ;
	 }
	 
	 /**
	  * ���㳣��ϵ��b
	  * @param x,y,a
	  * @returnb
	  */
	 public static double getB( double[] x , double[] y , double a ){
		 int n = x.length ;
		 return sum( y ) / n - a * sum( x ) / n ;
	 }
	 
	 /**
	  * ���㳣��ϵ��b
	  * @param x, y
	  * @return b
	  */
	 public static double getC( double[] x , double[] y ){
		 int n = x.length ;
		 double a = getA( x , y ) ;
		 return sum( y ) / n - a * sum( x ) / n ;
	 }
	 
	 //�����ֵ
	 private static double sum(double[] ds) {
		 double s = 0 ;
		 for( double d : ds ) s = s + d ;
		 return s ;
	 }
	 //���㿪ƽ����ֵ
	 private static double sqSum(double[] ds) {
		 double s = 0 ;
		 for( double d : ds ) s = s + Math.pow(d, 2) ;
		 return s ;
	 }
	 //����x��y���ĺ�ֵ
	 private static double pSum( double[] x , double[] y ) {
		 double s = 0 ;
		 for( int i = 0 ; i < x.length ; i++ ) s = s + x[i] * y[i] ;
		 return s ;
	 }

}
