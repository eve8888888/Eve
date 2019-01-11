package com.xagc.mtms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author: Eve
 * @Date: 2019/1/10 14:24
 * @Version 1.0
 */

@SpringBootApplication
@EnableTransactionManagement
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
