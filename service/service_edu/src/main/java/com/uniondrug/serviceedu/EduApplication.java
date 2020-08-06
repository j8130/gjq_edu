package com.uniondrug.serviceedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author ：SaoBai
 * @motto ：不忘初心
 * @date ：Created in 2020/8/6 14:15
 * @Function :
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.uniondrug"})
public class EduApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class, args);
    }
}
