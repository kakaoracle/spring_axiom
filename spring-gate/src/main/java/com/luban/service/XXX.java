package com.luban.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.stereotype.Component;

// 实现后置处理器接口
@Component
public class XXX implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		BeanDefinition indexService1 = beanFactory.getBeanDefinition("indexService1");
		// 注意inferMethod
		indexService1.setDestroyMethodName(AbstractBeanDefinition.INFER_METHOD);
	}
}
