/**
 * Copyright 2018 Velusamy K Velu.  Do not copy this source code or part of this
 * source without express permission from Velusamy K Velu (kool.velu@gmail.com).
 */
package com.peruselabs.peruse.shared;

/**
 * A simple and common exception to be used.
 * 
 * @author Velusamy K. Velu (kool.velu@gmail.com)
 *
 * @since Jan 25, 2018
 *
 */
public class StdException extends Exception {

    private static final long serialVersionUID = 8522420742585157470L;

    public StdException() {
        super();
    }

    public StdException(String message) {
        super(message);
    }

    public StdException(String message, Throwable cause) {
        super(message, cause);
    }

    public StdException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public StdException(Throwable cause) {
        super(cause);
    }
}
