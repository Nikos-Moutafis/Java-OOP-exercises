package gr.aueb.cf.ch18.exercise.service.exceptions;

public class InsufficientAmountException extends Exception{
    private static final long serialVersionUID = 1L;

    public InsufficientAmountException(){}

    public InsufficientAmountException(double amount){
        super("Amount " + amount + " is insufficient");
    }

}
