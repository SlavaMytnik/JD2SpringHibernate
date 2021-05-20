package org.example.jd2p2v2.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.example.jd2p2v2.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import org.example.jd2p2v2.entity.User;

@Configuration
@EnableTransactionManagement
@PropertySource(ConfigAttr.PROPERTY_SOURCE)
@ComponentScan(ConfigAttr.COMPONENT_SCAN)
public class HibernateConfig {
    private final Environment environment;

    @Autowired
    public HibernateConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(
                environment.getProperty(ConfigAttr.DB_DRIVER));
        dataSource.setUrl(environment.getProperty(ConfigAttr.DB_URL));
        dataSource.setUsername(environment.getProperty(ConfigAttr.DB_USERNANE));
        dataSource.setPassword(environment.getProperty(ConfigAttr.DB_PASSWORD));

        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(getDataSource());

        Properties props = new Properties();
        props.put(ConfigAttr.HIBERNATE_SHOW_SQL,
                environment.getProperty(ConfigAttr.HIBERNATE_SHOW_SQL));
        props.put(ConfigAttr.HIBERNATE_DLL_AUTO,
                environment.getProperty(ConfigAttr.HIBERNATE_DLL_AUTO));

        factoryBean.setHibernateProperties(props);
        factoryBean.setAnnotatedClasses(User.class, News.class);

        return factoryBean;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager =
                new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());

        return transactionManager;
    }
}
