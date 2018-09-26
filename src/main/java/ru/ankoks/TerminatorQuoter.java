package ru.ankoks;

import javax.annotation.PostConstruct;

/**
 * User: ankoks
 * Date: 26.09.2018
 */
public class TerminatorQuoter implements Quoter {

    @InjectRandomInt(min = 2, max = 7)
    private int repeat;

    private String message;

    @PostConstruct
    public void init() {
        System.out.println("Phase 2 - INIT method");
        System.out.println(repeat);
    }

    public TerminatorQuoter() {
        System.out.println("Phase 1 - Constructor");
        System.out.println(repeat);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println("message = " + message);
        }
    }
}
