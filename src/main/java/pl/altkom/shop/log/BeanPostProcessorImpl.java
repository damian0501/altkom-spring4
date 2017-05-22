package pl.altkom.shop.log;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class BeanPostProcessorImpl implements BeanPostProcessor {

	private Logger LOG = Logger.getLogger(BeanPostProcessorImpl.class);

	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1) throws BeansException {
		LOG.info("After Initialization: " + arg1);
		return arg0;
	}

	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1) throws BeansException {
		LOG.info("Before Initialization: " + arg1);
		return arg0;
	}

}
