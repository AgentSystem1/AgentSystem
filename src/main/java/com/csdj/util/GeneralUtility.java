package com.csdj.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * ͨ�ù�����
 * @author 29007
 *
 */
public class GeneralUtility {
	
	public static final String NONE=null;
	
	public static String session=null;
	
	
	/**
	 * ˽�л����췽��
	 */
	private GeneralUtility(){}
	
	public static ApplicationContext get_context() {
		System.out.println("得到实列");
		return interiorclass.CONTEXT;
		
	}
	
	/**
	 * SSM��ܶ�ȡ�����ļ�
	 * CONTEXT ͨ��ָ�������ļ�����ApplicationContext����
	 * @author 29007
	 *
	 */
	static class interiorclass{
		public static final ApplicationContext CONTEXT= new ClassPathXmlApplicationContext("applicationContext.xml");
	}
}
