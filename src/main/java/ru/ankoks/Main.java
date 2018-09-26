package ru.ankoks;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: ankoks
 * Date: 26.09.2018
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        while (true) {
            Thread.sleep(1000);
            context.getBean(Quoter.class).sayQuote();
        }
    }
}
