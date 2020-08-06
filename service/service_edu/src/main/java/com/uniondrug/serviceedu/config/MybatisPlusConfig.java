package com.uniondrug.serviceedu.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author ：SaoBai
 * @motto ：不忘初心
 * @date ：Created in 2020/8/6 14:16
 * @Function :
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.uniondrug.serviceedu.mapper")
public class MybatisPlusConfig {
    //逻辑删除插件
    @Bean
    public ISqlInjector sqlInjector(){
        return new LogicSqlInjector();
    }

    //分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor(){
       return new PaginationInterceptor();
    }
}
