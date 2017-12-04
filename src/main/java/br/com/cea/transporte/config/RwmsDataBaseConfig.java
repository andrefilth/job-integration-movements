package br.com.cea.transporte.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(	  entityManagerFactoryRef = "rmsEntityManagerFactory"
						, transactionManagerRef = "rmsTransactionManager"
						, basePackages = {"br.com.cea.transporte.movements.batch.rms.repository" })
public class RwmsDataBaseConfig {

	@Bean(name = "rwmDataSource")
	@ConfigurationProperties(prefix = "spring.rms.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create()
							    .build();
	}

	@Bean(name = "rmsEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean rmsEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("rwmDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource)
				      .packages("br.com.cea.transporte.movements.batch.rms.model")
				      .persistenceUnit("rwms")
				      .build();
	}

	@Bean(name = "rmsTransactionManager")
	public PlatformTransactionManager rmsTransactionManager(
			@Qualifier("rmsEntityManagerFactory") EntityManagerFactory EntityManagerFactory) {
		return new JpaTransactionManager(EntityManagerFactory);
	}

}
