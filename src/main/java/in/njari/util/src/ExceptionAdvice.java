package in.njari.util.src;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class ExceptionAdvice implements ThrowsAdvice {
//
//    void afterThrowing(Throwable e) {
//        System.out.println("Throwing exception :" + e );
//    }

    void afterThrowing(Method m , Object[] args, Object target, Throwable e) {
        System.out.println(m.getName() + " throws : " + e.getMessage());
    }
}
