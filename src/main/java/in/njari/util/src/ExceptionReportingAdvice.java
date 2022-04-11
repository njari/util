package in.njari.util.src;

import in.njari.util.src.client.ChatServiceClient;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionReportingAdvice {

    @Autowired
    ChatServiceClient chatServiceClient;

    @Pointcut(value = "bean(*Controller)")
    public void pointcut(){

    }

    @AfterThrowing(value = "pointcut()", throwing = "ex")
    public void afterThrowing(JoinPoint pjp, Exception ex ) throws Throwable {
        System.out.println(pjp.getSignature() + " throws : " + ex.getMessage());

    }
}
