package gr.aueb.cf.ch18.exercise.service.exceptions;

public class InsufficientBalanceException extends Exception{
    private static final long serialVersionUID = 1L;

    public InsufficientBalanceException(){}

    public InsufficientBalanceException (double balance, double amount) {
        super ("insufficient balance: " + balance + " for amount: " + amount);
    }

}
