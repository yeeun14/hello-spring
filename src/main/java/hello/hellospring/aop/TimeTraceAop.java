package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TimeTraceAop {

    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {

    }
}
