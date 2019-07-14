package cn.tedu.store.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class Log {
	@Before("bean(userService)")
	public void test1(){
		System.out.println("开始....");
	}
	@After("bean(userService)")
	public void test2(){
		System.out.println("结束....");
	}
	//业务方法没有发生异常,执行切面方法
	@AfterReturning("bean(userService)")
	public void test3(){
		System.out.println("无异常方法执行结束");
	}
	//业务方法 发生异常,执行的切面方法
	@AfterThrowing("bean(userService)")
	public void test4(){
		System.out.println("业务方法发生异常");
	}
	//测试业务方法的性能
	/**
	 *1.在业务方法之前获取系统时间
	 *2.在业务方法之后获取系统时间
	 *3.做减法,打印(毫秒)
	 */
	@Around("bean(userService)")
	public Object test5(ProceedingJoinPoint jp) throws Throwable{
		//System.out.println("环绕通知,方法执行之前..");
		long start = System.currentTimeMillis();
		Object obj = jp.proceed();//调用业务方法
		long end = System.currentTimeMillis();
		
		System.out.println("消耗时间:"+(end-start));
		//System.out.println("环绕通知,方法执行之后..");
		
		return obj;
	}
	
	 
	@Before("execution(* cn.tedu.store.service.UserService.login(..))")
	public void test6(){
		System.out.println("切点的定义");
	}
}










