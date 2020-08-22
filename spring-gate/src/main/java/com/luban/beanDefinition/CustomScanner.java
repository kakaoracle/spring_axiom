package com.luban.beanDefinition;

import com.luban.annotation.KakaScan;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.TypeFilter;

public class CustomScanner extends ClassPathBeanDefinitionScanner {


	public CustomScanner(BeanDefinitionRegistry registry) {
		super(registry);
	}
	@Override
	protected  boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition){
		AnnotationMetadata metadata = beanDefinition.getMetadata();
		return metadata.isInterface();
	}

	/*@Override
	public void addIncludeFilter(TypeFilter includeFilter){

		// addIncludeFilter使用方法直接参照其父类就好
		super.addIncludeFilter(includeFilter);
	}*/
}
