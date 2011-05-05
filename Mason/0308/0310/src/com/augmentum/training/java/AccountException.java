package com.augmentum.training.java;

/**
 * The class <code>AccountException</code> are the subclass of 
 * <code>Exception</code> that indicates the potential Exception in 
 * the Bank System.
 *
 * @author   mason.xu
 * @version 1.0 , 03/10/2011
 */
public class AccountException extends Exception {

    private static final long serialVersionUID = 1L;

    public AccountException() {
        super();
    }

    public AccountException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountException(String message) {
        super(message);
    }

    public AccountException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

}
