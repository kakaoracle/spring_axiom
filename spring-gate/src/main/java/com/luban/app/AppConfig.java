package com.luban.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan("com")
//@ImportResource("classpath:spring.xml")
@EnableAspectJAutoProxy
public class AppConfig {

}
