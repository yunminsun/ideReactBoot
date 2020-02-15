package ide.com.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Component
@Aspect
public class LogerAspect {
	
	static String className = "";
	static String methodName = "";
	
	@Pointcut("execution(* ide..apps..controller.*Controller.*(..))")
	public void presentationLayer() {
	}

	@Pointcut("execution(* ide..apps..service.*Impl.*(..))")
	public void serviceLayer() {
	}

	@Pointcut("execution(* ide..apps..mapper.*Mapper.*(..))")
	public void persistenceLayer() {
	}
	
	@Before("presentationLayer()")
	public void presentation(Joinpoint joinPoint) {
		//log.info("[Controller] : {}()", joinPoint.getSignature().getName());
	}
	
	@Around("serviceLayer()")
	public Object service(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();

		try {
			Signature signature = joinPoint.getSignature();
			className = joinPoint.getTarget().getClass().getName();
			methodName = signature.getName().toString();
			
			log.info("[ServiceImpl] : {}.{}()", className, methodName);
			//핵심 로직 이동
			Object result = joinPoint.proceed();
			
			return result;
		
		} finally {
			long end = System.currentTimeMillis();
			log.info(joinPoint.getSignature().toShortString() + " runtime : " + (end - start) + "ms");
		}
	}
	
	@Around("persistenceLayer()")
	public Object persistence(ProceedingJoinPoint joinPoint) throws Throwable {
		
		//Signature signature = joinPoint.getSignature();
		//className = signature.getDeclaringTypeName();
		//methodName = signature.getName().toString();
		
		//log.info("[Mapper] : {}.{}()", className, methodName);

		return joinPoint.proceed();
	}
}
