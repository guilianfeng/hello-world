package test;

import com.chinamobile.cmss.MyAdd;
import com.mathworks.toolbox.javabuilder.MWException;

public class Test2 {
	public static void main(String[] args){
		try {
			MyAdd myadd= new MyAdd();
			
			   Object result[]= myadd.myadd(1, 3,5);
			   System.out.println("result=="+result[0]);
			  } catch (MWException e) {

			   e.printStackTrace();
			  }

	}
}
