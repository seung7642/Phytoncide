package com.pangtrue.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.tomcat.jdbc.pool.DataSource; // 커넥션 풀을 위한 자바의 DataSource 인터페이스의 구현체
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.pangtrue.spring.ChangePasswordService;
import com.pangtrue.spring.MemberDao;
import com.pangtrue.spring.MemberRegisterService;

@Configuration
@EnableTransactionManagement
public class MemberConfig {

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        Properties props = new Properties();
        FileInputStream fis = null;
        DataSource ds = new DataSource();
        
        try {
            fis = new FileInputStream("db.properties");
            props.load(fis);
            
            ds.setDriverClassName(props.getProperty("jdbc.driver"));
            ds.setUrl(props.getProperty("jdbc.url"));
            ds.setUsername(props.getProperty("jdbc.username"));
            ds.setPassword(props.getProperty("jdbc.password"));
            ds.setInitialSize(2);
            ds.setMaxActive(10);
            ds.setTestWhileIdle(true);
            ds.setMinEvictableIdleTimeMillis(60000 * 3);
            ds.setTimeBetweenEvictionRunsMillis(10 * 1000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ds;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        DataSourceTransactionManager tm = new DataSourceTransactionManager();
        tm.setDataSource(dataSource());
        return tm;
    }

    @Bean
    public MemberDao memberDao() {
        return new MemberDao(dataSource());
    }

    @Bean
    public MemberRegisterService memberRegSvc() {
        return new MemberRegisterService(memberDao());
    }

    @Bean
    public ChangePasswordService changePwdSvc() {
        ChangePasswordService pwdSvc = new ChangePasswordService();
        pwdSvc.setMemberDao(memberDao());
        return pwdSvc;
    }
}
