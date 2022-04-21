package com.roh.fyn.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {
	@Pointcut("execution(* com.roh.fyn..*Impl.*(..))")
	public void aPointcut() {} // 참조 메서드
	@Pointcut("execution(* com.roh.fyn..*Impl.get*(..))")
	public void bPointcut() {}
}
