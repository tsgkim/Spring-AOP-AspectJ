package com.tu.beans.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ctx.getBean("arithmeticCalculatorImpl");
		
		System.out.println(arithmeticCalculator.getClass().getName());
		
		int result = arithmeticCalculator.add(11, 12);
		System.out.println("result:" + result);
		
		result = arithmeticCalculator.div(21, 3);
		System.out.println("result:" + result);
		
		result = arithmeticCalculator.addThree(15, 3, 9);
		System.out.println("result:" + result);
		
		/**
		 * com.sun.proxy.$Proxy8
			��ǰִ�еķ�����add��ִ�в�����[11, 12]
			��־��Ϣ��¼ֵ��1.ִ�з�����add,2.ִ�в�����[11, 12],3.ִ��ʱ�䣺2016��-03��-18�� 10:32:20
			������ڷ������ؽ��֮��ִ��
			result:23
			
			��ǰִ�еķ�����div��ִ�в�����[21, 3]
			��־��Ϣ��¼ֵ��1.ִ�з�����div,2.ִ�в�����[21, 3],3.ִ��ʱ�䣺2016��-03��-18�� 10:32:20
			������ڷ������ؽ��֮��ִ��
			result:7
			
			��־��Ϣ��¼ֵ��1.ִ�з�����addThree,2.ִ�в�����[15, 3, 9],3.ִ��ʱ�䣺2016��-03��-18�� 10:32:20
			������ڷ������ؽ��֮��ִ��
			result:27
		 */
	}
	
}
