package ru.ankoks;

/**
 * User: ankoks
 * Date: 26.09.2018
 */
public class TerminatorQuoter implements Quoter {

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public void sayQuote() {
        System.out.println("message = " + message);
    }
}
