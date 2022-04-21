package com.roh.fyn.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import com.roh.fyn.nft.NftVO;
import com.roh.fyn.member.MemberVO;

@Service
@Aspect // == 결합 : 포인트컷 + 어드바이스
public class LogAdvice {
	@Before("PointcutCommon.bPointcut()")
	public void beforeLog(JoinPoint jp) {
		// jp -> 어떤 핵심관심이 호출되었는지에대한 정보가 담겨있음!
		String methodName=jp.getSignature().getName();
		System.out.println(" [beforeLog] 호출된 핵심관심: "+methodName);
		Object[] args=jp.getArgs();
		System.out.println("사용된 인자");
		for(Object v:args) {
			System.out.println(v);
		}
	}
	@AfterReturning(pointcut="PointcutCommon.bPointcut()",returning="returnObj")
	public void arLog(JoinPoint jp,Object returnObj) {
		// Object returnObj : 바인드 변수 -> 컨테이너에게 설정을 해주어야한다!!!
		String methodName=jp.getSignature().getName();
		System.out.println(" [arLog] 호출된 핵심관심: "+methodName);
		System.out.println("반환값: "+returnObj);
		if(returnObj instanceof MemberVO) { // 캐스팅 가능여부를 확인하는 로직
			MemberVO vo= (MemberVO)returnObj; // 다운캐스팅
			if(vo.getMemRank()== 1) {
				System.out.println("+++++ ADMIN +++++");
			}
			else {
				System.out.println(" 일반사용자 입장 ");
			}
		}
		else if(returnObj instanceof NftVO) {
			System.out.println("Board정보를 반환받았습니다.");
		}
		else {
			System.out.println("알수없는 반환값입니다.");
		}
	}
	@AfterThrowing(pointcut="PointcutCommon.aPointcut()",throwing="excepObj")
	public void atLog(JoinPoint jp,Exception excepObj) {
		String methodName=jp.getSignature().getName();
		System.out.println(" [atLog] 호출된 핵심관심: "+methodName);
		System.out.println("반환된 예외: "+excepObj);
		if(excepObj instanceof IllegalArgumentException) {
			System.out.println("실습을위해서 일부러 예외를 만든상황입니다.");
		}
		else if(excepObj instanceof NumberFormatException) { // 예외 확인후 추가가능
			System.out.println("타입이 올바르지않습니다.");
		}
		else if(excepObj instanceof Exception) {
			System.out.println("미확인 예외발생!!!");
		}
	}
	@Around("PointcutCommon.aPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		StopWatch sw=new StopWatch();
		sw.start();
		Object obj=pjp.proceed(); // 수행할 핵심관심
		sw.stop();
		String methodName=pjp.getSignature().getName();
		System.out.println(" [aroundLog] 호출된 핵심관심: "+methodName);
		System.out.println("걸린시간: "+sw.getTotalTimeMillis());
		return obj;
	}
}
