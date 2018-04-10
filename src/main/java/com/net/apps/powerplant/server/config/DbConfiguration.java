package com.net.apps.powerplant.server.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import liquibase.integration.spring.SpringLiquibase;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.net.apps.powerplant.server.db.mapper")
public class DbConfiguration {

    @Bean
    public SpringLiquibase liquibase(HikariDataSource liquibaseDataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:assets/db.migration/db.changelog.xml");
        liquibase.setDataSource(liquibaseDataSource);
        return liquibase;
    }

    @Bean
    public HikariConfig dbConfig() {
        // TODO remplacer config.yml
        HikariConfig config = new HikariConfig();
        config.setDataSourceClassName("org.h2.jdbcx.JdbcDataSource");
        config.setJdbcUrl("jdbc:h2:~/test/ma_centrale;AUTO_SERVER=TRUE");
        config.setUsername("sa");
        config.setPassword("sa");
        config.addDataSourceProperty("url", "jdbc:h2:~/test/ma_centrale;AUTO_SERVER=TRUE");
        config.addDataSourceProperty("user", "sa");
        config.addDataSourceProperty("password", "sa");

        config.setConnectionTestQuery("VALUES 1");
        boolean isUsingJmx = true;

        config.setAutoCommit(false);
        config.setPoolName("SpringPool");
        config.setMaximumPoolSize(10);
        config.setRegisterMbeans(isUsingJmx);
//        config.setThreadFactory(new ConnectionPoolThreadFactory());
        return config;
    }

    @Bean
    public HikariConfig liquibaseConfig() {
        // TODO remplacer config.yml
        HikariConfig config = new HikariConfig();
        config.setDataSourceClassName("org.h2.jdbcx.JdbcDataSource");
        config.addDataSourceProperty("url", "jdbc:h2:~/test/ma_centrale;AUTO_SERVER=TRUE");
        config.addDataSourceProperty("user", "sa");
        config.addDataSourceProperty("password", "sa");

        config.setConnectionTestQuery("VALUES 1");
        boolean isUsingJmx = true;

        config.setAutoCommit(false);
        config.setPoolName("LiquibasePool");
        config.setMaximumPoolSize(10);
        config.setRegisterMbeans(isUsingJmx);
        return config;
    }

    @Bean
    public HikariDataSource liquibaseDataSource(HikariConfig liquibaseConfig){
        // TODO different pool size for liquibase. Only one connection authorized
        return new HikariDataSource(liquibaseConfig);
    }

    /**
     * Use data source different one for liquibase to update the db and one for the server backend use
     * @param dbConfig
     * @return
     */
    @Bean
    public DataSource dataSource(HikariConfig dbConfig){
        return new HikariDataSource(dbConfig);
    }

    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(ApplicationContext applicationContext, DataSource dataSource) throws Exception{
//        TransactionFactory transactionFactory = new JdbcTransactionFactory();
//        Environment environment = new Environment("development", transactionFactory, dataSource);
//        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration(environment);
//
//        Map<String, Object> mapperBeans = applicationContext.getBeansWithAnnotation(Mapper.class);
//        mapperBeans.forEach((name, bean) -> configuration.addMapper(bean.getClass()));
//
//        return new SqlSessionFactoryBuilder().build(configuration);

        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        return sessionFactory.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSession(SqlSessionFactory factory){
        return new SqlSessionTemplate(factory);
    }
}
