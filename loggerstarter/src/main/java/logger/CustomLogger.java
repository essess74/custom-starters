package logger;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

@Aspect
public class CustomLogger {

    @Around("@annotation(logger.annotation.Loggable)")
    public Object logTimeMethod(final ProceedingJoinPoint joinPoint) throws Throwable {
        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final Object retVal = joinPoint.proceed();
        stopWatch.stop();

        final Log logger = LogFactory.getLog(joinPoint.getTarget().getClass());

        if (logger.isInfoEnabled()) {
            final StringBuffer logMessage = new StringBuffer();
            logMessage.append(joinPoint.getSignature().getName());
            logMessage.append("( ");
            // append args
            final Object[] args = joinPoint.getArgs();
            logMessage.append(StringUtils.join(args, ", "));
            logMessage.append(" )");
            logMessage.append(" execution time: ");
            logMessage.append(stopWatch.getTotalTimeMillis());
            logMessage.append(" ms");
            logger.info(logMessage.toString());
        }
        return retVal;
    }

}
