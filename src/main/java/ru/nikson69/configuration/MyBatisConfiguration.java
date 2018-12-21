package ru.nikson69.configuration;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "ru.nikson69.configuration" })
@PropertySource(value = { "classpath:application.properties" })
@MapperScan("ru.nikson69.dao.mybatis.mappers")
public class MyBatisConfiguration {

    @Autowired
    private Environment environment;

    @Autowired
    private DataSource dataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        return sqlSessionFactory.getObject();
    }

    @Bean
    public Object[] mappers() throws Exception {
        SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(sqlSessionFactory());

        String[] mapperNames = environment.getRequiredProperty("mybatis.mappers.mappers").split(",");
        String mappersPackage = environment.getRequiredProperty("mybatis.mappers.package");
        List<Object> mappers = new ArrayList<>();
        for (String mapperName : mapperNames) {
            mappers.add(sessionTemplate.getMapper(Class.forName(mappersPackage + '.' + mapperName)));
        }
        return mappers.toArray();
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}
