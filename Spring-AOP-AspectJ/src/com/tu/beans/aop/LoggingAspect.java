package com.tu.beans.aop;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * AOP �� helloWorld
 * 1. ���� jar ��
 * com.springsource.net.sf.cglib-2.2.0.jar
 * com.springsource.org.aopalliance-1.0.0.jar
 * com.springsource.org.aspectj.weaver-1.6.8.RELEASE.jar
 * spring-aspects-4.0.0.RELEASE.jar
 * 
 * 2. �� Spring �������ļ��м��� aop �������ռ䡣 
 * 
 * 3. ����ע��ķ�ʽ��ʹ�� AOP
 * 3.1 �������ļ��������Զ�ɨ��İ�: <context:component-scan base-package="com.xt.beans.aop"></context:component-scan>
 * 3.2 ����ʹ AspjectJ ע�������õ�����: <aop:aspectj-autoproxy></aop:aspectj-autoproxy>
 * Ϊƥ������Զ����ɶ�̬�������. 
 * 
 * 4. ��д������: 
 * 4.1 һ��һ��� Java ��
 * 4.2 ���������Ҫ����ʵ�ֵĹ���. 
 *
 * 5. ��������
 * 5.1 ��������� IOC �е� bean: ʵ������� @Component ע��
 * 5.2 ������һ������: ��� @Aspect
 * 5.3 ����֪ͨ: ��������빦�ܶ�Ӧ�ķ���. 
 * 5.3.1 ǰ��֪ͨ: @Before("execution(public int com.xt.beans.aop.ArithmeticCalculator.*(int, int))")
 * @Before ��ʾ��Ŀ�귽��ִ��֮ǰִ�� @Before ��ǵķ����ķ�����. 
 * @Before ��������������ʽ: 
 * 
 * 6. ��֪ͨ�з�������ϸ��: ������֪ͨ��������� JoinPoint ���͵Ĳ���, ���п��Է��ʵ�������ǩ���ͷ����Ĳ���. 
 * 
 * 7. @Before:ǰ��֪ͨ���ڷ���ִ��֮ǰִ��
 * 	  @After ��ʾ����֪ͨ: �ڷ���ִ��֮��ִ�еĴ���
 * 						�������ӵ����֮��ִ�еģ������ӵ㷵�ؽ�������׳��쳣��ʱ��
 * 	  @AfterRunning:����֪ͨ���ڷ������ؽ��֮��ִ�� 
 * 					�������ӵ��Ƿ��������ػ����׳��쳣������֪ͨ����ִ��
 * 					���ֻ�������ӵ㷵�ص�ʱ���¼��־��Ӧʹ�÷���֪ͨ�������֪ͨ
 * 	  @AfterThrowing:�쳣֪ͨ���ڷ����׳��쳣֮��
 * 	  @Around:����֪ͨ��Χ���ŷ���ִ��
 * 		
 */


//ͨ����� @Aspect ע������һ�� bean ��һ������!
@Aspect
@Component
public class LoggingAspect {
	
	@Before("execution(public int com.tu.beans.aop.ArithmeticCalculator.*(int, int))")
	public void beforMethod(JoinPoint joinPoint){
		System.out.println("��ǰִ�еķ�����"+joinPoint.getSignature().getName()
				+"��ִ�в�����"+Arrays.toString(joinPoint.getArgs()));
	}
	
	//�������е��࣬����������
	@After("execution(* *.*(..))")  
	public void afterMethod(JoinPoint joinPoint){
		System.out.println("��־��Ϣ��¼ֵ��1.ִ�з�����"+joinPoint.getSignature().getName()
				+",2.ִ�в�����"+Arrays.toString(joinPoint.getArgs())
				+",3.ִ��ʱ�䣺"+new SimpleDateFormat("yyyy��-MM��-dd�� hh:mm:ss").format(new Date()));
	}
	
	@Pointcut("execution(* *.*(..))")
	public void pointCut(){}
	
	//�������ʽ����ͨ�������� && || ! �������
	@AfterReturning("pointCut()")
	public void afterRunningMethod(JoinPoint joinPoint){
		System.out.println("������ڷ������ؽ��֮��ִ��");
	}
	
//	@AfterThrowing("pointCut()")
//	public void afterThrowing(JoinPoint joinPoint,Exception e){
//		System.out.println("һ������"+e+"��ִ�з���"+joinPoint.getSignature().getName()+"()ʱ���׳���");
//	}
	
	

}
