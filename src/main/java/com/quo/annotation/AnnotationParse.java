package com.quo.annotation;

import java.lang.reflect.Method;

/** 

* @author zhoumin

*/

public class AnnotationParse {
	
	/**
	 * targetClass  目标类的class字节码文件
	 * methodName 在客户端调用哪个 方法，methodname
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public static String parse(Class targetClass,String mthodName) throws NoSuchMethodException, SecurityException{
		
		String methodAccess="";
		/**
		 * 该方法没有参数
		 */
      Method method= targetClass.getMethod(mthodName);
      //判断传入的字节码文件的方法上是否 有 Permission注解
       if(method.isAnnotationPresent(Permission.class)){
    	   //得到方法上面的注解
    	   Permission permission=  method.getAnnotation(Permission.class);
    	  methodAccess = permission.name();
       }
       return methodAccess;
	}



}
