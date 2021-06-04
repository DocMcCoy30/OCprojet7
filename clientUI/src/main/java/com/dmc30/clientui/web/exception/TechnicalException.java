package com.dmc30.clientui.web.exception;

public class TechnicalException extends Exception{

    /**
     * Constructeur.
     *
     * @param pMessage -
     */
    public TechnicalException(String pMessage) {
        super(pMessage);
    }

    /**
     * Constructeur.
     *
     * @param pMessage -
     * @param pCause -
     */
    public TechnicalException(String pMessage, Throwable pCause) {
        super(pMessage, pCause);
    }
}
