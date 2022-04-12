package in.njari.util.src;

import in.njari.util.src.client.ChatServiceClient;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class ExceptionReportingAdvice {

    private static final String TO = "to";
    private static final String CONTENT = "content";
    private static final String SUBJECT = "subject";
    public static final Map<String,String> emailMap = new HashMap<>();

    @PostConstruct
    public void init(){
        emailMap.put(TO, "nubra.jarial@dealshare.in");
    }

    @Autowired
    ChatServiceClient chatServiceClient;

    @Pointcut(value = "bean(*Controller)")
    public void pointcut(){
    }

    @AfterThrowing(value = "pointcut()", throwing = "ex")
    public void afterThrowing(JoinPoint pjp, Exception ex ) throws Throwable {
        System.out.println(pjp.getSignature() + ex.getMessage());

        emailMap.put(SUBJECT, ex.getMessage());
        StringBuilder content = new StringBuilder();
        for (int i = 0 ; i < ex.getStackTrace().length && i < 10 ;i++ ){
            content.append(ex.getStackTrace()[i]);
            content.append("<br/>");
        }
        emailMap.put(CONTENT, content.toString());
        chatServiceClient.sendEmail(emailMap);
    }
}
