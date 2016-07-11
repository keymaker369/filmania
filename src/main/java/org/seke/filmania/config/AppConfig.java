package org.seke.filmania.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
@ComponentScan(basePackages = { "org.seke.filmania.service.impl",
								"org.seke.filmania.dao.impl"})
public class AppConfig {

	@Autowired
    Environment env;
	
	@Bean
	public PropertyPlaceholderConfigurer placeholderConfig() {
		PropertyPlaceholderConfigurer bean = new PropertyPlaceholderConfigurer();
		Resource[] resources = new ClassPathResource[]
			    { new ClassPathResource("db.properties") };
		bean.setLocations( resources );
		return bean;
	}
	
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource bean = new BasicDataSource();
		bean.setDriverClassName(env.getProperty("db.driver"));
		bean.setUrl(env.getProperty("db.url"));
		bean.setUsername(env.getProperty("db.username"));
		bean.setPassword(env.getProperty("db.password"));
		bean.setMaxActive(Integer.parseInt(env.getProperty("db.maxActive")));
		bean.setInitialSize(Integer.parseInt(env.getProperty("db.initialSize")));
		return bean;
	}
}
