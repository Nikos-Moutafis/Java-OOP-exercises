package gr.aueb.cf.ch18.exercise.service.exceptions;

import gr.aueb.cf.ch18.exercise.model.Account;

public class SsnExistsException extends Exception{
    private final static long serialVersionUID = 1L;

    public SsnExistsException(Account account){
        super ("Account with ssn: " + account.getHolder().getSsn() + "  already exists");
    }
}
