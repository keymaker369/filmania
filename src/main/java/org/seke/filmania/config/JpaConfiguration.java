package org.seke.filmania.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = { "org.seke.filmania.service.impl",
								"org.seke.filmania.dao.impl"})
@PropertySource(value = "classpath:db.properties")
public class JpaConfiguration {

	@Autowired
    private Environment env;
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource bean = new BasicDataSource();
		bean.setDriverClassName("com.mysql.jdbc.Driver");
		bean.setUrl("jdbc:mysql://localhost/filmania");
		bean.setUsername("root");
		bean.setPassword("root");
		bean.setMaxActive(20);
		bean.setInitialSize(10);
		return bean;
	}

	@Bean
	public HibernateJpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter bean = new HibernateJpaVendorAdapter();
		bean.setDatabase(Database.MYSQL);
		bean.setShowSql(true);
		bean.setGenerateDdl(false);
		bean.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
		return bean;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(dataSource());
		bean.setJpaVendorAdapter(jpaVendorAdapter());
		bean.setPersistenceUnitName("persistentObjects");
		return bean;
	}
	
	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager bean = new JpaTransactionManager();
		bean.setEntityManagerFactory(entityManagerFactory().getObject());
		return bean;
	}
	
	@Bean
	public PersistenceAnnotationBeanPostProcessor persistenceAnnotationBeanPostProcessor() {
		return new PersistenceAnnotationBeanPostProcessor();
	}
}
