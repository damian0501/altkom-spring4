package pl.altkom.shop.aop;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MonitoringAspect {

	Logger LOG = Logger.getLogger(MonitoringAspect.class);

	@Around("@within(pl.altkom.shop.aop.Monitoring) || @annotation(pl.altkom.shop.aop.Monitoring)")
	public Object monitpr(ProceedingJoinPoint pjp) throws Throwable {
		LOG.info("Przed wykonaniem");
		MethodSignature ms = (MethodSignature) pjp.getSignature();
		Method m = ms.getMethod();
		long max = m.getAnnotation(Monitoring.class).maxTime();
		long currentTimeMillis = System.currentTimeMillis();
		Object obj = pjp.proceed();
		long time = System.currentTimeMillis() - currentTimeMillis;
		if (time > max) {
			LOG.error("Po wykonanu " + (time));
		} else {
			LOG.info("Po wykonanu " + (time));
		}
		return obj;
	}

	// @Around("within(pl.altkom.shop..*)")
	public Object monitAll(ProceedingJoinPoint pjp) throws Throwable {
		LOG.info("Przed wykonaniem");
		long currentTimeMillis = System.currentTimeMillis();
		Object obj = pjp.proceed();
		long time = System.currentTimeMillis() - currentTimeMillis;
		LOG.info("After: class: " + pjp.getSignature().getDeclaringType().getSimpleName() + ", method: "
				+ pjp.getSignature().getName() + ", time: " + (time));
		return obj;
	}

	// @Before(value = "@within(pl.altkom.shop.aop.Monitoring) ||
	// @annotation(pl.altkom.shop.aop.Monitoring)")
	public void before(JoinPoint joinPoint) throws Throwable {
		LOG.info("monitor.before, class: " + joinPoint.getSignature().getDeclaringType().getSimpleName() + ", method: "
				+ joinPoint.getSignature().getName());
	}

	// @After(value = "@within(pl.altkom.shop.aop.Monitoring) ||
	// @annotation(pl.altkom.shop.aop.Monitoring)")
	// @After("flow(@annotation(pl.altkom.shop.aop.Monitoring))")
	public void after(JoinPoint joinPoint) throws Throwable {
		LOG.info("monitor.after, class: " + joinPoint.getSignature().getDeclaringType().getSimpleName() + ", method: "
				+ joinPoint.getSignature().getName());
	}

}
