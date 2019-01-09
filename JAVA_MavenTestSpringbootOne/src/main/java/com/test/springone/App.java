package com.test.springone;

/**
 * @Author: Eve
 * @Date: 2019/1/9 14:30
 * @Version 1.0
 */
@SpringBootApplication
@EnableTransactionManagement
public class App {
    public static void main(String[] args) {
        SpringAppliaction.run(App.class);
    }
}
