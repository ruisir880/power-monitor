package com.group.monitor.configure;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@MapperScan("com.group.monitor.dao")
public class DataSourceConfig {
    private static final Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

    @Autowired
    private JdbcConfig jdbcConfig;

    @Bean
    @Primary //在同样的DataSource中，首先使用被标注的DataSource
    public DataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(jdbcConfig.getUrl());
        druidDataSource.setUsername(jdbcConfig.getUserName());
        druidDataSource.setPassword(jdbcConfig.getPassword());
        druidDataSource.setInitialSize(jdbcConfig.getInitialSize());
        druidDataSource.setMinIdle(jdbcConfig.getMinIdle());
        druidDataSource.setMaxActive(jdbcConfig.getMaxActive());
        druidDataSource.setTimeBetweenEvictionRunsMillis(jdbcConfig.getTimeBetweenEvictionRunsMillis());
        druidDataSource.setMinEvictableIdleTimeMillis(jdbcConfig.getMinEvictableIdleTimeMillis());
        druidDataSource.setValidationQuery(jdbcConfig.getValidationQuery());
        druidDataSource.setTestWhileIdle(jdbcConfig.isTestWhileIdle());
        druidDataSource.setTestOnBorrow(jdbcConfig.isTestOnBorrow());
        druidDataSource.setTestOnReturn(jdbcConfig.isTestOnReturn());
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(jdbcConfig.getMaxPoolPreparedStatementPerConnectionSize());
        try {
            druidDataSource.setFilters(jdbcConfig.getFilters());
        } catch (SQLException e) {
            if (logger.isInfoEnabled()) {
                logger.info(e.getMessage(), e);
            }
        }
        return druidDataSource;
    }


}