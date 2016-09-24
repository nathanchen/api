package info.chenqin.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * User: nathanchen
 * <p/>
 * Date: 18/09/2016
 * <p/>
 * Time: 1:40 PM
 * <p/>
 * Description:
 */
@Aspect
@Repository
public class RequestAOP
{
    private Logger logger = LoggerFactory.getLogger(RequestAOP.class);

    @Around(value = "execution(public * cn.hao24.mobile.controller..*.*(..))")
    public Object doAround (ProceedingJoinPoint proceedingJoinPoint)
    {
        return getProceed(proceedingJoinPoint);
    }

    private Object getProceed (ProceedingJoinPoint proceedingJoinPoint)
    {
        long start_time = System.currentTimeMillis();
        Object resp = null;
        try
        {
            resp = proceedingJoinPoint.proceed();
        }
        catch (Throwable throwable)
        {
            logger.error("AOP Exception", throwable);
        }

        long end_time = System.currentTimeMillis();

        logger.info("Beginning method: " + proceedingJoinPoint.getTarget().getClass().getName() + "." + proceedingJoinPoint.getSignature().getName()
                + "\tRequest end. This request cost [" + (end_time - start_time) + " ms] time.");
        return resp;
    }
}
