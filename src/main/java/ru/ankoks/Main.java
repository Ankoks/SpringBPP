package ru.ankoks;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: ankoks
 * Date: 26.09.2018
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        context.getBean(TerminatorQuoter.class).sayQuote();
    }
}
