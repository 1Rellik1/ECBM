package project;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Конфигурация взаимодействия с бд
 */
@Configuration
public class Config {
    //url бд
    @Value("${spring.datasource.url}")
    String url;

    /**
     * Конфигурация бина для взаимодействия с бд
     * @return
     * датасорс
     */
    @Bean
    public HikariDataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername("dyocygvijnzczm");
        config.setPassword("d289b1c93fd9e6777b240337eae1f9f84e1ed808c2f4fdfd4dc3c52533970972");
        config.setUsername("postgres");
        config.setPassword("admin");
        config.setDriverClassName("org.postgresql.Driver");
        return new HikariDataSource(config);
    }

    /**
     * конфигурация бина сессий
     * @param dataSource
     * датасорс
     * @return
     * бин сессий
     */
    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan("project");
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        factoryBean.setHibernateProperties(properties);
        return factoryBean;
    }

    /**
     * конфигурация бина тразнакций
     * @param factoryBean
     * бин сессий
     * @return
     * менеджер транзакций
     */
    @Bean
    public PlatformTransactionManager platformTransactionManager(LocalSessionFactoryBean factoryBean) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(factoryBean.getObject());
        return transactionManager;
    }
}
