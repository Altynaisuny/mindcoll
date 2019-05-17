package com.sunyt.mindcoll.basicAspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
@Aspect
public class WebExceptionAspect {
    private static final Logger logger = LoggerFactory.getLogger(WebExceptionAspect.class);

    /**
     * 凡是注解了RequestMapping的方法都被拦截
     */
    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    private void webPointcut() {
    }

    @AfterThrowing(pointcut = "webPointcut()", throwing = "e")
    public void handleThrowing(Exception e){
        e.printStackTrace();
        logger.error("get error ! message = " + e.getMessage());
        //页面要显示的内容
    }
}
