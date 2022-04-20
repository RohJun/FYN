package com.roh.fyn.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {
	@Pointcut("execution(* com.test.app..*Impl.*(..))")
	public void aPointcut() {} // 참조 메서드
	@Pointcut("execution(* com.test.app..*Impl.get*(..))")
	public void bPointcut() {}
}
